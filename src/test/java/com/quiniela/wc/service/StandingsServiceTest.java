
//Namespace
package com.quiniela.wc.service;

//Imports
import com.quiniela.wc.domain.model.Match;
import com.quiniela.wc.domain.rest.TeamRecord;
import com.quiniela.wc.repository.QuinielaRepository;
import com.quiniela.wc.repository.StandingsRepository;
import com.quiniela.wc.service.impl.QuinielaServiceImpl;
import com.quiniela.wc.service.impl.StandingsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Unit test class
 */
@ActiveProfiles("unitTest")
@RunWith(SpringRunner.class)
public class StandingsServiceTest {
    //Fields
    @Mock
    private StandingsRepository standingsRepository;

    @InjectMocks
    private StandingsService standingsService = new StandingsServiceImpl();


    /**
     * Setup
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Assert.assertNotNull(standingsService);
    }

    @Test
    public void generateDefaultStandingsTest() throws Exception {
        Mockito.doReturn(new ArrayList<TeamRecord>()).when(standingsRepository).generateDefaultStandings();
        standingsService.retrieveDefaultStandings();
        Mockito.verify(standingsRepository, Mockito.times(1)).generateDefaultStandings();
    }
}