package com.wy.tests.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ThreadUtils {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(16);
	
	public ExecutorService getExecutorService(){
		return EXECUTOR_SERVICE;
	}
}
