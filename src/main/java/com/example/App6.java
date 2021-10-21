package com.example;


import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow.Subscription;

public final class App6 {
    public static void main(String[] args) throws InterruptedException{

        CustomSubscriber customSubscriber = new CustomSubscriber();
        
        try(SubmissionPublisher <Integer> publisher = new SubmissionPublisher<>()){
            publisher.subscribe(customSubscriber);
            IntStream.range(1, 10)
                     .forEach( i -> {
                         System.out.println("emmit value" + i);
                         publisher.submit(i);
                     });
        }

        sleep(10000);
    }

  
    private static void sleep(int value) {
        try {
            TimeUnit.MILLISECONDS.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


  
}


class CustomSubscriber implements Flow.Subscriber<Integer> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("onSubscribe");
        this.subscription = subscription;
        this.subscription.request(5);
    }

    @Override
    public void onNext(Integer item) {
        System.out.println("onNext " + item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError");
        
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }

}
 