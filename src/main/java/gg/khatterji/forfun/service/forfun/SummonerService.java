package gg.khatterji.forfun.service.forfun;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;

import java.util.List;

public interface SummonerService {
    SummonerDTO saveSummonerAndLeagueEntries(RiotSummoner riotSummoner, List<RiotLeagueEntry> riotLeagueEntries, String region);
    Summoner findByNameAndRegion(String name, String region);
    SummonerDTO updateSummonerAndLeagueEntries(Long id, RiotSummoner riotSummoner, List<RiotLeagueEntry> riotLeagueEntries, String region);
    SummonerDTO convertFromSummonerToDTO(Summoner summoner, String region, List<LeagueEntryDTO> leagueEntryDTOS , long timeLeftForUpdate);
}
