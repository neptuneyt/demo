package com.example.demo.dao;

import com.example.demo.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: zoud
 * @Date: 2018/12/5
 **/
@Repository
public interface SpeciesDAO extends JpaRepository<Species, Integer> {
    List<Species> findBySpeciesType(String s);
}
