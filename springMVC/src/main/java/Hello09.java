import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class Hello09 {
	public static void main(String args[]){
		Map<String,Object> params = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		params.put("1", "aa");
		params.put("4", "c");
		params.put("5", "d");
		params.put("3", "b");
		params.put("2", "bb");
		List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String,Object>>(params.entrySet());
		Collections.sort(infoIds, new Comparator<Map.Entry<String,Object>>(){
			public int compare(Map.Entry<String, Object> o1,Map.Entry<String, Object> o2){
				return(o1.getKey().compareTo(o2.getKey()));
			}
		});
		int size = infoIds.size();
		for(int i = 0;i<size;i++){
		
				sb.append(infoIds.get(i).getKey() + "=" + infoIds.get(i).getValue() + "&");
		
			
		}
		System.out.println(sb);
	}
}
