package com.epam.homework1.beans5;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class FirstBean implements IBean{
    @Override
    public String returnName() {
        return "FirstBean";
    }
}
