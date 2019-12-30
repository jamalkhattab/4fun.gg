package gg.khatterji.forfun.service.riotapi.impl;

import gg.khatterji.forfun.configuration.RiotAPIKeyConfiguration;
import gg.khatterji.forfun.constant.RiotEndpoints;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import gg.khatterji.forfun.service.utility.RiotAPIUrlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RiotSummonerServiceImpl implements RiotSummonerService {
    private final RiotAPIUrlHandler riotApiUrlHandler;
    private final RiotAPIKeyConfiguration riotAPIKeyConfiguration;
    private WebClient webClient;

    @Autowired
    public RiotSummonerServiceImpl(RiotAPIUrlHandler riotApiUrlHandler, RiotAPIKeyConfiguration riotAPIKeyConfiguration) {
        this.riotApiUrlHandler = riotApiUrlHandler;
        this.riotAPIKeyConfiguration = riotAPIKeyConfiguration;
    }

    @Override
    public RiotSummonerService build(String region) {
        webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", riotApiUrlHandler.generateUrl(region), RiotEndpoints.SUMMONER))
                .defaultHeader("X-Riot-Token", riotAPIKeyConfiguration.retrieveApiKey().getApiKey())
                .build();
        return this;
    }

    @Override
    public RiotSummoner getSummonerByName(String name) {
        return webClient.get().uri("/by-name/{name}", name)
                .retrieve().bodyToMono(RiotSummoner.class).block();
    }
}
