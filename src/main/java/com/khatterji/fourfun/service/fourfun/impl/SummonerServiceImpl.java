package com.khatterji.fourfun.service.fourfun.impl;

import com.khatterji.fourfun.model.Summoner;
import com.khatterji.fourfun.repository.SummonerRepository;
import com.khatterji.fourfun.service.fourfun.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummonerServiceImpl implements SummonerService {
    @Autowired
    SummonerRepository summonerRepository;

    @Override
    public List<Summoner> findAll() {
        return summonerRepository.findAll();
    }

    @Override
    public Summoner findByName(String name) {
        return summonerRepository.findByName(name);
    }

    @Override
    public void saveOrUpdateSummoner(Summoner summoner) {
        summonerRepository.save(summoner);
    }
}
