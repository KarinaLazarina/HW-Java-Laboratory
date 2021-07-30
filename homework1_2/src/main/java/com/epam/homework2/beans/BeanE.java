package com.epam.homework2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements CustomBean{
    private String name;
    private int value;


    public BeanE() {
        System.out.println("BeanE constructor");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("BeanE postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("BeanE preDestroy");
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
