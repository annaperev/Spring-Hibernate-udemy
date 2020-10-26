package com.luv2code.springdemo.annotationwithxmlmultipleservices;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "RESTFortuneService ";
    }
}
