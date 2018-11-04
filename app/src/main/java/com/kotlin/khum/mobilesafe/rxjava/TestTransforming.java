package com.kotlin.khum.mobilesafe.rxjava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

/**
 * transforming test
 */
public class TestTransforming {

    static Integer[] data = {1,2,3,4,5,6};

    public static void main(String[] arg){
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
    }

    private static void test5() {
        Observable.fromArray(data)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer+integer2;
                    }
                }).subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.print(integer);
                    }
                });
    }

    private static void test4() {
        Observable.fromArray(data)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer+integer2;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    private static void test3() {
        Observable.fromArray(data)
                .groupBy(integer -> {
                    if (integer>3){
                        return 1;
                    }else{
                        return 2;
                    }
                }).subscribe(objectIntegerGroupedObservable -> {
                     int key = objectIntegerGroupedObservable.getKey();
                        switch (key){
                            case 1:
                                objectIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                                    @Override
                                    public void accept(Integer integer) throws Exception {
                                        System.out.println("我是大于3的："+integer);
                                    }
                                });
                                break;
                            case 2:
                                objectIntegerGroupedObservable.subscribe(new Consumer<Integer>() {
                                    @Override
                                    public void accept(Integer integer) throws Exception {
                                        System.out.println("我是不大于3的："+integer);
                                    }
                                });
                                break;
                        }
                });
    }


    private static void test2(){
        Observable.fromArray(data)
                .flatMap(integer -> Observable.just(integer*10))
                .subscribe(integer -> System.out.println(integer));
    }

    private static void test1(){

        Observable.fromArray(data)
                .buffer(1, TimeUnit.SECONDS,1)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(integers);
                    }
                });

    }
}
