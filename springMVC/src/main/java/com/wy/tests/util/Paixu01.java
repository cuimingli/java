package com.wy.tests.util;

public class Paixu01 {
    public static void main(String args[]){
        //插入排序
        int[] numbers = {7,55,3,1000,2};
        int target;
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        int size = numbers.length, temp, j;
        for(int i=1; i<size; i++) {
            temp = numbers[i];
            for(j = i; j > 0 && temp < numbers[j-1]; j--)
                numbers[j] = numbers[j-1];
                numbers[j] = temp;
        }
        for(int k = 0;k<size ;k++){
            System.out.println(numbers[k]);
        }
    }
}
