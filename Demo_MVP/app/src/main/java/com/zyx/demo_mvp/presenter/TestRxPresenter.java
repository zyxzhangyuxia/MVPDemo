package com.zyx.demo_mvp.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.zyx.demo_mvp.presenter.presenter_interface.ITestRx;


import rx.Observable;
import rx.Subscriber;

/**
 * Created by vectoria on 2017/7/14.
 */

public class TestRxPresenter extends BasePresenter{

    ITestRx iTestRx;

    public TestRxPresenter(ITestRx iTestRx){
        this.iTestRx = iTestRx;
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(iTestRx.getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return iTestRx.getContext();
    }

    @Override
    public void startActivity(Class<?> cls) {

    }

    public void test(){
        //创建观察者------>决定事件被触发之后有怎样的行为
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(o.toString());
                Log.d("lcs","0 = "+o.toString());
            }
        };
        //创建被观察者--->决定什么时候触发事件以及怎样触发事件，
        //第一种方式创建----create
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                 //定义事件触发的规则
                subscriber.onNext("Hello World!");
                subscriber.onNext("This Day is 2017-07-14");
                subscriber.onCompleted();
            }
        });
        //第二种方式创建---just
        Observable<String> observable1 = Observable.just("This is test just Method","This is test just Method","This is test just Method");
        //第三种方式创建---from
        String []words = new String[]{"1","2","3"};
        Observable<String> observable2 = Observable.from(words);

        //事件订阅
//        observable.subscribe(subscriber);
//        observable1.subscribe(subscriber);
        observable2.subscribe(subscriber);
    }

}
