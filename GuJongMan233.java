import java.util.Arrays;

public class GuJongMan233 {
	public static int[] arr1 = {2};
	public static int[] arr2 = {3};
	public static void main(String[] args) {
		for(int i=0;i<cache.length;i++) {
			Arrays.fill(cache[i], min-1);
		}
		System.out.println(solve(-1,-1)-2);
		for(int i=0;i<cache.length;i++) {
			System.out.println(Arrays.toString(cache[i]));
		}
	}
	public static int[][] cache = new int [101][101];
	public static int min = 0;
	
	public static int solve(int index1, int index2) {
		if(cache[index1+1][index2+1] !=-1) {
			return cache[index1+1][index2+1];
		}
		int value1 = index1== -1 ? -1 : arr1[index1];
		int value2 = index2== -1 ? -1 : arr2[index2];
		int moreBig = Math.max(value1, value2);
		
		int ret=2;
		for(int i=index1+1;i<arr1.length;i++) {
			if(moreBig< arr1[i]) {
				ret = Math.max(ret, solve(i, index2)+1);
			}
		}
		for(int i=index2+1;i<arr2.length;i++) {
			if(moreBig< arr2[i]) {
				ret = Math.max(ret, solve(index1, i)+1);
			}
		}
		cache[index1+1][index2+1] =ret;
		return cache[index1+1][index2+1];
	}
}
