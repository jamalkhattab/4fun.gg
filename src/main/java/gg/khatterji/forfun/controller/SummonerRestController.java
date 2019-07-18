package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.forfun.SummonerService;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    @Autowired
    SummonerService summonerService;
    @Autowired
    RiotSummonerService riotSummonerService;
    @Autowired
    RiotLeagueService riotLeagueService;

    @GetMapping("/{name}")
    @ResponseBody
        public RiotLeagueEntry[] getSummoner(@PathVariable String name) {
        riotSummonerService.execute("eune");
        RiotSummoner riotSummoner = riotSummonerService.getSummonerByName(name);
        //ESPBrdiPMblfEBf3yRm3fZusyBsfmil8xhVpk97nF3GWgxQ
        riotLeagueService.execute("eune");
        RiotLeagueEntry[] leagueEntries = riotLeagueService.getEntriesBySummonerId(riotSummoner.getId());
        return leagueEntries;
    }

    /*@PostMapping
    public ResponseEntity<?> addOrUpdateSummoner(@RequestBody RiotSummoner summoner) {
        summonerService.saveOrUpdateSummoner(summoner);
        return new ResponseEntity("RiotSummoner added succcessfully", HttpStatus.OK);
    }*/
}
