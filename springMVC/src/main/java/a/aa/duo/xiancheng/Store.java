package a.aa.duo.xiancheng;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Store<T> {
    private BlockingQueue<T> mQueue = new ArrayBlockingQueue<T>(10,true);
      public void push(T t){
          try{
              mQueue.put(t);
          }catch (InterruptedException e){
              e.printStackTrace();
              Thread.currentThread().interrupt();
          }
          System.out.println("product生产了...");
      }


      public T take(){
          T t = null;
          try{
              t = mQueue.take();
          }catch (InterruptedException e){
              e.printStackTrace();
              Thread.currentThread().interrupt();
          }
          System.out.println("product取出了...");
          return t;
      }

       public void  release(){
          if(mQueue.isEmpty()){
              return;
          }
          mQueue.clear();
       }
}
