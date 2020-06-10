
//Namespace
package com.quiniela.wc.service;

//Imports
import com.quiniela.wc.domain.Match;
import java.util.List;

/**
 * Class that handles quiniela operations
 */
public interface QuinielaService {
    List<Match> retrieveQuiniela(String username);
    void saveQuiniela(List<Match> quiniela, String username);
}
