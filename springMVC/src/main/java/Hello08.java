import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hello08 {
      public static void main(String args[]){
    	  List<Integer> list = new ArrayList<Integer>();
    	  list.add(3);
    	  list.add(1000);
    	  list.add(9);
    	  list.add(1);
    	  list.add(2);
    	  Collections.sort(list,new Comparator<Integer>(){
    		  public int compare(Integer o1,Integer o2){
    			  return o2 -o1;
    		  }
    	  });
    	  for(int a : list){
    		  System.out.println(a);
    	  }
      }
}
