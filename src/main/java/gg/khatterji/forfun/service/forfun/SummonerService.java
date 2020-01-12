package gg.khatterji.forfun.service.forfun;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;

import java.util.List;

public interface SummonerService {
    Summoner findByNameAndRegion(String name, String region);
    Summoner convertAndSaveOrUpdateSummoner(RiotSummoner summoner, String region);
    Summoner convertAndUpdateSummoner(Summoner existingSummoner, RiotSummoner riotSummoner, String region);
    SummonerDTO convertFromRiotSummonerToDTO(RiotSummoner riotSummoner, String region, List<LeagueEntryDTO> leagueEntryDTOS);
    SummonerDTO convertFromSummonerToDTO(Summoner summoner, String region, List<LeagueEntryDTO> leagueEntryDTOS, Long secondsLeftForUpdate);
}
