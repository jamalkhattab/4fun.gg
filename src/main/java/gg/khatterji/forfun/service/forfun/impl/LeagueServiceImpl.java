package gg.khatterji.forfun.service.forfun.impl;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.repository.LeagueEntryRepository;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.service.forfun.LeagueService;
import gg.khatterji.forfun.service.objectmapper.LeagueEntryDTOMapper;
import gg.khatterji.forfun.service.objectmapper.LeagueEntryEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LeagueServiceImpl implements LeagueService {
    private final LeagueEntryRepository leagueEntryRepository;
    private final LeagueEntryEntityMapper leagueEntryEntityMapper;
    private final LeagueEntryDTOMapper leagueEntryDTOMapper;

    @Autowired
    public LeagueServiceImpl(LeagueEntryRepository leagueEntryRepository, LeagueEntryEntityMapper leagueEntryEntityMapper, LeagueEntryDTOMapper leagueEntryDTOMapper)
    {
        this.leagueEntryRepository = leagueEntryRepository;
        this.leagueEntryEntityMapper = leagueEntryEntityMapper;
        this.leagueEntryDTOMapper = leagueEntryDTOMapper;
    }

    @Override
    public void saveLeagueEntries(List<RiotLeagueEntry> riotLeagueEntries, Summoner summoner)
    {
        List<LeagueEntry> leagueEntries = convertToLeagueEntryEntity(summoner, riotLeagueEntries);
        leagueEntryRepository.saveAll(leagueEntries);
    }

    private List<LeagueEntry> convertToLeagueEntryEntity(Summoner summoner, List<RiotLeagueEntry> riotLeagueEntries) {
        return riotLeagueEntries.stream()
                .map(riotLeagueEntry -> leagueEntryEntityMapper.convertRiotLeagueEntryToLeagueEntry(riotLeagueEntry, summoner))
                .collect(Collectors.toList());
    }

    @Override
    public void updateLeagueEntries(List<RiotLeagueEntry> riotLeagueEntries, Summoner summoner) {
        riotLeagueEntries.stream().forEach(
                leagueEntry -> leagueEntryRepository.updateLeagueEntrySetValuesForSummonerAndQueueType(
                        leagueEntry.isHotStreak(), leagueEntry.isVeteran(), leagueEntry.isInactive(), leagueEntry.isFreshBlood(), leagueEntry.getWins(),
                        leagueEntry.getLosses(), leagueEntry.getLeaguePoints(), leagueEntry.getRank(), leagueEntry.getTier(), leagueEntry.getLeagueId(),
                        leagueEntry.getQueueType(), summoner));
    }

    @Override
    public List<LeagueEntryDTO> findLeagueEntriesBySummonerIdAndConvertToDTOs(Long summonerId) {
        List<LeagueEntry> leagueEntries = leagueEntryRepository.findAllBySummonerId(summonerId);
        return leagueEntries.stream().map(leagueEntryDTOMapper::convertFromEntityToDTO).collect(Collectors.toList());
    }
}
