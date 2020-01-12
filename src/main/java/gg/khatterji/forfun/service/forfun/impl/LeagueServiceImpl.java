package gg.khatterji.forfun.service.forfun.impl;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.LeagueEntryDTOBuilder;
import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.LeagueEntryBuilder;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.repository.LeagueEntryRepository;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.forfun.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LeagueServiceImpl implements LeagueService {
    private final LeagueEntryRepository leagueEntryRepository;

    @Autowired
    public LeagueServiceImpl(LeagueEntryRepository leagueEntryRepository)
    {
        this.leagueEntryRepository = leagueEntryRepository;
    }

    @Override
    public LeagueEntryDTO convertToDTO(LeagueEntry leagueEntry) {
        return new LeagueEntryDTOBuilder()
                                        .setLeaguePoints(leagueEntry.getLeaguePoints())
                                        .setLosses(leagueEntry.getLosses())
                                        .setQueueType(leagueEntry.getQueueType())
                                        .setRank(leagueEntry.getSummonerRank())
                                        .setTier(leagueEntry.getTier())
                                        .setWins(leagueEntry.getWins())
                                        .createLeagueEntryDTO();
    }

    @Override
    public LeagueEntryDTO convertToDTO(RiotLeagueEntry riotLeagueEntry) {
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
    public void convertAndSaveOrUpdateLeagueEntries(Summoner summoner, List<RiotLeagueEntry> riotLeagueEntries) {
        List<LeagueEntry> leagueEntries = riotLeagueEntries.stream()
                                                            .map(leagueEntry -> convertToEntity(summoner, leagueEntry))
                                                            .collect(Collectors.toList());
        leagueEntryRepository.saveAll(leagueEntries);
    }

    private static LeagueEntry convertToEntity(Summoner summoner, RiotLeagueEntry riotLeagueEntry) {
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

    @Override
    public List<LeagueEntry> findLeagueEntriesBySummonerId(Long summonerId) {
        return leagueEntryRepository.findAllBySummonerId(summonerId);
    }
}
