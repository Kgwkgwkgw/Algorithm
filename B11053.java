import java.util.Arrays;
import java.util.Scanner;

public class B11053 {
	public static int[] arr;
	public static int[] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr= new int[n];
		cache= new int[n+1];
		Arrays.fill(cache, -1);
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		System.out.println(longest(-1)-1);
	}
	public static int longest(int idx) {
		if(cache[idx+1]!=-1) {
			return cache[idx+1];
		}
		int ret =1;
		
		for(int i = idx+1;i<arr.length;i++) {
			if(idx==-1 || arr[idx]<arr[i]) {
				ret = Math.max(ret, longest(i)+1);
			}
		}
		cache[idx+1]= ret;
		return ret;
	}
}
