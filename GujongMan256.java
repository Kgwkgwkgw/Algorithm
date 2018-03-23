import java.util.Arrays;
import java.util.Scanner;

public class GujongMan256 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		cache = new double[n+1][m+1];
		for(int i=0;i<cache.length;i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(solve(n,m));
//		System.out.println(solve(n,m)/Math.pow(2,m));
//		

	}
	public static double[][] cache;
	public static double solve(int n, int m) {
		if(n<=0) {
			return 1;
		}
		if(m==0) {
			return 0;
		}
		if(cache[n][m]!=-1) {
			return cache[n][m];
		}
		double ret =0;
		ret+= solve(n-1, m-1)*0.5;
		ret+= solve(n-2, m-1)*0.5;
		
		cache[n][m]= ret;
		
		return cache[n][m];
	}
}