package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import reflection.ReflectionAnnotation;
import jdk.jfr.Label;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    @Label("dg")
    private String name;
    @ReflectionAnnotation
    @Label("erwerw")
    @SuppressWarnings(value = "")
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": doing my db work: adding an account");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": getName ()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
