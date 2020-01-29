package gg.khatterji.forfun.service.objectmapper.Impl;

import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.objectmapper.RiotSummonerMapper;
import org.springframework.stereotype.Service;

@Service
public class RiotSummonerMapperImpl implements RiotSummonerMapper {
    @Override
    public RiotSummoner convertDTOtoRiotSummoner(SummonerDTO summonerDTO) {
        return null;
    }
}
