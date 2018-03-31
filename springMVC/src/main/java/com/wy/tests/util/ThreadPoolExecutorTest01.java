package com.wy.tests.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest01 {
       public static void main(String args[]){
    	   //创建一个定长线程池
    	   ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    	   for(int i=0;i<10;i++){
    		   final int index = i;
    		   fixedThreadPool.execute(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					try{
						System.out.println(index);
						Thread.sleep(2000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					
				}});
    	   }
    	   
       }
}
