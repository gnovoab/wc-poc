
//Namespace
package com.quiniela.wc.repository;

import com.quiniela.wc.domain.rest.TeamRecord;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * Unit test class
 */
@ActiveProfiles("unitTest")
@SpringBootTest
public class StandingsRepositoryTest {

    //Fields
    @Autowired
    private transient StandingsRepository standingsRepository;

    @Test
    public void generateDefaultStandingsTest() {
        List<TeamRecord> standings = standingsRepository.generateDefaultStandings();

        //Validate
        Assert.assertNotNull(standings);
        Assert.assertTrue(standings.size() > 0);
    }
}
