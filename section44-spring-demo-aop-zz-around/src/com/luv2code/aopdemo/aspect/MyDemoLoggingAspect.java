package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
//@Order(1)
public class MyDemoLoggingAspect {

    // 354
    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = proceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and print it out
        long duration = end-begin;
        System.out.println("\n=====> Duration: " + duration/1000.0 + " seconds");

        return result;
    }


    // 350
    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFincAccountsAdvice(JoinPoint theJoinPoint) {
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);
    }

    // 348
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(
            JoinPoint theJoinPoint, // for metadata
            Throwable theExc
    ) {
        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n====>>> The exception is: " + theExc);

    }

    // 344 add a new advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"// same name as parameter name below
    )
    public void afterReturningFindAccountAdvice(
            JoinPoint theJoinPoint, List<Account> result
    ) {

        //print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        System.out.println("\n====>>> result is: " + result);

        // 346 post-process the data

        // convert the account name to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for (Account tempAccount : result) {

            // get upper case version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("=====> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSig);

        //display method argument

        //ger arguments
        Object[] args = theJoinPoint.getArgs();

        // loop through arg
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                // downcast and print
                Account theAccount = (Account) tempArg;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }
}
