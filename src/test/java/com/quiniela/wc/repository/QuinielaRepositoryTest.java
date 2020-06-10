
//Namespace
package com.quiniela.wc.repository;

import com.quiniela.wc.domain.Match;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Unit test class
 */
@ActiveProfiles("unitTest")
@SpringBootTest
public class QuinielaRepositoryTest {

    //Fields
    @Autowired
    private transient QuinielaRepository quinielaRepository;

    @Test
    public void save() {
        List<Match> quiniela = quinielaRepository.findByUser("");

        //Validate
        Assert.assertNotNull(quiniela);
        Assert.assertTrue(quiniela.size() > 0);
    }
}
