package gg.khatterji.forfun.service.objectmapper.Impl;

import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.LeagueEntryBuilder;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.objectmapper.LeagueEntryEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class LeagueEntryEntityMapperImpl implements LeagueEntryEntityMapper {
    @Override
    public LeagueEntry convertRiotLeagueEntryToLeagueEntry(RiotLeagueEntry riotLeagueEntry, Summoner summoner){
        return new LeagueEntryBuilder()
                .setFreshBlood(riotLeagueEntry.isFreshBlood())
                .setQueueType(riotLeagueEntry.getQueueType())
                .setHotStreak(riotLeagueEntry.isHotStreak())
                .setVeteran(riotLeagueEntry.isVeteran())
                .setInactive(riotLeagueEntry.isInactive())
                .setFreshBlood(riotLeagueEntry.isFreshBlood())
                .setWins(riotLeagueEntry.getWins())
                .setLosses(riotLeagueEntry.getLosses())
                .setLeaguePoints(riotLeagueEntry.getLeaguePoints())
                .setRank(riotLeagueEntry.getRank())
                .setTier(riotLeagueEntry.getTier())
                .setLeagueId(riotLeagueEntry.getLeagueId())
                .setSummoner(summoner)
                .createLeagueEntry();
    }
}
