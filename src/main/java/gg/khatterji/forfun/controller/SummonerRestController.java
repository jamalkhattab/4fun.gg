package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.constant.ForFunTimeConstants;
import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.forfun.LeagueService;
import gg.khatterji.forfun.service.forfun.SummonerService;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import gg.khatterji.forfun.service.utility.TimeDecisionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summoner")
@CrossOrigin
public class SummonerRestController {
    private final RiotSummonerService riotSummonerService;
    private final RiotLeagueService riotLeagueService;
    private final SummonerService summonerService;
    private final LeagueService leagueService;
    private final TimeDecisionHandler timeDecisionHandler;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SummonerRestController(RiotSummonerService riotSummonerService, RiotLeagueService riotLeagueService, SummonerService summonerService, LeagueService leagueService,
                                  TimeDecisionHandler timeDecisionHandler) {
        this.riotSummonerService = riotSummonerService;
        this.riotLeagueService = riotLeagueService;
        this.summonerService = summonerService;
        this.leagueService = leagueService;
        this.timeDecisionHandler = timeDecisionHandler;
    }

    @GetMapping("/{name}")
    @ResponseBody
    public SummonerDTO getSummoner(@PathVariable String name, @RequestHeader String region) {
        Summoner summoner = summonerService.findByNameAndRegion(name, region);
        if(summoner == null) {
            RiotSummoner riotSummoner = riotSummonerService.build(region)
                                                            .getSummonerByName(name);
            List<RiotLeagueEntry> riotLeagueEntries = riotLeagueService.build(region)
                                                                        .getEntriesBySummonerId(riotSummoner.getId());
            return summonerService.saveSummonerAndLeagueEntries(riotSummoner, riotLeagueEntries, region);
        }

        if(timeDecisionHandler.getTimeElapedSinceLastUpdate(summoner.getLastUpdatedDate()) >= ForFunTimeConstants.SECONDS_FOR_UPDATE) {
            RiotSummoner riotSummoner = riotSummonerService.build(region)
                                                            .getSummonerByName(name);
            List<RiotLeagueEntry> riotLeagueEntries = riotLeagueService.build(region)
                                                                        .getEntriesBySummonerId(riotSummoner.getId());
            return summonerService.updateSummonerAndLeagueEntries(summoner.getId(), riotSummoner, riotLeagueEntries, region);
        }

        List<LeagueEntryDTO> leagueEntryDTOs = leagueService.findLeagueEntriesBySummonerIdAndConvertToDTOs(summoner.getId());
        long timeLeftForUpdate = timeDecisionHandler.getTimeLeftForUpdate(summoner.getLastUpdatedDate());
        return summonerService.convertFromSummonerToDTO(summoner, region, leagueEntryDTOs , timeLeftForUpdate);
    }
}
