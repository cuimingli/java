package a.aa;

//此类是（本质上:共同访问的）共享数据区域
public class SyncStack {
    private String[] str = new String[10];

    private int index;

    //供生产者调用
    public synchronized void push(String sst){
        if(index == sst.length()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        str[index] = sst;
        index ++;

    }

    //供消费者调用
    public synchronized String pop(){
        if(index == 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
       this.notify();
        index --;
        String product = str[index];
        return product;
    }

    public String[] pro(){
        return str;
    }

}
