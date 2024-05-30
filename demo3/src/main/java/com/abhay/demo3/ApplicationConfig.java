package com.abhay.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public MyFirstClass myFirst(){
        return new MyFirstClass("First Bean");
    }
}
