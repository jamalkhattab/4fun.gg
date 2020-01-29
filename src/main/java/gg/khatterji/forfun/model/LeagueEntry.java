package gg.khatterji.forfun.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "leagueEntry")
public class LeagueEntry implements Serializable  {
    @Id
    @GeneratedValue
    private Long id;

    private String queueType;

    private boolean hotStreak;
    private boolean veteran;
    private boolean inactive;
    private boolean freshBlood;
    private Integer wins;
    private Integer losses;
    private Integer leaguePoints;
    private String summonerRank;
    private String tier;
    private String leagueId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "summoner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Summoner summoner;

    public LeagueEntry() {
        super();
    }

    public LeagueEntry(String queueType, boolean hotStreak, boolean veteran, boolean inactive, boolean freshBlood, Integer wins, Integer losses, Integer leaguePoints,
                       String summonerRank, String tier, String leagueId, Summoner summoner) {
        this.queueType = queueType;
        this.hotStreak = hotStreak;
        this.veteran = veteran;
        this.inactive = inactive;
        this.freshBlood = freshBlood;
        this.wins = wins;
        this.losses = losses;
        this.leaguePoints = leaguePoints;
        this.summonerRank = summonerRank;
        this.tier = tier;
        this.leagueId = leagueId;
        this.summoner = summoner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(Integer leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public String getSummonerRank() {
        return summonerRank;
    }

    public void setSummonerRank(String summonerRank) {
        this.summonerRank = summonerRank;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

//    public Summoner getSummoner() {
//        return summoner;
//    }
//
//    public void setSummoner(Summoner summoner) {
//        this.summoner = summoner;
//    }
}
