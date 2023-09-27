package org.example.HW12;

import java.util.ArrayList;
import java.util.List;

public class Task2WithoutThreads {
    public static void main(String[] args) {

        new Work().toDo();
    }
    private static class Work{

        List<String> string = new ArrayList<>();
        void toDo (){

            for (int i = 1; i <= 15; i++) {

                if(i % 3 == 0 && i % 5 == 0){
                    string.add("fizzbuzz");
                } else if (i % 5 == 0){
                    string.add("buzz");
                } else if(i % 3 == 0){
                    string.add("fizz");
                } else {
                    string.add(Integer.toString(i));
                }
            }
            System.out.println(string);
        }
    }

}
