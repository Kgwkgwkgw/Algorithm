import java.util.Arrays;

public class GuJongMan231 {
	public static void main(String[] args) {
		int[] arr= {10,3,19,2,4,5,6};
		cache= new int [arr.length];
		Arrays.fill(cache, -1);
		int ret=0;
		for(int i=0;i<arr.length;i++) {
			ret= Math.max(ret, solve(arr,i));
		}
		System.out.println(ret);
		System.out.println(Arrays.toString(cache));
	}
	public static int[] cache;
	public static int solve(int[] arr, int i) {
//		if(i>=arr.length) {
//			return 0;
//		}
		if(i==arr.length-1) {
			return 1;
		}
		if(cache[i]!=-1) {
			return cache[i];
		}
		int ret=0;
		for(int index=i+1;index<arr.length;index++) {
			if(arr[i]<arr[index])
				ret= Math.max(ret, solve(arr,index));
		}
		cache[i]= ret+1;
		return cache[i];
	}
}
