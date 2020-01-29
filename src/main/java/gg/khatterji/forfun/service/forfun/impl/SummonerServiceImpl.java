package gg.khatterji.forfun.service.forfun.impl;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.repository.SummonerRepository;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.forfun.LeagueService;
import gg.khatterji.forfun.service.forfun.SummonerService;
import gg.khatterji.forfun.service.objectmapper.LeagueEntryDTOMapper;
import gg.khatterji.forfun.service.objectmapper.SummonerDTOMapper;
import gg.khatterji.forfun.service.objectmapper.SummonerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummonerServiceImpl implements SummonerService {
    private final SummonerRepository summonerRepository;
    private final SummonerEntityMapper summonerEntityMapper;
    private final LeagueService leagueService;
    private final SummonerDTOMapper summonerDTOMapper;
    private final LeagueEntryDTOMapper leagueEntryDTOMapper;

    @Autowired
    public SummonerServiceImpl(SummonerRepository summonerRepository, LeagueService leagueService, SummonerEntityMapper summonerEntityMapper,
                               SummonerDTOMapper summonerDTOMapper, LeagueEntryDTOMapper leagueEntryDTOMapper) {
        this.summonerRepository = summonerRepository;
        this.leagueService = leagueService;
        this.summonerEntityMapper = summonerEntityMapper;
        this.summonerDTOMapper = summonerDTOMapper;
        this.leagueEntryDTOMapper = leagueEntryDTOMapper;
    }

    @Override
    public Summoner findByNameAndRegion(String name, String region) {
        return summonerRepository.findByNameAndRegion(name, region);
    }

    @Override
    public SummonerDTO saveSummonerAndLeagueEntries(RiotSummoner riotSummoner, List<RiotLeagueEntry> riotLeagueEntries, String region) {
        Summoner summoner = summonerEntityMapper.convertRiotSummonerToEntity(riotSummoner);
        summoner.setRegion(region);
        summonerRepository.save(summoner);
        leagueService.saveLeagueEntries(riotLeagueEntries, summoner);
        return convertToDTO(riotSummoner, riotLeagueEntries);
    }

    private SummonerDTO convertToDTO(RiotSummoner riotSummoner, List<RiotLeagueEntry> riotLeagueEntries)
    {
        SummonerDTO summonerDTO = summonerDTOMapper.convertFromRiotSummonerToDTO(riotSummoner);
        List<LeagueEntryDTO> leagueEntryDTOs = riotLeagueEntries.stream()
                                                                .map(leagueEntryDTOMapper::convertFromRiotLeagueEntryToDTO)
                                                                .collect(Collectors.toList());
        summonerDTO.setLeagueEntries(leagueEntryDTOs);
        return summonerDTO;
    }

    @Override
    public SummonerDTO updateSummonerAndLeagueEntries(Long existingSummonerId, RiotSummoner riotSummoner, List<RiotLeagueEntry> riotLeagueEntries, String region) {
        Summoner newSummonerData = summonerEntityMapper.convertRiotSummonerToEntity(riotSummoner);
        newSummonerData.setId(existingSummonerId);
        newSummonerData.setRegion(region);
        newSummonerData = summonerRepository.save(newSummonerData);
        leagueService.updateLeagueEntries(riotLeagueEntries, newSummonerData);
        return convertToDTO(riotSummoner, riotLeagueEntries);
    }

    @Override
    public SummonerDTO convertFromSummonerToDTO(Summoner summoner, String region, List<LeagueEntryDTO> leagueEntryDTOS, long timeLeftForUpdate) {
        SummonerDTO summonerDTO = summonerDTOMapper.convertFromSummonerToDTO(summoner);
        summonerDTO.setRegion(region);
        summonerDTO.setLeagueEntries(leagueEntryDTOS);
        summonerDTO.setSecondsLeftForUpdate(timeLeftForUpdate);
        return summonerDTO;
    }

}
