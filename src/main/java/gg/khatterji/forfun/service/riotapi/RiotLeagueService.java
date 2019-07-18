package gg.khatterji.forfun.service.riotapi;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

public interface RiotLeagueService {
    public void execute(String region);
    public RiotLeagueEntry[]  getEntriesBySummonerId(String encryptedSummonerId);
}
