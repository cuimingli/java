package a.aa.duo.xiancheng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 生产者
 */
public class AppleProducer {
    private  Store<Apple> mStore;

    private static ExecutorService mWorkthread = Executors.newFixedThreadPool(5);

    private String name;

    public AppleProducer setName(String name){
            this.name = name;
            return this;
    }

    public AppleProducer bindStore(Store<Apple> store){
        this.mStore = store;
        return this;
    }

    public void production(){
        mWorkthread.execute(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                Apple apple = new Apple("第" +name+"个产品");
                mStore.push(apple);
            }
        });
    }

}
