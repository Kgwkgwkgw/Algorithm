import java.util.Arrays;

public class Quantization {
	public static int n = 10;
	public static int s =3;
	public static int[] arr = {3,3,3,1,2,3,2,2,2,1};
//	public static int[] arr = {1,1,1,1,1,1,1,1,1,1};
	// 한계인듯??...
	public static int max = 99999;
	static {
		Arrays.sort(arr);
	}
	public static void main(String[] args) {
		System.out.println(solve(0,s));
	}
	public static int solve(int begin, int parts) {
		if(begin==arr.length) {
			return 0;
		}
		if(parts==0) {
			return max;
		}
		
		int res = max;
		for(int i=1;begin+i<=arr.length;i++) {
			res = Math.min(res, solve(begin+i, parts-1)+getMin(begin, i));
		}
		return res;
	}
	public static int getMin(int index, int size) {
		int min= arr[index];
		int max= arr[index+size-1];
		int ret=Quantization.max;
		int sum=Quantization.max;
		for(int quantization=min; quantization<=max; quantization++) {
			sum=0;
			for(int i=0;i<size;i++) {
				sum += Math.pow(arr[index+i]- quantization,2);
			}
			ret= Math.min(ret, sum);
		}
		return ret;
	}
}
