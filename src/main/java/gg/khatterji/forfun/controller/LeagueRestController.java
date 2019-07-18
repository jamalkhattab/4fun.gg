package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/league")
public class LeagueRestController {
    @Autowired
    RiotLeagueService riotLeagueService;

    @GetMapping("/{encryptedSummonerId}")
    @ResponseBody
    public RiotLeagueEntry[] getEntries(@PathVariable String encryptedSummonerId) {
        riotLeagueService.execute("eune");
        RiotLeagueEntry[] leagueEntries = riotLeagueService.getEntriesBySummonerId(encryptedSummonerId);
        return leagueEntries;
    }

}
