package com.luv2code.springdemo.annotationwithxmlfieldinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationWithXMLFieldInjectionDemoApp {
    public static void main(String[] args) {

        // read spring container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotationWithXMLFieldInjection.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on a bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
