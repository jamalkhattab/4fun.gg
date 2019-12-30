package gg.khatterji.forfun.service.utility.impl;

import gg.khatterji.forfun.constant.RiotRegionalEndpoints;
import gg.khatterji.forfun.service.utility.RiotAPIUrlHandler;
import org.springframework.stereotype.Service;


@Service
public class RiotAPIUrlHandlerImpl implements RiotAPIUrlHandler {

    /*
        url: https://{RiotRegionalEndpoints}.api.riotgames.com/lol
    */
    @Override
    public String generateUrl(String region) {
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
}
