package com.wy.tests.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest02 {
   
    	 public static void main(String[] args) {  
    		  ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
    		  scheduledThreadPool.schedule(new Runnable() {  
    		   public void run() {  
    		    System.out.println("delay 3 seconds");  
    		   }  
    		  }, 3, TimeUnit.SECONDS);  
    	 }
}
