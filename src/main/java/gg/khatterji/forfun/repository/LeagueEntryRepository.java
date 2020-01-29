package gg.khatterji.forfun.repository;

import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntry, Long> {
    List<LeagueEntry> findAllBySummonerId(Long summonerId);

    @Transactional
    @Modifying
    @Query("update LeagueEntry entry set entry.hotStreak = :hotStreak, entry.veteran = :veteran, entry.inactive = :inactive, " +
            "entry.freshBlood = :freshBlood, entry.wins = :wins, entry.losses = :losses, entry.leaguePoints = :leaguePoints, entry.summonerRank = :summonerRank, " +
            "entry.tier = :tier, entry.leagueId = :leagueId where entry.queueType = :queueType and entry.summoner = :summoner ")
    int updateLeagueEntrySetValuesForSummonerAndQueueType(@Param("hotStreak") boolean hotStreak, @Param("veteran") boolean veteran,
                                   @Param("inactive") boolean inactive, @Param("freshBlood") boolean freshBlood, @Param("wins") Integer wins,
                                   @Param("losses") Integer losses, @Param("leaguePoints") Integer leaguePoints, @Param("summonerRank") String summonerRank,
                                   @Param("tier") String tier, @Param("leagueId") String leagueId, @Param("queueType") String queueType, @Param("summoner") Summoner summoner);
}
