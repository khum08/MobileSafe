package com.kotlin.khum.mobilesafe.rxjava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建型
 */
public class TestCreating {

    public static void main(String[] arg){
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
        test9();
    }

    private static void test9() {
        Observable.interval(0,1,TimeUnit.SECONDS)
                .buffer(1,3,TimeUnit.SECONDS)
                .subscribe(new Consumer<List<Long>>() {
                    @Override
                    public void accept(List<Long> longs) throws Exception {
                        System.out.print(longs);
                    }
                });
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void test8() {
        Observable.range(1,100)
                .buffer(10)
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(List<Integer> integers) throws Exception {
                        System.out.println(integers);
                    }
                });
    }

    private static void test7(){
        TestCreating.countDown(6)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Observable<Integer> countDown(int count){
        return Observable.interval(0,1,TimeUnit.SECONDS)
                .map(aLong -> count - aLong.intValue())
                .take(count+1);
    }

    //实现倒计时
    private static void test6() {
        Observable.interval(0,1, TimeUnit.SECONDS)
                .map(new Function<Long, Object>() {
                    @Override
                    public Object apply(Long aLong) throws Exception {
                        return 5 - aLong.intValue();
                    }
                }).take(6)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("subscribe");
                    }

                    @Override
                    public void onNext(Object o) {
                        System.out.println(o.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test5(){
        Observable.just(1,2,3)
                .repeat(5)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }

    private static void test4(){
        Observable.never().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("subscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o.toString());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });
    }

    private static void test3(){
        Observable.empty().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("subscribe");
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o.toString());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        });
    }

    private static void test2(){
        Integer[] emits= {1,2,3};
        Observable.fromArray(emits)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer a) throws Exception {
                        System.out.println(a.intValue());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    private static void test1(){
        Observable.range(1, 50)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
