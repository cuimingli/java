
public class Paxu01 {
     public static void main(String args[]){
    	 //冒泡排序

    	 /*int[] arr = {2,30,99,88,98,1000};

    	 int temp ;
    	 int size = arr.length;
    	 for(int i = 0;i<size - 1;i++){
    	 	for(int j = 0;j<size -i -1;j++){
    	 		if(arr[j+1]< arr[j]){
    	 			temp = arr[j];
    	 			arr[j] = arr[j+1];
    	 			arr[j+1] = temp;
    	 			}
			}
		 }

		 for(int i = 0;i<size;i++){
    	 	System.out.println(arr[i]);
		 }*/
    	int[] arr = {2,30,99,88,98,1000};
    	int temp ;
    	int size = arr.length;
    	for(int i = 0;i<size -1;i++){
    		for(int j = 0;j<size -i-1;j++){
    			if(arr[j+1] <arr[j]){
    				temp = arr[j];
    				arr[j] = arr[j+1];
    				arr[j+1] = temp;

				}
			}
		}
		for(int i = 0;i<size;i++){
    		System.out.println(arr[i]);
		}
     }
}
