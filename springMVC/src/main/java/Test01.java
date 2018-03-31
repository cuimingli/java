import com.wy.tests.util.MySendMailThread;

public class Test01 {
    public static void main(String args[]){
    	  Thread myThread1 = new MySendMailThread();
    	  myThread1.start();
    	
    }
}
