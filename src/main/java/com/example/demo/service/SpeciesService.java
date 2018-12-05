package com.example.demo.service;

import com.example.demo.dao.SpeciesDAO;
import com.example.demo.model.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zoud
 * @Date: 2018/12/5
 **/

@Service
public class SpeciesService {

    @Autowired
    private SpeciesDAO speciesDAO;

    public Species save(Species species){
        return speciesDAO.save(species);
    }
}
