package gg.khatterji.forfun.service.riotapi;

import gg.khatterji.forfun.riotapiobject.RiotSummoner;

public interface RiotSummonerService {
    public RiotSummonerService build(String region);
    public RiotSummoner getSummonerByName(String name);
}
