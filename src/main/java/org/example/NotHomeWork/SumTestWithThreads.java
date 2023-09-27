package org.example.NotHomeWork;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SumTestWithThreads {


    public static void main(String[] args) throws InterruptedException {
        //
        long startTime = System.currentTimeMillis();

        long[][] startFinish = {
                {0, 1_000_000_00},
                {1_000_000_01, 2_000_000_00},
                {2_000_000_01, 3_000_000_00},
                {3_000_000_01, 4_000_000_00},
                {4_000_000_01, 5_000_000_00},
                {5_000_000_01, 6_000_000_00},
                {6_000_000_01, 7_000_000_00},
                {7_000_000_01, 8_000_000_00},
                {8_000_000_01, 9_000_000_00},
                {9_000_000_01, 1_000_000_000}
        };
        //список потоков
        List<Thread> threads = new ArrayList<>();

        //список результатов каждого потока
        List<BigDecimal> results = new CopyOnWriteArrayList<>();


        for(long[] pair : startFinish){
            long start = pair[0];
            long end = pair[1];

            SumThread thread = new SumThread(start, end, results);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads){
            thread.join();
        }

        BigDecimal finalResult = BigDecimal.ZERO;
        for(BigDecimal subSum : results){

            finalResult = finalResult.add(subSum);
        }

        long finish = System.currentTimeMillis() - startTime;
        System.out.println("SumTestWithThreads " + finalResult + ", time ms: " + finish);
    }
    private static class SumThread extends Thread{
        private long start;
        private long end;
        private List<BigDecimal> result;

        public SumThread(long start, long end, List<BigDecimal> result) {
            this.start = start;
            this.end = end;
            this.result = result;
        }

        @Override
        public void run() {
            long tmpSum = 0 ;

            for(long i = start; i <=end; i++){
                tmpSum += i;
            }
            result.add(BigDecimal.valueOf(tmpSum));
        }
    }
}
