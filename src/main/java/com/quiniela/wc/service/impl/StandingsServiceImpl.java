
//Namespace
package com.quiniela.wc.service.impl;

//Imports
import com.quiniela.wc.domain.rest.TeamRecord;
import com.quiniela.wc.repository.StandingsRepository;
import com.quiniela.wc.service.StandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * class that handles team standings operations
 */
@Service
public class StandingsServiceImpl implements StandingsService {

    //Fields
    @Autowired
    private StandingsRepository standingsRepository;

    /**
     * Retrieve default standings
     * @return
     */
    @Override
    public List<TeamRecord> retrieveDefaultStandings() {
        return standingsRepository.generateDefaultStandings();
    }
}