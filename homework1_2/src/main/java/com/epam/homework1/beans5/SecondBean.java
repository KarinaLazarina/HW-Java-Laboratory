package com.epam.homework1.beans5;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Primary
public class SecondBean implements IBean{
    @Override
    public String returnName() {
        return "SecondBean";
    }
}
