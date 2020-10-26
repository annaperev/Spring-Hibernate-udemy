package com.luv2code.springdemo.annotationwithxmlmultipleservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    // без аннотации Qualifier будет ошибка
    // No qualifying bean of type
    // 'com.luv2code.springdemo.annotationwithxmlmultipleservices.FortuneService'
    // available: expected single matching bean but found 3: dataBaseFortuneService,
    // happyFortuneService,RESTFortuneService
    private FortuneService fortuneService;

    @Qualifier("RESTFortuneService")
    private FortuneService restFortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constuctor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
