package gg.khatterji.forfun.service.riotapi;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

public interface RiotLeagueService {
    public RiotLeagueService build(String region);
    public RiotLeagueEntry[] getEntriesBySummonerId(String encryptedSummonerId);
}
