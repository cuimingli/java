public class VolatileExample extends Thread {
    //设置类静态变量，各现场访问这共享同一变量
    private static  boolean flag = false;

    public void run(){
        while(!flag){

        };
        System.out.println("停止了");
    }

    public static void main(String args[]) throws InterruptedException{
        new VolatileExample().start();
        //sleep的目的是等地线程启动完毕，也就是就入run的无线循环
        Thread.sleep(100);
        flag = true;
    }
}
