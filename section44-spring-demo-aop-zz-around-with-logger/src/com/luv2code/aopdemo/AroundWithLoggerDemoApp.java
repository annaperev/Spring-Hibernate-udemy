package com.luv2code.aopdemo;

import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    // 355
    private static Logger myLogger =
            Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get TrafficFortuneService bean from spring container
        TrafficFortuneService fortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        String data = fortuneService.getFortune();

        myLogger.info("\nMy Fortune is: " + data);
        // close the context
        context.close();
    }
}
