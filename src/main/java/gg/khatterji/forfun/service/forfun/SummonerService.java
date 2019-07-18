package gg.khatterji.forfun.service.forfun;

import gg.khatterji.forfun.model.Summoner;

import java.util.List;

public interface SummonerService {
    List<Summoner> findAll();
    Summoner findByName(String name);
    void saveOrUpdateSummoner(Summoner summoner);
}
