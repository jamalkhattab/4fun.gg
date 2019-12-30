package gg.khatterji.forfun.service.riotapi.impl;

import gg.khatterji.forfun.configuration.RiotAPIKeyConfiguration;
import gg.khatterji.forfun.constant.RiotEndpoints;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.utility.RiotAPIUrlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RiotLeagueServiceImpl implements RiotLeagueService {
    private final RiotAPIUrlHandler riotApiUrlHandler;
    private final RiotAPIKeyConfiguration riotAPIKeyConfiguration;
    private WebClient webClient;

    @Autowired
    public RiotLeagueServiceImpl(RiotAPIUrlHandler riotApiUrlHandler, RiotAPIKeyConfiguration riotAPIKeyConfiguration) {
        this.riotApiUrlHandler = riotApiUrlHandler;
        this.riotAPIKeyConfiguration = riotAPIKeyConfiguration;
    }

    @Override
    public RiotLeagueServiceImpl build(String region) {
        webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", riotApiUrlHandler.generateUrl(region), RiotEndpoints.LEAGUE))
                .defaultHeader("X-Riot-Token", riotAPIKeyConfiguration.retrieveApiKey().getApiKey())
                .build();
        return this;
    }

    @Override
    public List<RiotLeagueEntry> getEntriesBySummonerId(String encryptedSummonerId) {
        RiotLeagueEntry[] riotLeagueEntries = webClient.get().uri("/by-summoner/{encryptedSummonerId}", encryptedSummonerId)
                .retrieve().bodyToMono(RiotLeagueEntry[].class).block();
        return riotLeagueEntries == null ? new ArrayList<>() : Arrays.asList(riotLeagueEntries);
    }
}
