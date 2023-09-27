package org.example.HW12;


public class Task1 {
    public static void main(String[] args) {
        long startSec = System.currentTimeMillis() / 1000;

        new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    //NOP
                }
                System.out.println(("5 seconds have passed since beginning or last messege - " +
                        (System.currentTimeMillis() / 1000 - startSec)));
            }
        }).start();

        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //NOP
            }
            System.out.println(("the time since the beginning of start the program - " +
                    (System.currentTimeMillis() / 1000 - startSec)));
        }
    }
}