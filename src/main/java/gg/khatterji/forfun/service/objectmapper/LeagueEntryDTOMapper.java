package gg.khatterji.forfun.service.objectmapper;

import gg.khatterji.forfun.dto.LeagueEntryDTO;
import gg.khatterji.forfun.model.LeagueEntry;
import gg.khatterji.forfun.riotapiobject.RiotLeagueEntry;

public interface LeagueEntryDTOMapper {
    LeagueEntryDTO convertFromRiotLeagueEntryToDTO(RiotLeagueEntry riotLeagueEntry);
    LeagueEntryDTO convertFromEntityToDTO(LeagueEntry leagueEntry);
}
