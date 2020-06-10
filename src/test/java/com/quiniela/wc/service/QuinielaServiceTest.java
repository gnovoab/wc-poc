
//Namespace
package com.quiniela.wc.service;

//Imports
import com.quiniela.wc.domain.model.Match;
import com.quiniela.wc.repository.QuinielaRepository;
import com.quiniela.wc.service.impl.QuinielaServiceImpl;
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
public class QuinielaServiceTest {
    //Fields
    @Mock
    private QuinielaRepository quinielaRepository;

    @InjectMocks
    private QuinielaService quinielaService = new QuinielaServiceImpl();


    private static final String USERNAME = "unitTest";

    /**
     * Setup
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Assert.assertNotNull(quinielaService);
    }

    @Test
    public void testRetrieveQuiniela() throws Exception {
        Mockito.doReturn(new ArrayList<Match>()).when(quinielaRepository).findByUser(USERNAME);
        quinielaService.retrieveQuiniela(USERNAME);
        Mockito.verify(quinielaRepository, Mockito.times(1)).findByUser(USERNAME);
    }

    @Test
    public void testSaveQuiniela() throws Exception {

        ArrayList<Match> quiniela = new ArrayList<>();

        //Set behaviour
        Mockito.doNothing().when(quinielaRepository).delete(USERNAME);
        Mockito.doNothing().when(quinielaRepository).save(quiniela, USERNAME);

        //Execute
        quinielaService.saveQuiniela(quiniela, USERNAME);

        //Verify
        Mockito.verify(quinielaRepository, Mockito.times(1)).delete(USERNAME);
        Mockito.verify(quinielaRepository, Mockito.times(1)).save(quiniela, USERNAME);
    }
}