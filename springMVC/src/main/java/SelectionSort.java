public class SelectionSort {
    public static void sort(int[] data){
        int minVal;
        int minIndex;
        for(int i = 0;i<data.length -1;i++){
            minVal = data[i];
            minIndex = i;
            for(int j = i+1;j<data.length;j++){
                if(data[j] < minVal){
                    minVal = data[j];
                    minIndex = j;
                }
            }
            if(minVal != data[i] && minIndex != i){
                data[minIndex] = data[i];
                data[i] = minVal;
            }
        }
        for(int i = 0;i<data.length;i++){
            System.out.println(data[i]);
        }

    }
}
