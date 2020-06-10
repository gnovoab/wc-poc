
//Namespace
package com.quiniela.wc.controller;

import com.quiniela.wc.domain.model.Match;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Integration Test Class
 */
@ActiveProfiles("integrationTest")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuinielaControllerIntegrationTest {

    //Fields
    private static final String BASE_URL = "/api/v1/quiniela";

    @Autowired
    private transient TestRestTemplate restTemplate;

    @Test
    public void testRetrieveQuiniela() throws Exception {

        //Set the headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        //Create the http request
        HttpEntity<?> request = new HttpEntity<>(requestHeaders);

        //Invoke the API service
        ResponseEntity<List<Match>> response = restTemplate
                .exchange(BASE_URL, HttpMethod.GET, request,  new ParameterizedTypeReference<List<Match>>() { });

        //Verify
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

