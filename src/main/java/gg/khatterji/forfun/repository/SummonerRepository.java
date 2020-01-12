package gg.khatterji.forfun.repository;

import gg.khatterji.forfun.model.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, Long> {
    Summoner findByNameAndRegion(String name, String regoin);
}
