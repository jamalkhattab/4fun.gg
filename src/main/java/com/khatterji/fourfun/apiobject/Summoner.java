package com.khatterji.fourfun.apiobject;

import java.sql.Timestamp;

public class Summoner {
    private String id;
    private String puuid;
    private String name;
    private Long summonerLevel;
    private String accountId;
    private Long profileIconId;
    private Timestamp revisionDate;

    public Summoner(){}

    public Summoner(String id, String puuid, String name, Long summonerLevel, String accountId, Long profileIconId, Timestamp revisionDate) {
        this.id = id;
        this.puuid = puuid;
        this.name = name;
        this.summonerLevel = summonerLevel;
        this.accountId = accountId;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public Timestamp getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Timestamp revisionDate) {
        this.revisionDate = revisionDate;
    }
}
