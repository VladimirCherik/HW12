package org.example.HW12.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        // для зберігання результату перевірок
        List<Object> results = new CopyOnWriteArrayList<>();
        // для зберігання потоків
        List <Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {

            FizzBuzz fizzBuzz = new FizzBuzz(i, results);
            fizzBuzz.start();
            threads.add(fizzBuzz);
            Thread.sleep(10);

            Fizz fizz = new Fizz(i, results);
            fizz.start();
            threads.add(fizz);
            Thread.sleep(10);

            Buzz buzz = new Buzz(i, results);
            buzz.start();
            threads.add(buzz);
            Thread.sleep(10);

            Number number = new Number(i, results);
            number.start();
            threads.add(number);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(results);
    }
}
