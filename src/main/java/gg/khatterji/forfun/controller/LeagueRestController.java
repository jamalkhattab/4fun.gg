package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
public class LeagueRestController {
    private final RiotLeagueService riotLeagueService;

    @Autowired
    public LeagueRestController(RiotLeagueService riotLeagueService){
        this.riotLeagueService = riotLeagueService;
    }

    @GetMapping("/{encryptedSummonerId}/{region}")
    @ResponseBody
    public RiotLeagueEntry[] getEntries(@PathVariable String encryptedSummonerId, @PathVariable String region) {
        riotLeagueService.execute(region);
        RiotLeagueEntry[] leagueEntries = riotLeagueService.getEntriesBySummonerId(encryptedSummonerId);
        return leagueEntries;
    }
}
