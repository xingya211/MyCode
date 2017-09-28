package com.my.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.my.test.*.*(..))")
    public void perform(){};

    @Before("perform()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }

    @After("perform()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @Around("perform()")
    public void watchPerformance(ProceedingJoinPoint jp){

        try {
            System.out.println("Take seates");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("Demanding a refund");
        }
    }
}
