package com.example.xumin.myapplication.aspectj;

import android.util.Log;

import com.example.xumin.myapplication.MainActivity;
import com.example.xumin.myapplication.annotation.Strategy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class StrategyFilter {
    private static final String TAG = "StrategyFilter";

    /**
     * 1,注意不要漏掉了“@”,
     * 2,第一个星号（“*”）代表包的路径名，其实这里可以不填
     * 3,括号里的“（..）”代表任意类型参数和任意个数的参数
     * https://blog.csdn.net/vonnie_jade/article/details/68955248
     */
    @Pointcut("execution(@com.example.xumin.myapplication.annotation.Strategy * *(..))")
    public void testAspectj(){}

    @Pointcut("execution(@com.example.xumin.myapplication.Caculate.testNOAnotationTest * *(..))")
    public void testNO(){}

    @Around("testAspectj()")
    public void aroundTestPoint(ProceedingJoinPoint joinPoint) throws Throwable{
        Log.e(TAG,"aroundTestPoint s@@@@@@@@@@@@@@@@@@@@做一个1莎莎逻辑");
        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            Log.e(TAG,"Stragey 注解只能用于方法上");
            return;
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Strategy strategy=methodSignature.getMethod().getAnnotation(Strategy.class);
        if(strategy!=null){
            if(strategy.type()==1){
                joinPoint.proceed();
                Log.e(TAG,"做一个1莎莎逻辑");
            }else {
                Log.e(TAG,"做一个2莎莎逻辑");
            }
        }
    }

    @Before("execution(* *..Caculate+.testNO**(..))")
    public void testNoAnotationBefore(){
        System.out.println("执行testNOAnotationTest前 先执行testNoAnotationBefore");
    }

    /**
     * 第一个“*”必要的 表示返回值，任意类型
     *
     */
    @After("* execution(com.example.xumin.myapplication.Caculate.testNOAnotationTest(..))")
    public void testNoAnotationAfter(){
        System.out.println("执行testNOAnotationTest后 再执行testNoAnotationAfter");
    }

}
