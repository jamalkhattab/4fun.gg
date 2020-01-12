package gg.khatterji.forfun.dto;

import java.util.List;

public class SummonerDTOBuilder {
    private String name;
    private String region;
    private Long level;
    private Long profileIconId;
    private List<LeagueEntryDTO> leagueEntries;
    private Long secondsLeftForUpdate;

    public SummonerDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SummonerDTOBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public SummonerDTOBuilder setLevel(Long level) {
        this.level = level;
        return this;
    }

    public SummonerDTOBuilder setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
        return this;
    }

    public SummonerDTOBuilder setLeagueEntries(List<LeagueEntryDTO> leagueEntries) {
        this.leagueEntries = leagueEntries;
        return this;
    }

    public SummonerDTOBuilder setSecondsLeftForUpdate(Long secondsLeftForUpdate) {
        this.secondsLeftForUpdate = secondsLeftForUpdate;
        return this;
    }

    public SummonerDTO createSummonerDTO() {
        return new SummonerDTO(name, region, level, profileIconId, leagueEntries, secondsLeftForUpdate);
    }
}