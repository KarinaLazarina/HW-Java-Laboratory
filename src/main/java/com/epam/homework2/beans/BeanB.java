package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class BeanB {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private String value;


    public BeanB() {
        System.out.println("BeanB constructor");
    }


    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void myInitMethod() {
        System.out.println("BeanB custom init method");
    }
    private void anotherInitMethod() {
        System.out.println("BeanB another init method");
    }
    private void myDestroyMethod() {
        System.out.println("BeanB custom destroy method");
    }
}
