package com.khatterji.fourfun.controller;

import com.khatterji.fourfun.apiobject.RiotSummoner;
import com.khatterji.fourfun.model.Summoner;
import com.khatterji.fourfun.service.fourfun.SummonerService;
import com.khatterji.fourfun.service.riotapi.RiotSummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    @Autowired
    SummonerService summonerService;
    @Autowired
    RiotSummonerService riotSummonerService;

    @GetMapping("/{name}")
    @ResponseBody
        public RiotSummoner getSummoner(@PathVariable String name) {
        Timestamp current =  new Timestamp(System.currentTimeMillis());
        Summoner summoner = summonerService.findByName(name);

        riotSummonerService.execute("eune");
        RiotSummoner riotSummoner = riotSummonerService.getSummonerByName(name);
        return riotSummoner;
    }

    /*@PostMapping
    public ResponseEntity<?> addOrUpdateSummoner(@RequestBody RiotSummoner summoner) {
        summonerService.saveOrUpdateSummoner(summoner);
        return new ResponseEntity("RiotSummoner added succcessfully", HttpStatus.OK);
    }*/
}
