package gg.khatterji.forfun.service.forfun.impl;

import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.repository.SummonerRepository;
import gg.khatterji.forfun.service.forfun.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummonerServiceImpl implements SummonerService {
    private final SummonerRepository summonerRepository;

    @Autowired
    public SummonerServiceImpl(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }
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
