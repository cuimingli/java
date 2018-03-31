package com.wy.test.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {
    public static void main(String args[]){
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"ab");
        map.put(4,"ab");
        map.put(4,"ab");
        System.out.println(map.size());
        for(Integer integer : map.keySet()){
            String str = map.get(integer);
            System.out.println(integer + "" +  str);
        }
       //第二种
        /*Iterator<Map.Entry<Integer,String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            System.out.println("key = " +entry.getKey()+ "and value=" +entry.getValue());
        }*/
       //第三种
      /*  for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("key = " +entry.getKey()+ "and value=" + entry.getValue());
        }*/

        //第四种
        for(String v : map.values()){
            System.out.println("value = " + v);
        }
    }
}