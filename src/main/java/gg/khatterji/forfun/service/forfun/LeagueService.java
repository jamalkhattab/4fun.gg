package gg.khatterji.forfun.service.forfun;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

import java.util.List;

public interface LeagueService {
    LeagueEntryDTO  convertToDTO(RiotLeagueEntry riotLeagueEntry);
    LeagueEntryDTO convertToDTO(LeagueEntry leagueEntry);
    void convertAndSaveOrUpdateLeagueEntries(Summoner summoner, List<RiotLeagueEntry> riotLeagueEntries);
    List<LeagueEntry> findLeagueEntriesBySummonerId(Long summonerId);
}
