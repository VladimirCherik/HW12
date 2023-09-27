package org.example.HW12.task2;

import java.util.List;

public class FizzBuzz extends Thread{

    private int i;
    private List<Object> result ;


    public FizzBuzz(int i, List<Object> result) {
        this.i = i;
        this.result = result;

    }

    @Override
    public void run() {
        if(i % 15 == 0){
            result.add("fizzbuzz");

        }

    }
}
