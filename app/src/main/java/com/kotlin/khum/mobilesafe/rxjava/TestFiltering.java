package com.kotlin.khum.mobilesafe.rxjava;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class TestFiltering {
    static Integer[] data = {1,2,3,4,5,6,7,8,9,10};
    public static void main(String[] arg){
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
    }

    private static void test6() {
        Observable.range(1,100)
                .repeat(2)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer%5==1;
                    }
                })
                .skip(15)
                .take(15)
                .distinct()
                .takeLast(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    private static void test5() {
        Observable.range(1,100)
                .skipLast(7)
                .buffer(5)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(integers);
                    }
                });
    }

    private static void test4() {
        Observable.range(1,100)
                .skip(2)
                .buffer(5)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(integers);
                    }
                });
    }


    private static void test3() {
        Observable.range(1,10000)
                .last(0)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    private static void test2() {
        Observable.range(1,10)
                .repeat(3)
                .first(5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });

    }

    private static void test1() {
        Observable.range(1,10)
                .repeat(3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer %2 ==1;
                    }
                }).buffer(3)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(integers);
                    }
                });
    }


}
