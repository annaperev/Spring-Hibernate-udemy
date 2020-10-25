package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import jdk.jfr.Label;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    @Label("dg")
    private String name;

    @Label("erwerw")
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire){

        // simulate an exception
        if (tripWire){
            throw  new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccount = new ArrayList<>();

        // create sample Accounts
        Account temp1 = new Account("John","Silver");
        Account temp2 = new Account("Madhu","Platinum");
        Account temp3 = new Account("Luca","Gold");

        // add them to list
        myAccount.add(temp1);
        myAccount.add(temp2);
        myAccount.add(temp3);

        return myAccount;
    }

    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass() + ": doing my db work: adding an account\n" );
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()\n");
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
