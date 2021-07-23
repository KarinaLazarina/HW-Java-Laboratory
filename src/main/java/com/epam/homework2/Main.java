package com.epam.homework2;

import com.epam.homework2.beans.BeanB;
import com.epam.homework2.beans.BeanD;
import com.epam.homework2.beans.BeanF;
import com.epam.homework2.configs.AppConfig1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);

        context.getBean(BeanF.class);

        context.close();

    }

}
