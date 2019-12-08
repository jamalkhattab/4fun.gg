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
        prepareUrl(region);
        apiKey = retrieveAPIKey();
    }

    /*
        url: https://{RiotRegionalEndpoints}.api.riotgames.com/lol
    */
    private void prepareUrl(String region) {
        switch (region) {
            case "euw":
                url = String.format("%s.", RiotRegionalEndpoints.EUW);
                break;
            case "na":
                url = String.format("%s.", RiotRegionalEndpoints.NA);
                break;
            case "korea":
                url = String.format("%s.", RiotRegionalEndpoints.KOREA);
                break;
            default:
                url = String.format("%s.", RiotRegionalEndpoints.EUNE);
                break;
        }
        url += RiotRegionalEndpoints.RIOTAPIHOST;
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}
