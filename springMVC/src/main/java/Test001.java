import com.wy.tests.util.MyCallable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class Test001 {
    public static void main(String args[])throws ExecutionException,InterruptedException{
      /*  System.out.println("----程序开始运行------");
        Date date1 = new Date();
        int takeSize = 5;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(takeSize);
        //创佳多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for(int i = 0;i<takeSize;i++){
            Callable c = new MyCallable(i + "");
            //执行任务并获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        //关闭线程池
        pool.shutdown();
        //获取所有并发任务的运行结果
        for(Future f : list){
            System.out.println(">>>"+f.get().toString());
        }
       Date date2 = new Date();
        System.out.println("----程序结束运行----,程序运行时间【"+
                (date2.getTime() - date1.getTime())+"毫秒】");*/
         System.out.println("----程序开始运行------");
         Date date1 = new Date();
         int takeSize = 5;
         //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(takeSize);
        //创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for(int i = 0;i<takeSize;i++){
            Callable c = new MyCallable(i + "");
            //执行任务并获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        //关闭线程池
        pool.shutdown();
        //获取所有并发任务的运行结果
        for(Future f : list){
            System.out.println(">>>" + f.get().toString());
        }
        Date date2 = new Date();
       System.out.println("----程序开始运行----，程序运行时间【"+
               (date2.getTime() -date1.getTime())+"毫秒】");
    }
}
