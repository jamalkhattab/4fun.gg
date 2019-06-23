package com.khatterji.fourfun.service.riotapi.impl;

import com.khatterji.fourfun.apiobject.Summoner;
import com.khatterji.fourfun.constant.RiotEndpointConstants;
import com.khatterji.fourfun.service.riotapi.RiotSummonerService;
import com.khatterji.fourfun.service.utility.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RiotRiotSummonerServiceImpl implements RiotSummonerService {

    @Autowired
    APIHandler apiHandler;

    private WebClient webClient;
    private String region;

    public void execute(String region) {
        apiHandler.generateUrlAndRetrieveAPIKey(region);
        this.webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", apiHandler.getUrl(), RiotEndpointConstants.SUMMONER))
                .defaultHeader("X-Riot-Token", apiHandler.getApiKey())
                .build();
    }

    @Override
    public String getSummonerByName(String name) {
        Mono<String> response = this.webClient.get().uri("/by-name/{name}", name)
                .retrieve().bodyToMono(String.class);
        return response.block();
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
