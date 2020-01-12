package gg.khatterji.forfun.model;

public class LeagueEntryBuilder {
    private String queueType;
    private boolean hotStreak;
    private boolean veteran;
    private boolean inactive;
    private boolean freshBlood;
    private Integer wins;
    private Integer losses;
    private Integer leaguePoints;
    private String rank;
    private String tier;
    private String leagueId;
    private Summoner summoner;

    public LeagueEntryBuilder setQueueType(String queueType) {
        this.queueType = queueType;
        return this;
    }

    public LeagueEntryBuilder setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
        return this;
    }

    public LeagueEntryBuilder setVeteran(boolean veteran) {
        this.veteran = veteran;
        return this;
    }

    public LeagueEntryBuilder setInactive(boolean inactive) {
        this.inactive = inactive;
        return this;
    }

    public LeagueEntryBuilder setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
        return this;
    }

    public LeagueEntryBuilder setWins(Integer wins) {
        this.wins = wins;
        return this;
    }

    public LeagueEntryBuilder setLosses(Integer losses) {
        this.losses = losses;
        return this;
    }

    public LeagueEntryBuilder setLeaguePoints(Integer leaguePoints) {
        this.leaguePoints = leaguePoints;
        return this;
    }

    public LeagueEntryBuilder setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public LeagueEntryBuilder setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public LeagueEntryBuilder setLeagueId(String leagueId) {
        this.leagueId = leagueId;
        return this;
    }

    public LeagueEntryBuilder setSummoner(Summoner summoner) {
        this.summoner = summoner;
        return this;
    }

    public LeagueEntry createLeagueEntry() {
        return new LeagueEntry(queueType, hotStreak, veteran, inactive, freshBlood, wins, losses, leaguePoints, rank, tier, leagueId, summoner);
    }
}