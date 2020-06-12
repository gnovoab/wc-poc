
//Namespace
package com.quiniela.wc.service;

//Imports
import com.quiniela.wc.domain.rest.TeamRecord;
import java.util.List;

public interface StandingsService {
    List<TeamRecord> retrieveDefaultStandings();
}
