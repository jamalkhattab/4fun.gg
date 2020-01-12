package gg.khatterji.forfun.service.forfun.impl;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.dto.SummonerDTOBuilder;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.model.SummonerBuilder;
import gg.khatterji.forfun.repository.SummonerRepository;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.forfun.SummonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SummonerServiceImpl implements SummonerService {
    private final SummonerRepository summonerRepository;

    @Autowired
    public SummonerServiceImpl(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    @Override
    public Summoner findByNameAndRegion(String name, String region) {
        return summonerRepository.findByNameAndRegion(name, region);
    }

    @Override
    public Summoner convertAndSaveOrUpdateSummoner(RiotSummoner riotSummoner, String region) {
        Summoner newSummonerData = convertToEntity(riotSummoner, region);
        return summonerRepository.save(newSummonerData);
    }

    @Override
    public Summoner convertAndUpdateSummoner(Summoner existingSummoner, RiotSummoner riotSummoner, String region) {
        Summoner newSummonerData = convertToEntity(riotSummoner, region);
        newSummonerData.setId(existingSummoner.getId());
        return summonerRepository.save(newSummonerData);
    }

    private Summoner convertToEntity(RiotSummoner riotSummoner, String region) {
       return new SummonerBuilder().setEncryptedSummonerId(riotSummoner.getId())
                .setPuuid(riotSummoner.getPuuid())
                .setRegion(region)
                .setSummonerLevel(riotSummoner.getSummonerLevel())
                .setName(riotSummoner.getName())
                .setProfileIconId(riotSummoner.getProfileIconId())
                .setRevisionDate(riotSummoner.getRevisionDate())
                .setAccountId(riotSummoner.getAccountId())
                .setLastUpdatedDate(new Timestamp(System.currentTimeMillis()))
                .createSummoner();
    }

    @Override
    public SummonerDTO convertFromRiotSummonerToDTO(RiotSummoner riotSummoner, String region, List<LeagueEntryDTO> leagueEntryDTOS) {
        return new SummonerDTOBuilder()
                                    .setName(riotSummoner.getName())
                                    .setLevel(riotSummoner.getSummonerLevel())
                                    .setProfileIconId(riotSummoner.getProfileIconId())
                                    .setRegion(region)
                                    .setLeagueEntries(leagueEntryDTOS)
                                    .createSummonerDTO();
    }

    @Override
    public SummonerDTO convertFromSummonerToDTO(Summoner summoner, String region, List<LeagueEntryDTO> leagueEntryDTOS, Long secondsLeftForUpdate) {
        return new SummonerDTOBuilder()
                                    .setName(summoner.getName())
                                    .setLevel(summoner.getSummonerLevel())
                                    .setProfileIconId(summoner.getProfileIconId())
                                    .setRegion(region)
                                    .setLeagueEntries(leagueEntryDTOS)
                                    .setSecondsLeftForUpdate(secondsLeftForUpdate)
                                    .createSummonerDTO();
    }
}
