package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.forfun.LeagueService;
import gg.khatterji.forfun.service.forfun.SummonerService;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    private final RiotSummonerService riotSummonerService;
    private final RiotLeagueService riotLeagueService;
    private final SummonerService summonerService;
    private final LeagueService leagueService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SummonerRestController(RiotSummonerService riotSummonerService, RiotLeagueService riotLeagueService, SummonerService summonerService, LeagueService leagueService) {
        this.riotSummonerService = riotSummonerService;
        this.riotLeagueService = riotLeagueService;
        this.summonerService = summonerService;
        this.leagueService = leagueService;
    }

    @GetMapping("/{name}")
    @ResponseBody
    public SummonerDTO getSummoner(@PathVariable String name, @RequestHeader String region) {
        Summoner summoner = summonerService.findByNameAndRegion(name, region);
        if(summoner == null) {
            RiotSummoner riotSummoner = riotSummonerService.build(region)
                                                            .getSummonerByName(name);
            summoner = summonerService.convertAndSaveOrUpdateSummoner(riotSummoner, region);

            List<RiotLeagueEntry> riotLeagueEntries = riotLeagueService.build(region)
                                                                       .getEntriesBySummonerId(riotSummoner.getId());

            leagueService.convertAndSaveOrUpdateLeagueEntries(summoner, riotLeagueEntries);
            List<LeagueEntryDTO> leagueEntryDTOS = riotLeagueEntries.stream()
                                                                    .map(leagueService::convertToDTO)
                                                                    .collect(Collectors.toList());
            return summonerService.convertFromRiotSummonerToDTO(riotSummoner, region, leagueEntryDTOS);
        } else {
            LocalDateTime summonerTime = LocalDateTime.ofInstant(summoner.getLastUpdatedDate().toInstant(), ZoneId.systemDefault());
            LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());

            LocalDateTime fromTemp = LocalDateTime.from(summonerTime);
            long secondsAfterUpdate = fromTemp.until(currentTime, ChronoUnit.SECONDS);
            logger.info("current time " + currentTime + "summonerTime: " + summonerTime);
            logger.info("secondsAfterUpdate: " + secondsAfterUpdate);
            if(secondsAfterUpdate >= 120) {
                RiotSummoner riotSummoner = riotSummonerService.build(region)
                                                                .getSummonerByName(name);
                summoner = summonerService.convertAndUpdateSummoner(summoner, riotSummoner, region);

                List<RiotLeagueEntry> riotLeagueEntries = riotLeagueService.build(region)
                        .getEntriesBySummonerId(riotSummoner.getId());

                leagueService.convertAndSaveOrUpdateLeagueEntries(summoner, riotLeagueEntries);
                List<LeagueEntryDTO> leagueEntryDTOS = riotLeagueEntries.stream()
                                                                        .map(leagueService::convertToDTO)
                                                                        .collect(Collectors.toList());
                return summonerService.convertFromRiotSummonerToDTO(riotSummoner, region, leagueEntryDTOS);
            } else {
                List<LeagueEntry> leagueEntries = leagueService.findLeagueEntriesBySummonerId(summoner.getId());
                List<LeagueEntryDTO> dtos = leagueEntries.stream().map(leagueService::convertToDTO).collect(Collectors.toList());
                currentTime = LocalDateTime.now(ZoneId.systemDefault());
                long lastUpdatedDateInSeconds= fromTemp.until(currentTime, ChronoUnit.SECONDS);
                long timeLeftForUpdate = 120 - lastUpdatedDateInSeconds;
                return summonerService.convertFromSummonerToDTO(summoner, region, dtos , timeLeftForUpdate);
            }
        }
    }

}
