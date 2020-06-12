
//Namespace
package com.quiniela.wc.repository;

//Imports
import com.quiniela.wc.domain.rest.TeamRecord;
import java.util.List;

public interface StandingsRepository {
    List<TeamRecord> generateDefaultStandings();
}
