package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.exception.UnauthorizedRiotApiKeyException;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    private static final Logger logger = LogManager.getLogger(SummonerRestController.class);
    private final RiotSummonerService riotSummonerService;
    private final RiotLeagueService riotLeagueService;

    @Autowired
    public SummonerRestController(RiotSummonerService riotSummonerService, RiotLeagueService riotLeagueService) {
        this.riotSummonerService = riotSummonerService;
        this.riotLeagueService = riotLeagueService;
    }

    @GetMapping("/{name}/{region}")
    @ResponseBody
    public RiotLeagueEntry[] getSummoner(@PathVariable String name, @PathVariable String region) {
        try {
            logger.info(String.format("Method getSummoner called with the following parameters: %s, %s", name, region));
            riotSummonerService.execute(region);
            RiotSummoner riotSummoner = riotSummonerService.getSummonerByName(name);
            riotLeagueService.execute(region);
            return riotLeagueService.getEntriesBySummonerId(riotSummoner.getId());
        } catch (UnauthorizedRiotApiKeyException e) {
            logger.error(String.format("%s: Status code: %d Status Message: %s", e, e.getErrorStatusCode(), e.getErrorStatusText()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server is having problems with the API key");
        }
    }
    /*@PostMapping
    public ResponseEntity<?> addOrUpdateSummoner(@RequestBody RiotSummoner summoner) {
        summonerService.saveOrUpdateSummoner(summoner);
        return new ResponseEntity("RiotSummoner added succcessfully", HttpStatus.OK);
    }*/
}
