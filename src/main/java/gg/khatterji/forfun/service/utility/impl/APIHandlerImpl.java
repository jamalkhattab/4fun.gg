package gg.khatterji.forfun.service.utility.impl;

import gg.khatterji.forfun.constant.RiotRegionalEndpoints;
import gg.khatterji.forfun.service.utility.APIHandler;
import org.springframework.stereotype.Service;


@Service
public class APIHandlerImpl implements APIHandler {
    private String url;
    private String apiKey;

    @Override
    public void generateUrlAndRetrieveAPIKey(String region)
    {
        this.url = prepareUrl(region);
        this.apiKey = retrieveAPIKey();
    }

    /*
        url: https://{RiotRegionalEndpoints}.api.riotgames.com/lol
    */
    private String prepareUrl(String region) {
        String endpoint;
        switch (region) {
            case "euw":
                endpoint = RiotRegionalEndpoints.EUW;
                break;
            case "na":
                endpoint = RiotRegionalEndpoints.NA;
                break;
            case "korea":
                endpoint = RiotRegionalEndpoints.KOREA;
                break;
            default:
                endpoint = RiotRegionalEndpoints.EUNE;
                break;
        }
        return String.format("%s.%s", endpoint, RiotRegionalEndpoints.RIOTAPIHOST);
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}
