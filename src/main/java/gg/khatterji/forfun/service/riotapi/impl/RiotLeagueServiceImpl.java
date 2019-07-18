package gg.khatterji.forfun.service.riotapi.impl;

import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.constant.RiotEndpointConstants;
import gg.khatterji.forfun.service.riotapi.RiotLeagueService;
import gg.khatterji.forfun.service.utility.APIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RiotLeagueServiceImpl implements RiotLeagueService {
    @Autowired
    private APIHandler apiHandler;
    private WebClient webClient;

    @Override
    public void execute(String region) {
        apiHandler.generateUrlAndRetrieveAPIKey(region);
        this.webClient = WebClient
                .builder()
                .baseUrl(String.format("%s%s", apiHandler.getUrl(), RiotEndpointConstants.LEAGUE))
                .defaultHeader("X-Riot-Token", apiHandler.getApiKey())
                .build();
    }

    @Override
    public RiotLeagueEntry[] getEntriesBySummonerId(String encryptedSummonerId) {
        RiotLeagueEntry[] riotSummoner = this.webClient.get().uri("/by-summoner/{encryptedSummonerId}", encryptedSummonerId)
                .retrieve().bodyToMono(RiotLeagueEntry[].class).block();
        return riotSummoner;
    }
}
