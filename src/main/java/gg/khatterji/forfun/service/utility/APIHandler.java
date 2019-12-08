package gg.khatterji.forfun.service.utility;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public interface APIHandler {
    public void generateUrlAndRetrieveAPIKey(String region);
    public String getApiKey();
    public String getUrl();

    //TODO: add loggers and handle the exception well
    public default String retrieveAPIKey() {
        try {
            Properties apiProperties = PropertiesLoaderUtils.loadAllProperties("api.properties");
            return apiProperties.getProperty("api.key");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
