import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String args[]){
    	Date date  = new Date();
    	System.out.print(date.getTime());
    	System.out.println(date);
    	/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	System.out.println(simpleDateFormat.format(date));
    	
    }
    
}
