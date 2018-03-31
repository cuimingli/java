package com.wy.tests.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("dd");
        list.add("a");
        list.add("cc");
        list.add("b");
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
       for(String a : list){
           System.out.println(a);
       }
    }
}