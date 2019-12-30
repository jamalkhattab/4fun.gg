package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league")
public class LeagueRestController {
    private final RiotLeagueService riotLeagueService;

    @Autowired
    public LeagueRestController(RiotLeagueService riotLeagueService) {
        this.riotLeagueService = riotLeagueService;
    }

    @GetMapping("/{encryptedSummonerId}")
    @ResponseBody
    public List<RiotLeagueEntry> getEntries(@PathVariable String encryptedSummonerId, @RequestHeader String region) {
        return riotLeagueService.build(region)
                .getEntriesBySummonerId(encryptedSummonerId);
    }
}
