package com.example;

import java.util.stream.IntStream;

public final class App1 {
    public static void main(String[] args) throws InterruptedException{
        //Using Stream, no reactive
        IntStream.of(1,2,3).forEach(System.out::println);
    }
}
    