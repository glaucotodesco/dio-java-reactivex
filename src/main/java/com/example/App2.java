package com.example;

import java.util.concurrent.TimeUnit;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public final class App2 {
    public static void main(String[] args) throws InterruptedException{

        //Using Flowable and Observale,  reactive
        Flowable.interval(1, 1, TimeUnit.SECONDS).map( n -> n * 2).subscribe(System.out::println);
        Observable.interval(1,1 , TimeUnit.SECONDS).map( n -> n * -1).subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);
    }
}