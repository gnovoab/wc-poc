
//Namespace
package com.quiniela.wc.repository.impl;

import com.quiniela.wc.domain.model.Team;
import com.quiniela.wc.domain.rest.TeamRecord;
import com.quiniela.wc.exception.DatabaseException;
import com.quiniela.wc.repository.StandingsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class that handles teams standings operations
 */
@Repository
public class StandingsRepositoryImpl extends BaseRepository implements StandingsRepository {

    //The LOG
    private static final Logger LOGGER = LoggerFactory.getLogger(StandingsRepositoryImpl.class);

    /**
     * Generate default standings
     * @return
     */

    @Override
    @Cacheable("defaultStandings")
    public List<TeamRecord> generateDefaultStandings() {
        try {

            LOGGER.info("Retrieving default standings");

            //Create the sql
            String sql =
                    "SELECT " +
                    "   distinct t.code, t.name, t.code_alt as abbreviation, f.stage " +
                    "FROM " +
                    "   wc_fixture f " +
                    "LEFT JOIN wc_team t ON " +
                    "  f.local = t.code " +
                    "ORDER BY " +
                    "   f.stage";


            //Create list
            List<TeamRecord> standings = jdbcTemplate.query(sql, (result, rowNum) -> {

                TeamRecord record = new TeamRecord();

                //Read the data
                Team team = new Team();
                team.setCode(result.getString("code"));
                team.setName(result.getString("name"));
                team.setAbbreviation(result.getString("abbreviation"));

                record.setTeam(team);
                record.setGroup(result.getString("stage"));

                return record;
            });

            LOGGER.info("Returning default standings successfully");
            return standings;

        } catch (Exception e) {
            LOGGER.error("Unknown exception while generating default standings", e);
            throw new DatabaseException("Unknown exception while generating default standings", e);
        }
    }
}
