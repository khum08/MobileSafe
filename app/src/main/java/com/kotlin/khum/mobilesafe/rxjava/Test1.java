package com.kotlin.khum.mobilesafe.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class Test1 {

    public static void main(String[] arg) {
//        hello("xiaowang", "xiaoli", "xiaohong");
//        String[] test = {"xiaowang", "xiaoli", "xiaohong"};
//        hello2(test);
    }

    private static void hello(String... names) {
        Observable.fromArray(names).subscribe(new MyObserver<String>());
    }

    private static void hello2(String[] names){
        Observable.just(names).subscribe(new MyObserver<String[]>());
    }

    private static Observable<String> customObservable(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

            }
        });
    }
    static class MyObserver<T> implements Observer<T> {

        @Override
        public void onSubscribe(Disposable d) {
            System.out.println(d.toString());
        }

        @Override
        public void onNext(T t) {
            System.out.println(t);
        }

        @Override
        public void onError(Throwable e) {
            System.out.println(e.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("complete");
        }
    }
}