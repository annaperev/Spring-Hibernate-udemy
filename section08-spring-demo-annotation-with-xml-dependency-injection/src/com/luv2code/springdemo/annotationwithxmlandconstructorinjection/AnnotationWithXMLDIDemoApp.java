package com.luv2code.springdemo.annotationwithxmlandconstructorinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationWithXMLDIDemoApp {
    public static void main(String[] args) {

        // read spring container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotationWithXMLAndConstructorInjection.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on a bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
