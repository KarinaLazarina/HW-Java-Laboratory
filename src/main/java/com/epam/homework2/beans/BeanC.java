package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class BeanC {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private String value;


    public BeanC() {
        System.out.println("BeanC constructor");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void myInitMethod() {
        System.out.println("BeanC custom init method");
    }
    private void myDestroyMethod() {
        System.out.println("BeanC custom destroy method");
    }
}
