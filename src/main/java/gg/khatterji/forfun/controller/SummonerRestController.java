package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.exception.UnauthorizedRiotApiKeyException;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.riotapi.RiotService;
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
    private final Logger logger = LogManager.getLogger(SummonerRestController.class);
    private final RiotSummonerService riotSummonerService;
    private final RiotLeagueService riotLeagueService;

    @Autowired
    public SummonerRestController(RiotSummonerService riotSummonerService, RiotLeagueService riotLeagueService) {
        this.riotSummonerService = riotSummonerService;
        this.riotLeagueService = riotLeagueService;
    }

    @GetMapping("/{name}")
    @ResponseBody
    public RiotLeagueEntry[] getSummoner(@PathVariable String name, @RequestHeader String region) {
        try {
            RiotSummoner riotSummoner = riotSummonerService.build(region)
                                                           .getSummonerByName(name);
            return riotLeagueService.build(region)
                                    .getEntriesBySummonerId(riotSummoner.getId());
        } catch (UnauthorizedRiotApiKeyException e) {
            logger.error(String.format("%s: Status code: %d Status Message: %s", e, e.getErrorStatusCode(), e.getErrorStatusText()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server is having problems with the API key");
        }
    }
}
