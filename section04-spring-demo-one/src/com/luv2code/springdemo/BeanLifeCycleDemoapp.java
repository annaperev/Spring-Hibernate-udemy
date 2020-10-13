package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoapp {

    public static void main(String[] args) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        //retrieve bean from spring config
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // check if they are the same
        System.out.println(theCoach.getDailyWorkout());

        // close context
        context.close();

    }
}
