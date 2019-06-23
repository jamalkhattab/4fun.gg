package com.khatterji.fourfun.controller;

import com.khatterji.fourfun.apiobject.Summoner;
import com.khatterji.fourfun.service.fourfun.SummonerService;
import com.khatterji.fourfun.service.riotapi.RiotSummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    @Autowired
    SummonerService summonerService;

    @Autowired
    RiotSummonerService riotSummonerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
//        List<Summoner> result = summonerService.findAll();
//        return new ResponseEntity(result, HttpStatus.OK);
        riotSummonerService.execute("eune");
        String result = riotSummonerService.getSummonerByName("Jml");
        System.out.println("hiiiiiiiiiiiiii\n" + result);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    /*@PostMapping
    public ResponseEntity<?> addOrUpdateSummoner(@RequestBody Summoner summoner) {
        summonerService.saveOrUpdateSummoner(summoner);
        return new ResponseEntity("Summoner added succcessfully", HttpStatus.OK);
    }*/
}
