package com.luv2code.springdemo.annotationwithxmpostconstruct;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationWithXMLPostConstructDemoApp {
    public static void main(String[] args) {

        // read spring container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotationWithXMLPostConstruct.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
