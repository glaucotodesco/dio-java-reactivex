package com.example;


import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;fi
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.schedulers.Schedulers;

public final class App5 {
    public static void main(String[] args) throws InterruptedException{
        Flowable.create(App5::emit, 
                        BackpressureStrategy.BUFFER
                        //BackpressureStrategy.DROP
                        //BackpressureStrategy.ERROR
                        //BackpressureStrategy.LATEST
                        //BackpressureStrategy.MISSING
        )
        .observeOn(Schedulers.computation(), true, 2)   //if comment this line, just in Thread will run
        .subscribe(App5::process);
        
        sleep(10000);
    }

  

    private static void process(Integer number){
        System.out.println("Process Number: " + number);
        sleep(1000);
    }

    
    private static void emit(FlowableEmitter<Integer> emmiter) throws InterruptedException{
        
        IntStream.rangeClosed(1,10)
                 .forEach(
                        n ->
                        {
                            System.out.println("Emit value: " + n);
                            emmiter.onNext(n);
                            sleep(500);
                        }
                 );
        emmiter.onComplete();
    }

    private static void sleep(int value) {
        try {
            TimeUnit.MILLISECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


  
}