package gg.khatterji.forfun.service.riotapi;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

import java.util.List;

public interface RiotLeagueService {
    public RiotLeagueService build(String region);
    public List<RiotLeagueEntry> getEntriesBySummonerId(String encryptedSummonerId);
}
