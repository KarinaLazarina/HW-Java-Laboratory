package com.epam.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA implements InitializingBean, DisposableBean, CustomBean {
    private String name = "name";
    private int value = 10;

    public BeanA() {
        System.out.println("BeanA constructor");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA afterPropertiesSet");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }
}
