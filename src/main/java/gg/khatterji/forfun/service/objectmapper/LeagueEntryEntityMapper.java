package gg.khatterji.forfun.service.objectmapper;

import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.model.Summoner;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

public interface LeagueEntryEntityMapper {
    public LeagueEntry convertRiotLeagueEntryToLeagueEntry(RiotLeagueEntry riotLeagueEntry, Summoner summoner);
}
