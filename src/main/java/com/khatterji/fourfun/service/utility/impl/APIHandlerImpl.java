package com.khatterji.fourfun.service.utility.impl;

import com.khatterji.fourfun.constant.RiotRegionalEndpoints;
import com.khatterji.fourfun.service.utility.APIHandler;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class APIHandlerImpl implements APIHandler {
    private String url;
    private String apiKey;

    @Override
    public void generateUrlAndRetrieveAPIKey(String region)
    {
        prepareUrl(region);
        retrieveAPIKey();
    }

    //TODO: fix default
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

    //TODO: add loggers and handle the exception well
    private void retrieveAPIKey() {
        try {
            Properties apiProperties = PropertiesLoaderUtils.loadAllProperties("api.properties");
            apiKey = apiProperties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getApiKey() {
        return apiKey;
    }
}
