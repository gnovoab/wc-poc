
//Namespace
package com.quiniela.wc.repository.impl;

//Imports

import com.quiniela.wc.domain.Match;
import com.quiniela.wc.domain.Team;
import com.quiniela.wc.exception.DatabaseException;
import com.quiniela.wc.repository.QuinielaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles quiniela database operations
 */
@Repository
public class QuinielaRepositoryImpl extends BaseRepository implements QuinielaRepository {

    //The LOG
    private static final Logger LOGGER = LoggerFactory.getLogger(QuinielaRepositoryImpl.class);


    /**
     * Retrieves user's quiniela
     * @param username
     * @return
     */
    @Override
    public List<Match> findByUser(String username) {
        try {

            LOGGER.info("Fetching quiniela for user [{}]...", username);

            //Create the sql


            String sql =
                    "SELECT " +
                    "   f.id, f.stage, " +
                    "   l.code as local_team_code, l.name as local_team_name, l.code_alt as local_team_abbreviation," +
                    "   v.code as visitor_team_code, v.name as visitor_team_name, v.code_alt as visitor_team_abbreviation," +
                    "   coalesce(q.goals_local, -1) AS goals_local, coalesce(q.goals_visitor, -1) AS goals_visitor " +
                    "FROM " +
                    "   wc_fixture f " +
                    "   LEFT JOIN wc_team l on" +
                    "       f.local = l.code " +
                    "   LEFT JOIN wc_team v on " +
                    "       f.visitor = v.code" +
                    "   LEFT JOIN wc_quiniela q on" +
                    "       f.id=q.match and " +
                    "       q.username = ? ";


            //Create list
            List<Match> fixtures = jdbcTemplate.query(sql, (result, rowNum) -> {

                Match match = new Match();
                Team local = new Team();
                Team visitor = new Team();

                //Read the data
                match.setId(result.getLong("id"));
                match.setStage(result.getString("stage"));

                local.setCode(result.getString("local_team_code"));
                local.setName(result.getString("local_team_name"));
                local.setAbbreviation(result.getString("local_team_abbreviation"));
                match.setLocal(local);

                visitor.setCode(result.getString("visitor_team_code"));
                visitor.setName(result.getString("visitor_team_name"));
                visitor.setAbbreviation(result.getString("visitor_team_abbreviation"));
                match.setVisitor(visitor);

                match.setGoalsVisitor(result.getInt("goals_visitor"));
                match.setGoalsLocal(result.getInt("goals_local"));

                return match;
            }, username);

            LOGGER.info("Retrieving quiniela for user [{}]", username);
            return fixtures;

        } catch (Exception e) {
            LOGGER.error("Unknown exception while fetching quiniela for user [{}]", username, e);
            throw new DatabaseException("Exception while fetching quiniela", e);
        }
    }

    @Override
    public void delete(String username) {
        try {
            LOGGER.info("Deleting previous quiniela for user [{}]...", username);

            String sql = "Delete from wc_quiniela where username = ?";

            this.jdbcTemplate.update(sql, username);

            LOGGER.info("Previous quiniela for user [{}] successfully deleted", username);

        } catch (Exception e) {
            LOGGER.error("Unknown exception while deleting previous quiniela for user [{}]", username, e);
            throw new DatabaseException("Exception while deleting previous quiniela", e);
        }
    }

    @Override
    public void save(List<Match> quiniela, String username) {
        try {
            LOGGER.info("Saving quiniela for user [{}]...", username);

            //Create the Query
            String sql = "INSERT into wc_quiniela (username, match, goals_local, goals_visitor) values (?, ?, ?, ?) ";

            //Create the batch
            List<Object[]> batch = new ArrayList<Object[]>();
            for (Match match : quiniela) {
                Object[] values = new Object[] {
                        username,
                        match.getId(),
                        match.getGoalsLocal(),
                        match.getGoalsVisitor()};
                batch.add(values);
            }

            //Execute the query
            jdbcTemplate.batchUpdate(sql, batch);


            LOGGER.info("Quiniela for user [{}] saved successfully", username);

        } catch (Exception e) {
            LOGGER.error("Unknown exception while saving quiniela for user [{}]", username, e);
            throw new DatabaseException("Exception while saving quiniela", e);
        }
    }
}
