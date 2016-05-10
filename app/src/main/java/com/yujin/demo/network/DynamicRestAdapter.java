package com.yujin.demo.network;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscriber;

/**
 * @author: yujin on 16/5/10.
 */
public class DynamicRestAdapter implements InvocationHandler {

    public <T> T create(Class<T> service) {
        Object proxyInstance = Proxy.newProxyInstance(service.getClassLoader(), new Class[]{}, this);
        return (T)proxyInstance;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(POST.class) || method.isAnnotationPresent(GET.class)) {//是否有指定地址
            Class<?> clazz = null;
            Type returnType = method.getGenericReturnType()/*.getGenericSuperclass()*/;//获取返回类型
            if (returnType instanceof ParameterizedType) {
                clazz = (Class<?>) ((ParameterizedType) returnType).getActualTypeArguments()[0];
//                Type[] actualTypeArguments = ((ParameterizedType) returnType).getActualTypeArguments();//
//                clazz = (Class) actualTypeArguments[0];
            } else {
                throw new IllegalArgumentException("请使用RXJava");
            }
            Annotation[] annotations = method.getAnnotations();//获取地址参数
            String value = null;
            for (Annotation annotation : annotations) {
                if (annotation instanceof POST) {
                    value = ((POST) annotation).value();
                    break;
                } else if (annotation instanceof GET) {
                    value = ((GET) annotation).value();
                    break;
                } else {
                    continue;
                }

            }
//            if (value.startsWith("/")) {
//                throw new IllegalArgumentException("注解地址不能以/开头");
//            }
//            value = value.replace("/", "_");//根据地址参数生成文件名
//            String json = getJson(ASSERTPATH + value + EXTENSION);
//            final Object ob = GsonTools.getBean(json, clazz);
////            if (ob == null) {
////                ob = createObjectFromClass(clazz);
////            }
            final Observable.OnSubscribe<Object> subscribe = new Observable.OnSubscribe<Object>() {

                @Override
                public void call(Subscriber<? super Object> subscriber) {
//                    subscriber.onNext(ob);
                }
            };
            return Observable.create(subscribe);
        } else {
            new IllegalArgumentException("先指定annotation");
        }
        return null;
    }
}
