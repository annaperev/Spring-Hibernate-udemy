package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("=====> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSig);

        //display method argument

        //ger arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through arg
        for (Object tempArg:args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
               // downcast and print
               Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }
}
