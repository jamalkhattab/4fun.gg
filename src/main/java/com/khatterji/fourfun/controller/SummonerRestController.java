package com.khatterji.fourfun.controller;

import com.khatterji.fourfun.model.Summoner;
import com.khatterji.fourfun.service.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/summoner")
public class SummonerRestController {
    @Autowired
    SummonerService summonerService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Summoner> result = summonerService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrUpdateSummoner(@RequestBody Summoner summoner) {
        summonerService.saveOrUpdateSummoner(summoner);
        return new ResponseEntity("Summoner added succcessfully", HttpStatus.OK);
    }
}
