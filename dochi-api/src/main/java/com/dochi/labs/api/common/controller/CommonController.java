package com.dochi.labs.api.common.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dochi.labs.common.dao.CommonSqlDAO;

@RestController
@RequestMapping("/api/common")
public class CommonController {
    
    @Autowired
    CommonSqlDAO commaonSql;

    @GetMapping("")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        try {
            return String.format("Hello %s!", commaonSql.selectOne("Sample.getNow"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Hello~~?";
    }

    @GetMapping("/hello")
    public String hello2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
}
