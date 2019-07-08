package com.khatterji.fourfun.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "summoner")
public class Summoner {
    @Id
    @GeneratedValue
    private Long id;
    private String encryptedSummonerId;
    private String puuid;
    private String region;
    private Long level;
    private String name;
    private Long profileIconId;
    private Long revisionDate;

    public Summoner(){
        super();
    }

    public Summoner(Long id, String encryptedSummonerId, String puuid, String region, Long level, String name, Long profileIconId, Long revisionDate) {
        super();
        this.id = id;
        this.encryptedSummonerId = encryptedSummonerId;
        this.puuid = puuid;
        this.region = region;
        this.level = level;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
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

    public Long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }
}
