public class Paixu04 {

    //选择排序
    public static void selectSort(int array[]){
        int t = 0;
        for(int i = 0;i<array.length -1;i++){
            for(int j = i + 1;j<array.length;j++){
                if(array[i] >array[j]){
                    t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
