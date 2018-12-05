package com.example.demo.controller;

import com.example.demo.dao.SpeciesDAO;
import com.example.demo.model.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zoud
 * @Date: 2018/12/5
 **/

@Controller
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesDAO speciesDAO;

    @RequestMapping("type/{type}")
    @ResponseBody
    public List<Species> findBySpeciesType(@PathVariable("type") String type){
        return speciesDAO.findBySpeciesType(type);
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Species> findAll(){
        return speciesDAO.findAll();
    }

    @RequestMapping("save")
    public String save(Species species){
        speciesDAO.save(species);
        return "redirect:/index";
    }
}
