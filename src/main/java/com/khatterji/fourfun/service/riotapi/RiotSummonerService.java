package com.khatterji.fourfun.service.riotapi;

import com.khatterji.fourfun.apiobject.Summoner;
import reactor.core.publisher.Mono;

public interface RiotSummonerService {
    public void execute(String region);
    public String getSummonerByName(String name);
}
