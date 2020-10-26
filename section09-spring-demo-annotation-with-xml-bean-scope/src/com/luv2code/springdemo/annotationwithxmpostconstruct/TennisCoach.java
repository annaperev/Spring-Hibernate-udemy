package com.luv2code.springdemo.annotationwithxmpostconstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype") // default = @Scope("singleton")
public class TennisCoach implements Coach {


    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constuctor");
    }


    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartupStuff method ");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff method ");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

}
