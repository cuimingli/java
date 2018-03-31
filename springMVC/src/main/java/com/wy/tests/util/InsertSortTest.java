package com.wy.tests.util;

import java.util.Arrays;
import java.util.List;

public class InsertSortTest{

   public static void InsertSort(int[] a){
     int i,j,insertNote;//要插入的数据
       for(i = 1;i< a.length;i++){//从数组中的第二个元素开始循环将数组中的元素插入
         insertNote = a[i];// 设置数组中的第二个元素为第一次循环要插入的数据
           j = i-1;
           while(j >=0 && insertNote<a[j]){
              a[j+1] = a[j];
               j--;
           }
           a[j+1] = insertNote;
       }

   }
    public static void main(String[] args) {
        int a[] = { 38,65,97,76,13,27,49 };
        InsertSort(a);
        List list = Arrays.asList(a) ;

        System.out.println(Arrays.toString(a));

    }
}
