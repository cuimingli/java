package com.wy.tests.util;

public class MyThread extends Thread {

    private String name;

    public MyThread(String name){
        this.name = name;
    }

    public void run(){
        System.out.println("name:"+name+ "子线程ID:" + Thread.currentThread().getId());
    }

}
