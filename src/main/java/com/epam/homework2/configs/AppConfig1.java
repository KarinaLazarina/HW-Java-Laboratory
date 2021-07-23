package com.epam.homework2.configs;

import com.epam.homework2.beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig2.class)
public class AppConfig1 {

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    public BeanFPP beanFPP() {
        return new BeanFPP();
    }

    @Bean
    public BeanPP beanPP() {
        return new BeanPP();
    }
}
