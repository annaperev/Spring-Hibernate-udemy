package com.luv2code.springdemo.annotationwithXML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationWithXMLDemoApp {
    public static void main(String[] args) {

        // read spring container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotationWithXML.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        // get bean with default bean ID
        Coach theSwimCoach = context.getBean("swimCoach", Coach.class);

        // call a method on a bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theSwimCoach.getDailyWorkout());


        // close the context
        context.close();
    }
}
