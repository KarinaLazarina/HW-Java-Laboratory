package com.epam.homework1.config;

import com.epam.homework1.beans4.Bean1;
import com.epam.homework1.otherBeans.OtherBeanA;
import com.epam.homework1.otherBeans.OtherBeanB;
import com.epam.homework1.otherBeans.OtherBeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.epam.homework1.beans4")
public class AppConfig3 {
    @Bean
    public OtherBeanA otherBeanA() {
        return new OtherBeanA();
    }

    @Bean
    public OtherBeanB myBean() {
        return new OtherBeanB();
    }

    @Bean
    public OtherBeanC otherBeanC() {
        return new OtherBeanC();
    }
}
