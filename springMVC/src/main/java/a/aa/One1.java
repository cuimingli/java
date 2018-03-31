package a.aa;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class One1 {

    public static void main( String[] args )
    {
        System.out.println(Thread.currentThread().getName());
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 1, TimeUnit.DAYS, queue);

        BlockingQueue queue2 = new LinkedBlockingQueue();
        final ThreadPoolExecutor executor2;
        executor2 = new ThreadPoolExecutor(6, 6, 1, TimeUnit.DAYS, queue2);

        for (int i=0;i<5;i++){
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    for (int i=0;i<5;i++){
                        executor2.execute(new Runnable() {
                            public void run() {
                                System.out.println(Thread.currentThread().getName());
                            }
                        });
                    }
                }
            });
        }
    }

}
