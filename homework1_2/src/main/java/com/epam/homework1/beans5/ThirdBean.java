package com.epam.homework1.beans5;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ThirdBean implements IBean{
    @Override
    public String returnName() {
        return "ThirdBean";
    }
}
