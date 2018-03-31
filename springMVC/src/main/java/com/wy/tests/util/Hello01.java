package com.wy.tests.util;

public class Hello01 {
    public static  void main(String args[]){
        //选择排序
        int[] numbers = {7,55,3,1000,2};
        Paixu03.quickSort(numbers,0,numbers.length-1);
        for(int i = 0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }
}
