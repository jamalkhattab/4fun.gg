package com.khatterji.fourfun.service.riotapi;

import com.khatterji.fourfun.apiobject.RiotLeagueEntry;

public interface RiotLeagueService {
    public void execute(String region);
    public RiotLeagueEntry[]  getEntriesBySummonerId(String encryptedSummonerId);
}
