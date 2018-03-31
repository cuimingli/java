package com.wy.tests.util;

public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy (IUserDao target){
        this.target = target;
    }

    public void save() {
        System.out.println("事物开始");
        target.save(); //执行目标对象的方法
        System.out.println("事物关闭");

    }
}
