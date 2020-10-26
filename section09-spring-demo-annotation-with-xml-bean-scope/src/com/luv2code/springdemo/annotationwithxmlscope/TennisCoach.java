package com.luv2code.springdemo.annotationwithxmlscope;

import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") // default = @Scope("singleton")
public class TennisCoach implements com.luv2code.springdemo.annotationwithxmlscope.Coach {


    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constuctor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

}
