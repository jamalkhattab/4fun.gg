package gg.khatterji.forfun.service.objectmapper;

import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;

public interface SummonerDTOMapper {
    SummonerDTO convertFromRiotSummonerToDTO(RiotSummoner riotSummoner);
    SummonerDTO convertFromSummonerToDTO(Summoner summoner);
}
