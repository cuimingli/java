package a.aa.thread;

public class Producer1 implements Runnable {

    private PublicBox box;

    public Producer1(PublicBox box){
        this.box = box;
    }

    public void run(){
        for(int i = 0;i<10;i++){
            try{
                System.out.println("pro i:" + i);
                Thread.sleep(30);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            box.increace();
        }

    }
}
