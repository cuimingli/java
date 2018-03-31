package com.wy.tests.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hello001 {
	public static void main(String args[]){
		Integer[]a =new Integer[]{1,2,3,4,5};
		List list= new ArrayList();
		list= Arrays.asList(a);
		System.out.print(list.size());
	}


}
