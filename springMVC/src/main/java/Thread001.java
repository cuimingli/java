public class Thread001 implements Runnable {
    public void run(){
        synchronized(this){
            for(int i = 0;i<5;i++){
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
    public static void main(String args[])throws InterruptedException{
        Thread001 t1 = new Thread001();
        Thread ta = new Thread(t1,"A");
        Thread tb = new Thread(t1,"B");
        ta.start();
        Thread.sleep(2000);
        tb.start();
    }
}
