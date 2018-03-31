package com.wy.tests.util;

public class Paixu {
    public static void main(String args[]){
        //插入排序
        int[] arr = {7,55,3,1000,2};
       int temp = 0;
       int size = arr.length;
       for(int i = 1;i<size;i++){
           if(arr[i] < arr[i-1]){
               temp = arr[i];
               while(i>0&& temp<arr[i-1]){
                   arr[i] = arr[i-1];
                   i--;
               }
               arr[i] = temp;
           }
       }
       for(int k = 0;k<size;k++){
           System.out.println(arr[k]);
       }
    }
}
