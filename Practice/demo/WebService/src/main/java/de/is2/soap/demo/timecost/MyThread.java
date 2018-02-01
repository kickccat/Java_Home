package de.is2.webservice.demo.timecost;

import java.util.concurrent.Callable;

public class MyThread implements Callable<Long>{

    private String str = "";
    private int count = 20000;
    @Override
    public Long call() throws Exception {
        for (int i=0; i<this.count;i++){
            str += i;
        }
        return System.currentTimeMillis();
    }
}
