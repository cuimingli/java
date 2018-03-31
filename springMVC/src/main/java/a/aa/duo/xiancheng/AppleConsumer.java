package a.aa.duo.xiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppleConsumer {
    private Store<Apple> mStore;

    private ExecutorService mWorkThread = Executors.newFixedThreadPool(1);

    public AppleConsumer bindStore(Store<Apple> store){
        this.mStore = store;
        return this;
    }

    public void consume(){
        mWorkThread.submit(new Runnable() {
            public void run() {
                for(; ;){
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    Apple apple = mStore.take();
                    System.out.println("apple:" + apple.getName() + "消费了");
                }
            }
        });


    }
}
