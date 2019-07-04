package com.khatterji.fourfun.service.riotapi.impl;

import com.khatterji.fourfun.apiobject.RiotSummoner;
import com.khatterji.fourfun.constant.RiotEndpointConstants;
import com.khatterji.fourfun.service.riotapi.RiotSummonerService;
import com.khatterji.fourfun.service.utility.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RiotSummonerServiceImpl implements RiotSummonerService {

    @Autowired
    private APIHandler apiHandler;
    private WebClient webClient;

    public void execute(String region) {
        apiHandler.generateUrlAndRetrieveAPIKey(region);
        this.webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", apiHandler.getUrl(), RiotEndpointConstants.SUMMONER))
                .defaultHeader("X-Riot-Token", apiHandler.getApiKey())
                .build();
    }

    @Override
    public RiotSummoner getSummonerByName(String name) {
        RiotSummoner riotSummoner = this.webClient.get().uri("/by-name/{name}", name)
                .retrieve().bodyToMono(RiotSummoner.class).block();
        return riotSummoner;
    }
}
