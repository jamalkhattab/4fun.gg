package com.khatterji.fourfun.service.fourfun;

import com.khatterji.fourfun.model.Summoner;

import java.util.List;

public interface SummonerService {
    List<Summoner> findAll();
    void saveOrUpdateSummoner(Summoner summoner);
}