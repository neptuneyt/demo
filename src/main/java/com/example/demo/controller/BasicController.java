package com.example.demo.controller;

import com.example.demo.dao.SpeciesDAO;
import com.example.demo.model.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: zoud
 * @Date: 2018/12/3
 **/


@Controller /*注解作用：告诉程序这是一个控制组件*/
@RequestMapping("/") /*地址映射，方法中所有映射的父路径*/
public class BasicController {

    @Autowired
    private SpeciesDAO speciesDAO;

    @RequestMapping({"", "index", "home"}) /*将地址映射集合*/
    public String home(ModelMap modelMap){
        //查询所有物种，放在List中
        List<Species> speciesList = speciesDAO.findAll();

        //将查询结果保存在一个map中，传入前台页面
        modelMap.put("list", speciesList);

        //返回index.jsp
        return "index";
    }

    @RequestMapping("/grid")
    public String grid(){
        return "grid";
    }
}
