package gg.khatterji.forfun.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SummonerDTO {
    //private Long id;
    //private String encryptedSummonerId;
    //private String puuid;
    //private String accountId;
    //private Timestamp revisionDate;
    //private Timestamp lastUpdatedDate;
    private String name;
    private String region;
    private Long level;
    private Long profileIconId;
    private List<LeagueEntryDTO> leagueEntries;
    private Long secondsLeftForUpdate;

    public SummonerDTO(String name, String region, Long level, Long profileIconId, List<LeagueEntryDTO> leagueEntries, Long secondsLeftForUpdate) {
        this.name = name;
        this.region = region;
        this.level = level;
        this.profileIconId = profileIconId;
        this.leagueEntries = leagueEntries;
        this.secondsLeftForUpdate = secondsLeftForUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public List<LeagueEntryDTO> getLeagueEntries() {
        return leagueEntries;
    }

    public void setLeagueEntries(List<LeagueEntryDTO> leagueEntries) {
        this.leagueEntries = leagueEntries;
    }

    public Long getSecondsLeftForUpdate() {
        return secondsLeftForUpdate;
    }

    public void setSecondsLeftForUpdate(Long secondsLeftForUpdate) {
        this.secondsLeftForUpdate = secondsLeftForUpdate;
    }
}
