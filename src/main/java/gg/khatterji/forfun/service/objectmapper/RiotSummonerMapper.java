package gg.khatterji.forfun.service.objectmapper;

import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;

public interface RiotSummonerMapper {
    RiotSummoner convertDTOtoRiotSummoner(SummonerDTO summonerDTO);
}
