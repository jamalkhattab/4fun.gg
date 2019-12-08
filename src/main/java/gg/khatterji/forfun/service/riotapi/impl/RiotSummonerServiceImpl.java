package gg.khatterji.forfun.service.riotapi.impl;

import gg.khatterji.forfun.exception.UnauthorizedRiotApiKeyException;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.constant.RiotEndpoints;
import gg.khatterji.forfun.service.riotapi.RiotService;
import gg.khatterji.forfun.service.riotapi.RiotSummonerService;
import gg.khatterji.forfun.service.utility.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class RiotSummonerServiceImpl implements RiotSummonerService {
    private final APIHandler apiHandler;
    private WebClient webClient;

    @Autowired
    public RiotSummonerServiceImpl(APIHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    @Override
    public RiotSummonerService build(String region) {
        apiHandler.generateUrlAndRetrieveAPIKey(region);
        webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", apiHandler.getUrl(), RiotEndpoints.SUMMONER))
                .defaultHeader("X-Riot-Token", apiHandler.getApiKey())
                .build();
        return this;
    }

    @Override
    public RiotSummoner getSummonerByName(String name) {
        try {
            return webClient.get().uri("/by-name/{name}", name)
                    .retrieve().bodyToMono(RiotSummoner.class).block();
        } catch (WebClientResponseException e) {
            throw new UnauthorizedRiotApiKeyException(e.getRawStatusCode(), e.getStatusText());
        }
    }
}
