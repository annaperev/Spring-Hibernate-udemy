package com.luv2code.springdemo.annotationwithXML;

import org.springframework.stereotype.Component;

@Component // using default bean id
public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters every day";
    }
}
