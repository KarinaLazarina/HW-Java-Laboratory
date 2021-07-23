package com.epam.homework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPP implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof CustomBean){
            if(((CustomBean) bean).getName() != null && ((CustomBean) bean).getValue() >0){
                System.out.println(beanName + " is valid!");
            }
            else {
                System.out.println(beanName + " is invalid!");
            }
        }
        return bean;
    }
}
