
//Namespace
package com.quiniela.wc.repository.impl;

//Imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Master class that handles dao operations
 */
@Component
public class BaseRepository {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}