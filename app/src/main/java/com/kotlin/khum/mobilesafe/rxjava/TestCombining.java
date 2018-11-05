package com.kotlin.khum.mobilesafe.rxjava;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class TestCombining {

    static String[] names = {"xiaoming","xiaohong", "xiaowang", "xiaoli", "xiaofang"};

    public static void main(String[] arg){
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        Observable<Integer> o1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        System.out.println("A:"+aLong);
                        return aLong.intValue()*2;
                    }
                }).take(5);
        Observable<Integer> o2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        System.out.println("B:"+aLong);
                        return aLong.intValue() * 3;
                    }
                }).take(5);

        o1.join(o2,
                new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        System.out.println("i am left:"+integer);
                        return Observable.just(integer);
                    }
                }, new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer tRight) throws Exception {
                        System.out.println("i am right:"+tRight);
                        return Observable.just(tRight);
                    }
                }, new BiFunction<Integer, Integer, String>() {
                    @Override
                    public String  apply(Integer integer, Integer tRight) throws Exception {
                        System.out.println("through fun");
                        return "left is "+integer+ ", right is "+tRight;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void test2() {
        Observable.fromArray(names)
                .reduce(new BiFunction<String, String, String>() {
                    @Override
                    public String apply(String s, String s2) throws Exception {
                        return s+" "+s2;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }

    private static void test1() {
        Observable<Integer> o1 = Observable.range(20, 4);
        Observable<String> o2 = Observable.fromArray(names);
        Observable.zip(o1, o2, new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return "name is "+s+",age is "+integer;
            }
        }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println(s);
                    }
                });
    }


}
