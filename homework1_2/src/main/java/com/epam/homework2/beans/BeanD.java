package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class BeanD {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private String value;


    public BeanD() {
        System.out.println("BeanD constructor");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void myInitMethod() {
        System.out.println("BeanD custom init method");
    }

    private void myDestroyMethod() {
        System.out.println("BeanD custom destroy method");
    }

}
