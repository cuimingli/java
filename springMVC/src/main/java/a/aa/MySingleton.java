package a.aa;

public class MySingleton {
    volatile private static MySingleton instance = null;

    private MySingleton(){}

  public static MySingleton getInstance(){
    try{


        if(instance != null){

        }else {
            Thread.sleep(3000);
            synchronized (MySingleton.class){
                if(instance == null){
            instance = new MySingleton();
                }
        }
        }
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    return instance;
  }
}
