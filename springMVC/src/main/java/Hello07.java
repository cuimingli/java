import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hello07 {
   public static void main(String args[]){
	   List<String> list = new ArrayList<String>();
	   list.add("aa");
       list.add("c");
       list.add("d");
       list.add("b");
       list.add("bb");
       Collections.sort(list);
       for(String a : list){
    	   System.out.println(a);
       }
   }
}
