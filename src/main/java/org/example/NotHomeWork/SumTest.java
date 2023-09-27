package org.example.NotHomeWork;

import java.math.BigDecimal;

public class SumTest {
    public static void main(String[] args) {
        //sum                500000000500000000, time ms: 12499
        //SumTestWithThreads 500000000500000000, time ms: 703

        long start = System.currentTimeMillis();

        BigDecimal sum = BigDecimal.ZERO;

        for (int i = 0; i <= 1_000_000_000; i++) {
            sum = sum.add(BigDecimal.valueOf(i));
        }
        long finish = System.currentTimeMillis() - start;
        System.out.println("sum " + sum + ", time ms: " + finish);
    }
}
