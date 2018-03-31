package com.wy.tests.util;

public class MyRunnable implements Runnable {

    public MyRunnable(){

    }

    public void run() {
        System.out.println("子线程ID:" + Thread.currentThread().getId());
    }
}
