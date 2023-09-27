package org.example.HW12.task2;

import java.util.List;

public class Number extends Thread{

    private int i;
    private List<Object> result ;

    public Number(int i, List<Object> result) {
        this.i = i;
        this.result = result;
    }

    @Override
    public void run() {
        if(i % 3 != 0 && i % 5 != 0){
            result.add(i);
        }

    }
}
