package gg.khatterji.forfun.service.objectmapper.Impl;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.LeagueEntryDTOBuilder;
import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.objectmapper.LeagueEntryDTOMapper;
import org.springframework.stereotype.Service;

@Service
public class LeagueEntryDTOMapperImpl implements LeagueEntryDTOMapper {

    @Override
    public LeagueEntryDTO convertFromRiotLeagueEntryToDTO(RiotLeagueEntry riotLeagueEntry) {
        return new LeagueEntryDTOBuilder()
                .setLeaguePoints(riotLeagueEntry.getLeaguePoints())
                .setLosses(riotLeagueEntry.getLosses())
                .setQueueType(riotLeagueEntry.getQueueType())
                .setRank(riotLeagueEntry.getRank())
                .setTier(riotLeagueEntry.getTier())
                .setWins(riotLeagueEntry.getWins())
                .createLeagueEntryDTO();
    }

    @Override
    public LeagueEntryDTO convertFromEntityToDTO(LeagueEntry leagueEntry) {
        return new LeagueEntryDTOBuilder()
                .setLeaguePoints(leagueEntry.getLeaguePoints())
                .setLosses(leagueEntry.getLosses())
                .setQueueType(leagueEntry.getQueueType())
                .setRank(leagueEntry.getSummonerRank())
                .setTier(leagueEntry.getTier())
                .setWins(leagueEntry.getWins())
                .createLeagueEntryDTO();
    }
}
