package com.luv2code.springdemo.annotationwithxmlandsetterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationWithXMLAndSetterInjectionDemoApp {
    public static void main(String[] args) {

        // read spring container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotationWithXMLAndSetterInjection.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on a bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
