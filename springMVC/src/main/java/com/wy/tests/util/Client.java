package com.wy.tests.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Client {

    public static void main(String args[]){
         MyClassLoader myCLoader = new MyClassLoader("MyClassLoader");
           myCLoader.setPath("C:\\Users\\Administrator\\");
           Class<?> clazz;
           try{
               clazz = myCLoader.loadClass("Test");
               Field[] fields = clazz.getFields();
               Method[] methods = clazz.getMethods();

               System.out.println("该类的类加载器为：" + clazz.getClassLoader());
               System.out.println("该类的类加载器的父类为:" + clazz.getClassLoader().getParent());
               System.out.println("该类的名称为：" + clazz.getName());
           }catch (ClassNotFoundException e){
               e.printStackTrace();
           }



    }
}
