package com.my.test.impl;

import com.my.test.inter.Performance;
import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl implements Performance {

    public void perform() {
        System.out.println("perform");
    }
}
