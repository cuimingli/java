public class InsertionSort {
    //插入排序
   /* public static void sort(int data[]){
        for(int i = 1;i<data.length;i++){
            for(int j = i;j>0;j--){
                if(data[j] <data[j-1]){
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }
        }
        for(int i = 0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }*/

   public static void sort(int data[]){
       for(int i = 1;i<data.length;i++){
           for(int j = i;j>0;j--){
               if(data[j] <data[j-1]){
                   int temp = data[j];
                   data[j] = data[j-1];
                   data[j-1] = temp;
               }
           }
       }
       for(int i = 0;i<data.length;i++){
           System.out.println(data[i]);
       }
   }
}
