package com.epam.homework1.config;

import com.epam.homework1.beans3.BeanD;
import com.epam.homework1.beans3.BeanF;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.epam.homework1.beans2")
public class AppConfig2 {

    @Bean
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public BeanF beanF() {
        return new BeanF();
    }
}
