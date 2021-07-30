package com.epam.homework2;


import com.epam.homework2.beans.BeanB;
import com.epam.homework2.beans.BeanF;
import com.epam.homework2.beans.CustomBean;
import com.epam.homework2.configs.AppConfig1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        context.getBean(BeanF.class);

        BeanB b = context.getBean(BeanB.class);
        System.out.println(b);

        context.close();

    }

}
