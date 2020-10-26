package com.luv2code.springdemo.javacodeconfigaddbean;

public class SwimCoach implements Coach {

    private FortuneService theFortune;

    public SwimCoach(FortuneService theFortune) {
        this.theFortune = theFortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return theFortune.getFortune();
    }
}
