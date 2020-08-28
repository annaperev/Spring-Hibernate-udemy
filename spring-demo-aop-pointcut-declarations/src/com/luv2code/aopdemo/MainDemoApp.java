package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get AccountDAO bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

        // get membership bean
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account myAccount = new Account();

        // call the business method
        accountDAO.addAccount(myAccount, true);
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();

        // close the context
        context.close();
    }
}
