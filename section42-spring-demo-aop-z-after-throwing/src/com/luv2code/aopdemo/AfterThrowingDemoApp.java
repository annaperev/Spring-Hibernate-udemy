package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get AccountDAO bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        // call method to find the accounts
        List<Account> theAccounts = null;
        try{
            // flag to simulate exception
            boolean tripWire = true;
            theAccounts = accountDAO.findAccounts(tripWire);
        }
        catch (Exception e){
            System.out.println("\n\nMain Program ... caught exception: " + e);
        }

        // display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
