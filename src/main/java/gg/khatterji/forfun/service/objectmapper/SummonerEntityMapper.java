package gg.khatterji.forfun.service.objectmapper;

import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;

public interface SummonerEntityMapper {
    Summoner convertRiotSummonerToEntity(RiotSummoner riotSummoner);
}
