package gg.khatterji.forfun.repository;

import gg.khatterji.forfun.model.LeagueEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueEntryRepository extends JpaRepository<LeagueEntry, Long> {
    List<LeagueEntry> findAllBySummonerId(Long summonerId);
}
