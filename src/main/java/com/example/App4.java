package com.example;

import java.util.concurrent.TimeUnit;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public final class App4 {
    public static void main(String[] args) throws InterruptedException{
    
        Scheduler scheduler = Schedulers.computation();
      
        Scheduler.Worker worker1 = scheduler.createWorker();
        Scheduler.Worker worker2 = scheduler.createWorker();

        worker1.schedule(() -> {
            while(true)
            {
                System.out.println("Work 1 working...");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        worker2.schedule(() -> {
            while(true)
            {
                System.out.println("Work 2 working...");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        
        TimeUnit.SECONDS.sleep(10);
    }
}
    