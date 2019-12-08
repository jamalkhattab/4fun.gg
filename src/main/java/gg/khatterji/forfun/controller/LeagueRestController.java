package gg.khatterji.forfun.controller;

import gg.khatterji.forfun.exception.UnauthorizedRiotApiKeyException;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/league")
public class LeagueRestController {
    private final Logger logger = LogManager.getLogger(LeagueRestController.class);
    private final RiotLeagueService riotLeagueService;

    @Autowired
    public LeagueRestController(RiotLeagueService riotLeagueService) {
        this.riotLeagueService = riotLeagueService;
    }

    @GetMapping("/{encryptedSummonerId}")
    @ResponseBody
    public RiotLeagueEntry[] getEntries(@PathVariable String encryptedSummonerId, @RequestHeader String region) {
        try {
            return riotLeagueService.build(region)
                                    .getEntriesBySummonerId(encryptedSummonerId);
        } catch(UnauthorizedRiotApiKeyException e) {
            logger.error(String.format("%s: Status code: %d Status Message: %s", e, e.getErrorStatusCode(), e.getErrorStatusText()));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server is having problems with the API key");
        }
    }
}
