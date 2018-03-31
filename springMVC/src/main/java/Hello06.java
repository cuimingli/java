import java.util.Arrays;

public class Hello06 {
	public static void main(String args[]){
		String[] arr = {"a","d","z","x","aaa","dd"};
		Arrays.sort(arr);
		for(int i = 0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
