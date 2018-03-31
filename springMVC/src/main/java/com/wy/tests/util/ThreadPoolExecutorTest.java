package com.wy.tests.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
	public static void main(String args[]){
		//可缓存的线程池
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for(int i = 0;i<10;i++){
			final int index = i;
			try{
				Thread.sleep(index * 1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					System.out.println(index);
					}
				});
		}
	}

}
