package com.luv2code.springdemo.annotationwithXML;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
