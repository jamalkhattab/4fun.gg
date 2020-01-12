package gg.khatterji.forfun.model;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "summoner")
public class Summoner {
    @Id
    @GeneratedValue
    private Long id;
    private String encryptedSummonerId;
    private String puuid;
    private String region;
    private Long summonerLevel;
    private String name;
    private Long profileIconId;
    private Timestamp revisionDate;
    private String accountId;
    private Timestamp lastUpdatedDate;

    public Summoner() {
        super();
    }

    public Summoner(String encryptedSummonerId, String puuid, String region, Long summonerLevel, String name, Long profileIconId,
                    Timestamp revisionDate, String accountId, Timestamp lastUpdatedDate) {
        this.encryptedSummonerId = encryptedSummonerId;
        this.puuid = puuid;
        this.region = region;
        this.summonerLevel = summonerLevel;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.accountId = accountId;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncryptedSummonerId() {
        return encryptedSummonerId;
    }

    public void setEncryptedSummonerId(String encryptedSummonerId) {
        this.encryptedSummonerId = encryptedSummonerId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }


}
