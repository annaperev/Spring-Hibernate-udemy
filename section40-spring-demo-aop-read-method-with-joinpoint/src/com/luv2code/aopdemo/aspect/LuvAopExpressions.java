package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
//Utility class for holding pointcuts
public class LuvAopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // create pointcut for getter method
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){}

    // create pointcut for setter method
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){}

    // create pointcut: include package .. exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() ||  setter())")
    public void forDaoPackageNoGetterSetter(){}
}
