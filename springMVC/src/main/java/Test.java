import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


public class Test {
    public static void main(String args[])throws ExecutionException,
            InterruptedException {
      /*  System.out.println("---程序开始运行----");
        Date date1 = new Date();
        int taskSize = 5;
        ExecutorService pool = Executors.newScheduledThreadPool(taskSize);
        //穿件有多个返回值的任务
        List<Future> list = new ArrayList<Future>();
        for(int i = 0;i<taskSize;i++){
            Callable c = new MyCallable(i + "");
            //执行任务并获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");*/
        System.out.println("----程序运行开始----");
        Date date1 = new Date();
        int taskSize = 5;
        ExecutorService pool = Executors.newScheduledThreadPool(taskSize);
        //返回多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for(int i = 0;i<taskSize;i++){
            Callable c = new MyCallable(i + "");
            //执行任务并获取Future对象
            Future f = pool.submit(c);
            list.add(f);
        }
        //获取所有并发任务的运行结果
        for(Future f : list){
            //从Future对象上获取任务的返回值，并输出到控制台上。
            System.out.println(">>>" + f.get().toString());
        }
        Date date2 = new Date();
        System.out.println("----程序已开始运行---，程序运行时间【"
               + (date2.getTime() - date1.getTime()) + "毫秒】");
    }
}

