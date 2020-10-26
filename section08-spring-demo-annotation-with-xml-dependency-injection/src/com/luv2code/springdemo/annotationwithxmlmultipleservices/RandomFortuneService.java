package com.luv2code.springdemo.annotationwithxmlmultipleservices;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of string
    private String [] data = {
            "First random fortune",
            "Second random fortune",
            "Third random fortune"};

    // create a random number generator
    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index  = myRandom.nextInt(data.length);

        String theFortune = data[index];

        return theFortune;
    }
}
