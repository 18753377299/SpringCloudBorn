package com.example.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

//@Configuration
public class CustomZuulConfig {

    @Autowired
    ZuulProperties zuulProperties;
    
    @Autowired
    ServerProperties server;
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public CustomRouteLocator routeLocator() {
    	System.out.println("=========CustomZuulConfig===================");
        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
        routeLocator.setJdbcTemplate(jdbcTemplate);
        return routeLocator;
    }
    
    

}