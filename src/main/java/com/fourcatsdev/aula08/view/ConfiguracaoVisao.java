package com.fourcatsdev.aula08.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ConfiguracaoVisao implements WebMvcConfigurer {


    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/auth/admin/publica-index").setViewName("/auth/admin/publica-index");
       // registry.addViewController("/auth/user/publica-index").setViewName("/auth/user/publica-index");
        registry.addViewController("/auth/auth-acesso-negado").setViewName("/auth/auth-acesso-negado");

    }

}
