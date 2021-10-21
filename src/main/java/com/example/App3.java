package com.example;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;

public final class App3 {
    public static void main(String[] args) throws InterruptedException{

    
        Flowable.interval(1, 1, TimeUnit.SECONDS)
                .map(App3::transform)
                .subscribe(App3::processSuccess, App3::processError);
       

        TimeUnit.SECONDS.sleep(10);
    }

    private static void processError(Throwable error){
        System.out.println("ERROR!");
    }


    private static void processSuccess(Long number){
        System.out.println(number);
    }



    private static Long transform(Long number){
        if( new Random().nextDouble() < 0.3){
            throw new RuntimeException("Ops!");
        }
        return number * 2;
    }
}