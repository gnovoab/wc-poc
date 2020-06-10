
//Namespace
package com.quiniela.wc.repository;

//Imports
import com.quiniela.wc.domain.Match;

import java.util.List;

/**
 * Class that handles quiniela operations
 */
public interface QuinielaRepository {
    List<Match> findByUser(String username);
    void delete(String username);
    void save(List<Match> quiniela, String username);
}
