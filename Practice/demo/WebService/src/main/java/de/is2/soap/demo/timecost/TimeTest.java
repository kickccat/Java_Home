package de.is2.webservice.demo.timecost;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TimeTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        MyThread myThread = new MyThread();
        Future<Long> future = new FutureTask<Long>(myThread);
        long end = future.get();
        System.out.println(end - start);
    }
}
