package gg.khatterji.forfun.service.objectmapper.Impl;

import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.model.SummonerBuilder;
import gg.khatterji.forfun.riotapiobject.RiotSummoner;
import gg.khatterji.forfun.service.objectmapper.SummonerEntityMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
public class SummonerEntityMapperImpl implements SummonerEntityMapper {

    @Override
    public Summoner convertRiotSummonerToEntity(RiotSummoner riotSummoner) {
        return new SummonerBuilder()
                .setEncryptedSummonerId(riotSummoner.getId())
                .setPuuid(riotSummoner.getPuuid())
                .setSummonerLevel(riotSummoner.getSummonerLevel())
                .setName(riotSummoner.getName())
                .setProfileIconId(riotSummoner.getProfileIconId())
                .setRevisionDate(riotSummoner.getRevisionDate())
                .setAccountId(riotSummoner.getAccountId())
                .setLastUpdatedDate(new Timestamp(System.currentTimeMillis()))
                .createSummoner();
    }
}
