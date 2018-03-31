package com.wy.tests.util;

import com.wy.test.service.UserService;

public class ProxyTest {
    public static void main(String args[]){
        // 实例化目标对象
        IUserDao iUserDao = new UserDao();
        MyInvocationHandle invocationHandle = new MyInvocationHandle(iUserDao);
        //根据目标对象生产代理对象
        IUserDao proxy = (IUserDao) invocationHandle.getProxy();
        proxy.save();


    }
}
