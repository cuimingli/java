package a.aa.thread;

public class Consumer1 implements Runnable {
    private PublicBox box;

  public Consumer1(PublicBox box){
      this.box = box;
  }

  public void run(){
      for(int i = 0;i<10;i++){
          try{
              System.out.println("Con：i" + i);
              Thread.sleep(3000);
          }catch (InterruptedException e){
              e.printStackTrace();
          }
          box.decreace();
      }
  }

}
