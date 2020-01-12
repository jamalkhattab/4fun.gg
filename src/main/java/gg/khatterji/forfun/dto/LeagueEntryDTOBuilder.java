package gg.khatterji.forfun.dto;

public class LeagueEntryDTOBuilder {
    private String queueType;
    private String tier;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int losses;

    public LeagueEntryDTOBuilder setQueueType(String queueType) {
        this.queueType = queueType;
        return this;
    }

    public LeagueEntryDTOBuilder setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public LeagueEntryDTOBuilder setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public LeagueEntryDTOBuilder setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
        return this;
    }

    public LeagueEntryDTOBuilder setWins(int wins) {
        this.wins = wins;
        return this;
    }

    public LeagueEntryDTOBuilder setLosses(int losses) {
        this.losses = losses;
        return this;
    }

    public LeagueEntryDTO createLeagueEntryDTO() {
        return new LeagueEntryDTO(queueType, tier, rank, leaguePoints, wins, losses);
    }
}