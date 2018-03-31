package com.wy.tests.util;

public class Paixu03 {

    public static void quickSort(int[] numbers, int start, int end) {
        if(start < end){
            int base = numbers[start];
            int temp;
            int i = start,j = end;
            do{
                while ((numbers[i] < base) && (i <end))
                    i++;
                while ((numbers[j] >base) && (j >start))
                        j--;
                if(i <= j){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            }while (i <= j);
            if(start < j){
                quickSort(numbers,start,j);
            }
            if(end >i){
                quickSort(numbers,i,end);
            }
        }
        //快速排序
      /*  if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }*/

    }

}