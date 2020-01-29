package gg.khatterji.forfun.service.forfun;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

import java.util.List;

public interface LeagueService {
    void saveLeagueEntries(List<RiotLeagueEntry> riotLeagueEntries, Summoner summoner);
    void updateLeagueEntries(List<RiotLeagueEntry> riotLeagueEntries, Summoner summoner);
    List<LeagueEntryDTO> findLeagueEntriesBySummonerIdAndConvertToDTOs(Long summonerId);
}
