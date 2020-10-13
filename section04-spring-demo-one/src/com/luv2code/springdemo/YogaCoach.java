package com.luv2code.springdemo;

public class YogaCoach implements Coach {

    private FortuneService fortuneService;



    @Override
    public String getDailyWorkout() {
        return "Yoga flow twice a day";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
