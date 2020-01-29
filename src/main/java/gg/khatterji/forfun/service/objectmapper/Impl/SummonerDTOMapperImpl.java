package gg.khatterji.forfun.service.objectmapper.Impl;

import gg.khatterji.forfun.dto.SummonerDTO;
import gg.khatterji.forfun.dto.SummonerDTOBuilder;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.objectmapper.SummonerDTOMapper;
import org.springframework.stereotype.Service;


@Service
public class SummonerDTOMapperImpl implements SummonerDTOMapper {
    @Override
    public SummonerDTO convertFromRiotSummonerToDTO(RiotSummoner riotSummoner) {
        return new SummonerDTOBuilder()
                .setName(riotSummoner.getName())
                .setLevel(riotSummoner.getSummonerLevel())
                .setProfileIconId(riotSummoner.getProfileIconId())
//                .setRegion(region)
//                .setLeagueEntries(leagueEntryDTOS)
                .createSummonerDTO();
    }

    @Override
    public SummonerDTO convertFromSummonerToDTO(Summoner summoner) {
        return new SummonerDTOBuilder()
                .setName(summoner.getName())
                .setLevel(summoner.getSummonerLevel())
                .setProfileIconId(summoner.getProfileIconId())
//                .setRegion(region)
//                .setLeagueEntries(leagueEntryDTOS)
//                .setSecondsLeftForUpdate(secondsLeftForUpdate)
                .createSummonerDTO();
    }
}
