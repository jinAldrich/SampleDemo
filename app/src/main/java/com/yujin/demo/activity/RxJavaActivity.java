package com.yujin.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yujin.demo.R;
import com.yujin.demo.bean.Student;
import com.yujin.demo.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 演示RxJava的使用
 * <p>
 * RxJava正在Android开发者中变的越来越流行。唯一的问题就是上手不容易，尤其是大部分人之前都是使用命令式编程语言。
 * 但是一旦你弄明白了，你就会发现RxJava真是太棒了。
 * <p>
 * RxJava最核心的两个东西是Observables（被观察者，事件源）和Subscribers（观察者）。
 * Observables发出一系列事件，Subscribers处理这些事件。这里的事件可以是任何你感兴趣的东西（触摸事件，web接口调用返回的数据。。。）
 *
 *
 * RxJava 有四个基本概念：
 *      Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
 *      Observable 和 Observer 通过 subscribe() 方法实现订阅关系，从而 Observable 可以在需要的时候发出事件来通知 Observer。
 *
 *
 * 在不指定线程的情况下， RxJava 遵循的是线程不变的原则，即：在哪个线程调用 subscribe()，就在哪个线程生产事件；
 * 在哪个线程生产事件，就在哪个线程消费事件。如果需要切换线程，就需要用到 Scheduler （调度器）。
 *
 */
public class RxJavaActivity extends AppCompatActivity {

    @Bind(R.id.bt_1)
    Button bt1;
    @Bind(R.id.bt_2)
    Button bt2;
    @Bind(R.id.bt_3)
    Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        ButterKnife.bind(this);
        //被观察者
        Observable<Student> observable = Observable.create(new Observable.OnSubscribe<Student>() {
            @Override
            public void call(Subscriber<? super Student> subscriber) {
                subscriber.onNext(new Student());
                subscriber.onCompleted();
                subscriber.onError(new Exception("Customer Exception"));
            }
        });
        //被观察者另一种创建方式,不使用create,而使用just创建
        Observable<Student> observable1 = Observable.just(new Student());
        //观察者
        Subscriber<Student> subscriber = new Subscriber<Student>() {
            @Override
            public void onCompleted() {
                LogUtils.LOGD("---onCompleted---");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.LOGD("---onError---" + e);
            }

            @Override
            public void onNext(Student s) {
                LogUtils.LOGD("---onNext---" + s);
            }
        };
        observable1.subscribe(subscriber);//将观察者和被观察者联起来
        /**
         * 多线程
         *
         * 在开发过程中，为了避免阻塞UI线程，我们可能需要将某些工作放到指定线程执行。
         * 在 RxJava中可以
         *      通过subscribeOn()来指定Observer的运行线程, SubscribeOn 指定了Observable的调度器.
         *      通过observeOn()  来指定Subscriber的运行线程, 指定observer将会在哪个Scheduler观察这个Observable.
         *
         * 简单来讲:
         * 使用RxJava，你可以使用subscribeOn()指定被观察者代码运行的线程，使用observerOn()指定订阅者运行的线程
         *
         */
        observable.subscribeOn(AndroidSchedulers.mainThread());
        observable.observeOn(Schedulers.io());

        Action1<Student> onNextAction = new Action1<Student>() {
            @Override
            public void call(Student s) {

            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        };
        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {

            }
        };

        /**
         * subscribe方法有一个重载版本，接受三个Action1类型的参数，分别对应OnNext，OnComplete， OnError函数。
         */
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

        /**
         * 创建观察者(两种方式)
         *      Observer 接口之外，RxJava 还内置了一个实现了 Observer 的抽象类：Subscriber。
         *      Subscriber 对 Observer 接口进行了一些扩展，但他们的基本使用方式是完全一样的.
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        Subscriber<String> stringSubscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        };
        /**
         * unsubscribe() 这个方法很重要，因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，
         * 这个引用如果不能及时被释放，将有内存泄露的风险。
         * 所以最好保持一个原则：要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）调用 unsubscribe() 来解除引用关系，
         * 以避免内存泄露的发生。
         */
        if (stringSubscriber.isUnsubscribed()) {
            stringSubscriber.unsubscribe();
        }
        /**
         * 传多个参数创建Observable对象
         */
        Observable<String> observable2 = Observable.just("hello", "aiki", "niao");
        /**
         * 传一个数组创建Observable对象
         */
        String[] strings = {"hello", "aiki", "niao"};
        Observable<String> observable3 = Observable.from(strings);
    }

    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                //演示中间对象变换过程
                Subscriber<Student> subscriber = new Subscriber<Student>() {
                    @Override
                    public void onCompleted() {
                        LogUtils.LOGD("---onCompleted---");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.LOGD("---onError---");
                    }

                    @Override
                    public void onNext(Student student) {
                        LogUtils.LOGD("---onNext---" + student);

                    }
                };

                Observable<Student> observable = Observable.create(new Observable.OnSubscribe<Student>() {
                    @Override
                    public void call(Subscriber<? super Student> subscriber) {
                        subscriber.onNext(new Student());
                        subscriber.onCompleted();
                        subscriber.onError(new Exception("抛异常"));
                    }
                }).map(new Func1<Student, Student>() {
                    @Override
                    public Student call(Student student) {
                        student.setName("李四");
                        student.setAge(23);
                        student.setProfile("李四是一名警察");
                        return student;
                    }
                });
                observable.subscribe(subscriber);
                break;
            case R.id.bt_2:
                break;
            case R.id.bt_3:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
