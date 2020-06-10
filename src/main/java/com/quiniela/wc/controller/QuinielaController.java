
//Namespace
package com.quiniela.wc.controller;


import com.quiniela.wc.domain.constants.Constants;
import com.quiniela.wc.domain.model.Match;
import com.quiniela.wc.service.QuinielaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "QUINIELA", protocols = "https")
@RestController
@RequestMapping("/api/v1/quiniela")
public class QuinielaController {

    //Fields
    @Autowired
    private transient QuinielaService quinielaService;

    @ApiOperation(
            value = "Retrieves user's quiniela",
            response = List.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request has succeeded"),
            @ApiResponse(code = 400, message = "Malformed request syntax"),
            @ApiResponse(code = 500, message = "The service encountered a problem.")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Match>> fetchQuiniela() {

        //Retrieve quiniela
        List<Match> quiniela = quinielaService.retrieveQuiniela(Constants.TEMP_USER);

        //Return the matches
        return new ResponseEntity<>(quiniela, HttpStatus.OK);
    }


}
