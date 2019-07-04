package com.khatterji.fourfun.service.riotapi;

import com.khatterji.fourfun.apiobject.RiotSummoner;

public interface RiotSummonerService {
    public void execute(String region);
    public RiotSummoner getSummonerByName(String name);
}
