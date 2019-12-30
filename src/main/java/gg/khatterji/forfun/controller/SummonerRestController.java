package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    private final RiotSummonerService riotSummonerService;
    private final RiotLeagueService riotLeagueService;

    @Autowired
    public SummonerRestController(RiotSummonerService riotSummonerService, RiotLeagueService riotLeagueService) {
        this.riotSummonerService = riotSummonerService;
        this.riotLeagueService = riotLeagueService;
    }

    @GetMapping("/{name}")
    @ResponseBody
    public List<RiotLeagueEntry> getSummoner(@PathVariable String name, @RequestHeader String region) {
            RiotSummoner riotSummoner = riotSummonerService.build(region)
                                                           .getSummonerByName(name);
            return riotLeagueService.build(region)
                                    .getEntriesBySummonerId(riotSummoner.getId());
    }
}
