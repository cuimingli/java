
public class Hello2 {
    public static void main(String args[]) throws InterruptedException{
    	Object a = new Object();
    	Object b = new Object();
    	Object c = new Object();
    	MyThreadPrinter2 pa = new MyThreadPrinter2("A",c,a);
    	MyThreadPrinter2 pb = new MyThreadPrinter2("B",a,b);
    	MyThreadPrinter2 pc = new MyThreadPrinter2("C",b,c);
    	 new Thread(pa).start();  
         Thread.sleep(1000);  //确保按顺序A、B、C执行  
         new Thread(pb).start();  
         Thread.sleep(1000);    
         new Thread(pc).start();     
         Thread.sleep(1000);   
    	
    }
}
