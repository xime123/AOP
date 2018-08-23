package com.example.xumin.myapplication;

import com.example.xumin.myapplication.annotation.FileAnotation;
import com.example.xumin.myapplication.annotation.Strategy;
import com.example.xumin.myapplication.annotation.TypeAnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnotation {
    public static void main(String args[]) {
        boolean hasAnotation = MainActivity.class.isAnnotationPresent(TypeAnotation.class);
        if (hasAnotation) {
            TypeAnotation typeAnotation = MainActivity.class.getAnnotation(TypeAnotation.class);
            System.out.println("类名::" + typeAnotation.className());
        }

        try {
            Field field = MainActivity.class.getDeclaredField("mCount");
            field.setAccessible(true);
            FileAnotation fileAnotation = field.getAnnotation(FileAnotation.class);
            System.out.println("变量类型::" + fileAnotation.field().getTypeName());
            Method methods[]=MainActivity.class.getMethods();
            if(methods!=null&&methods.length>0){
                for(Method method:methods){
                    Strategy strategy=method.getAnnotation(Strategy.class);
                    if(strategy!=null){
                       // System.out.println("strategy.msg()="+strategy.msg());
                        System.out.println("strategy.type()="+strategy.type());

                    }
                }
            }else {
                System.out.println("methods length is zero!!!");
            }
        } catch (Exception e) {
            System.out.println(" message::" + e.getMessage() + "   error=" + e.getCause());
            e.printStackTrace();
        }
    }
}
