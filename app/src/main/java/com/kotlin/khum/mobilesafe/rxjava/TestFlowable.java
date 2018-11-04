package com.kotlin.khum.mobilesafe.rxjava;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class TestFlowable {

    public static void main(String[] arg){

    }

    private static void test1() {
        Flowable.range(1,10)
                .onBackpressureBuffer()
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "String :"+integer;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }
}
