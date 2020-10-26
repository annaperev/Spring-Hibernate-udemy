package com.luv2code.springdemo.annotationwithxmlscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationWithXMLScopeDemoApp {
    public static void main(String[] args) {

        // read spring container
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotationWithXMLScope.xml");

        // get the bean from spring container
        com.luv2code.springdemo.annotationwithxmlscope.Coach theCoach = context.getBean("tennisCoach", com.luv2code.springdemo.annotationwithxmlscope.Coach.class);
        com.luv2code.springdemo.annotationwithxmlscope.Coach alphaCoach = context.getBean("tennisCoach", com.luv2code.springdemo.annotationwithxmlscope.Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        // print out the reasult
        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCoach: " + theCoach);
        System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

        // close the context
        context.close();
    }
}
