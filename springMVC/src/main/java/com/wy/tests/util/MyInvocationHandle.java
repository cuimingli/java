package com.wy.tests.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandle implements InvocationHandler {

    //目标对象
    private Object target;

    public MyInvocationHandle(Object target){
        super();
        this.target = target;
    }

    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{

        System.out.println("-----before-------");
        //执行目标对象的方法
        Object result = method.invoke(target,args);
        //在目标对象的方法执行之后简单的打印
        System.out.println("-----after------");
         return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),this);

    }
}
