package com.epam.homework1.beans5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Container {
    @Autowired
    private List<IBean> beans;

    public void printNames(){
        for (IBean bean : beans) {
            System.out.println(bean.returnName());
        }
    }
}
