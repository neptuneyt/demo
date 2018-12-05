package com.example.demo.controller;

import com.example.demo.dao.SpeciesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zoud
 * @Date: 2018/12/3
 **/

@Controller
@RequestMapping("/")
public class BasicController {

    @Autowired
    private SpeciesDAO speciesDAO;

    @RequestMapping({"", "index", "home"})
    public String home(ModelMap modelMap){
        modelMap.put("list", speciesDAO.findAll());
        return "index";
    }
}
