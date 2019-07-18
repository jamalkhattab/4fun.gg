package gg.khatterji.forfun.service.utility;

public interface APIHandler {
    public void generateUrlAndRetrieveAPIKey(String region);
    public String getApiKey();
    public String getUrl();
}
