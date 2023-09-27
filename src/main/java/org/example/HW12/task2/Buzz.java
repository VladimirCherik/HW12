package org.example.HW12.task2;

import java.util.List;

public class Buzz extends Thread{

    private int i;
    private List<Object> result ;

    public Buzz(int i, List<Object> result) {
        this.i = i;
        this.result = result;
    }

    @Override
    public void run() {
        if(i % 5 == 0 && i % 3 != 0){
            result.add("buzz");
        }

    }
}
