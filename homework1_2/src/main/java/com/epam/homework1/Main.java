package com.epam.homework1;

import com.epam.homework1.beans4.Bean1;
import com.epam.homework1.beans5.Container;
import com.epam.homework1.config.AppConfig1;
import com.epam.homework1.config.AppConfig2;
import com.epam.homework1.config.AppConfig3;
import com.epam.homework1.config.AppConfig4;
import com.epam.homework1.otherBeans.OtherBeanA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig1.class);
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig2.class);
        ApplicationContext context3 = new AnnotationConfigApplicationContext(AppConfig3.class);
        ApplicationContext context4 = new AnnotationConfigApplicationContext(AppConfig4.class);

        for (String name : context1.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        System.out.println("----------------------");

        for (String name : context2.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        System.out.println("----------------------");

        Bean1 bean1 = context3.getBean(Bean1.class);

        System.out.println(bean1.getOtherBeanA());
        System.out.println(bean1.getOtherBeanB());
        System.out.println(bean1.getOtherBeanC());

        System.out.println("----------------------");

        context4.getBean(Container.class).printNames();


    }
}
