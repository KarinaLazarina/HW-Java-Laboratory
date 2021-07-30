package com.epam.homework2.configs;

import com.epam.homework2.beans.BeanB;
import com.epam.homework2.beans.BeanC;
import com.epam.homework2.beans.BeanD;
import com.epam.homework2.beans.BeanF;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig2 {
    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "myInitMethod",
            destroyMethod = "myDestroyMethod")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }
}
