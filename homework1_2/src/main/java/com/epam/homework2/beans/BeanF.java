package com.epam.homework2.beans;

public class BeanF implements CustomBean{
    private String name;
    private int value;


    public BeanF() {
        System.out.println("BeanF constructor");
    }


    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
