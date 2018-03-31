package com.wy.tests.util;

public class Paixu04 {
    public static void main(String args[]){
        int[] numbers = {7,55,3,1000,2};
        int size = numbers.length;

        for(int i = 0;i<size -1;i++){
            for(int j = 0;j<size-1-i;j++){
                if(numbers[j]>numbers[j+1]){
                     int temp = numbers[j];
                     numbers[j] = numbers[j+1];
                     numbers[j+1] = temp;
                }
            }
        }
        for(int i = 0;i<size;i++){
            System.out.println(numbers[i]);
        }

    }

}
