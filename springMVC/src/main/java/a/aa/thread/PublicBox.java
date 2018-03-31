package a.aa.thread;

public class PublicBox {
    private volatile int apple = 0;

    public synchronized void increace(){
        while (apple == 5){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
       apple ++;
        System.out.println("生产苹果成功！");
        notify();
    }

    public synchronized void  decreace(){
        while ( apple ==0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        apple --;
        System.out.println("消费苹果成功");
        notify();
    }

    public static void main(String args[]){
        PublicBox box = new PublicBox();
        Consumer1 con = new Consumer1(box);
        Producer1 pro = new Producer1(box);
        Thread t1 = new Thread(con);
        Thread t2 = new Thread(pro);
        t1.start();
        t2.start();
        String a = "a b c d e";
        a.split(" " );


}

}
