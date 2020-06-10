
//Namespace
package com.quiniela.wc.service.impl;

//Imports
import com.quiniela.wc.domain.model.Match;
import com.quiniela.wc.repository.QuinielaRepository;
import com.quiniela.wc.service.QuinielaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * class that handles quiniela operations
 */
@Service
public class QuinielaServiceImpl implements QuinielaService {

    //Fields
    @Autowired
    private QuinielaRepository quinielaRepository;


    /**
     * Retrieves quiniela froa user given
     * @param username
     * @return
     */
    @Override
    public List<Match> retrieveQuiniela(String username) {
        return quinielaRepository.findByUser(username);
    }

    /**
     * Saves user's quiniela
     * @param quiniela
     * @param username
     */
    @Override
    @Transactional
    public void saveQuiniela(List<Match> quiniela, String username) {
        quinielaRepository.delete(username);
        quinielaRepository.save(quiniela, username);
    }

}