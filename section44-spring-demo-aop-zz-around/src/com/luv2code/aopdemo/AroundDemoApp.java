package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get TrafficFortuneService bean from spring container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        String data = fortuneService.getFortune();

        System.out.println("\nMy Fortune is: " + data);
        // close the context
        context.close();
    }
}
