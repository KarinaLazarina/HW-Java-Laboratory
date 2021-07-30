package com.epam.homework1.beans4;

import com.epam.homework1.otherBeans.OtherBeanA;
import com.epam.homework1.otherBeans.OtherBeanB;
import com.epam.homework1.otherBeans.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bean1 {
    private OtherBeanA otherBeanA;

    @Qualifier("myBean")
    @Autowired
    private OtherBeanB otherBeanB;
    private OtherBeanC otherBeanC;

    @Autowired
    public Bean1(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }

    @Autowired
    public void setOtherBeanC(OtherBeanC otherBeanC) {
        this.otherBeanC = otherBeanC;
    }

    public OtherBeanA getOtherBeanA() {
        return otherBeanA;
    }

    public OtherBeanB getOtherBeanB() {
        return otherBeanB;
    }

    public OtherBeanC getOtherBeanC() {
        return otherBeanC;
    }
}
