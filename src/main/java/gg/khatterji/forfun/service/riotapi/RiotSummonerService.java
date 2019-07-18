package gg.khatterji.forfun.service.riotapi;

import gg.khatterji.forfun.riotapiobject.RiotSummoner;

public interface RiotSummonerService {
    public void execute(String region);
    public RiotSummoner getSummonerByName(String name);
}
