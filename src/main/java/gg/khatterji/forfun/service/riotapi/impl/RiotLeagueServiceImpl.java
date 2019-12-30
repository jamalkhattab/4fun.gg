package gg.khatterji.forfun.service.riotapi.impl;

import gg.khatterji.forfun.constant.RiotEndpoints;
import gg.khatterji.forfun.exception.UnauthorizedRiotApiKeyException;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.utility.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RiotLeagueServiceImpl implements RiotLeagueService {
    private final APIHandler apiHandler;
    private WebClient webClient;

    @Autowired
    public RiotLeagueServiceImpl(APIHandler apiHandler) {
        this.apiHandler = apiHandler;
    }

    @Override
    public RiotLeagueServiceImpl build(String region) {
        apiHandler.generateUrlAndRetrieveAPIKey(region);
        webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", apiHandler.getUrl(), RiotEndpoints.LEAGUE))
                .defaultHeader("X-Riot-Token", apiHandler.getApiKey())
                .build();
        return this;
    }

    @Override
    public List<RiotLeagueEntry> getEntriesBySummonerId(String encryptedSummonerId) {
        try {
            RiotLeagueEntry[] riotLeagueEntries = webClient.get().uri("/by-summoner/{encryptedSummonerId}", encryptedSummonerId)
                    .retrieve().bodyToMono(RiotLeagueEntry[].class).block();
            return riotLeagueEntries == null ? new ArrayList<>() : Arrays.asList(riotLeagueEntries);
        } catch (WebClientResponseException e) {
            throw new UnauthorizedRiotApiKeyException(e.getRawStatusCode(), e.getStatusText());
        }
    }
}
