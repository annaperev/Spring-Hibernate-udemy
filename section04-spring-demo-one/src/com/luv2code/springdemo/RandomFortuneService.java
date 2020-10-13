package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{

    private String data[] = {"1","2","3"};

    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt() % data.length;
        String result = data[index];
        return "Fortune is " + result  + " today";
    }
}
