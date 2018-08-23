package com.example.xumin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xumin.myapplication.annotation.FileAnotation;
import com.example.xumin.myapplication.annotation.Strategy;
import com.example.xumin.myapplication.annotation.TypeAnotation;

@TypeAnotation(className = "com.example.xumin.myapplication.MainActivity")
public class MainActivity extends AppCompatActivity {
    @FileAnotation(field = Integer.class)
    private int mCount;

    @Override
    @Strategy(type = 1)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Strategy(type = 2)
    public void testAnotation() {
        System.out.println("==========testAnotation");
    }

    public void test(View view) {
        testAnotation();
        Caculate caculate=new Caculate();
        caculate.doSomething();
    }
}
