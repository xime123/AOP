package com.example.xumin.myapplication;

import com.example.xumin.myapplication.annotation.Strategy;

public class Caculate {
    @Strategy(type = 1)
    public void doSomething(){
        System.out.println("==========doSomething");
    }
}
