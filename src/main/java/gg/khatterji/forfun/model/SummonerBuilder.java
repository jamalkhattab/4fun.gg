package gg.khatterji.forfun.model;

import java.sql.Timestamp;

public class SummonerBuilder {
    private String encryptedSummonerId;
    private String puuid;
    private String region;
    private Long summonerLevel;
    private String name;
    private Long profileIconId;
    private Timestamp revisionDate;
    private String accountId;
    private Timestamp lastUpdatedDate;

    public SummonerBuilder setEncryptedSummonerId(String encryptedSummonerId) {
        this.encryptedSummonerId = encryptedSummonerId;
        return this;
    }

    public SummonerBuilder setPuuid(String puuid) {
        this.puuid = puuid;
        return this;
    }

    public SummonerBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public SummonerBuilder setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
        return this;
    }

    public SummonerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SummonerBuilder setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
        return this;
    }

    public SummonerBuilder setRevisionDate(Timestamp revisionDate) {
        this.revisionDate = revisionDate;
        return this;
    }

    public SummonerBuilder setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public SummonerBuilder setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }

    public Summoner createSummoner() {
        return new Summoner(encryptedSummonerId, puuid, region, summonerLevel, name, profileIconId, revisionDate, accountId, lastUpdatedDate);
    }
}