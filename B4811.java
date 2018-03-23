import java.util.Scanner;

public class B4811 {
	public static long[][] cache =new long[31][31];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		while( (n=sc.nextInt())!=0) {
			System.out.println(solve(n,n));
		}
	}
	public static long solve(int w, int n) {
		if(w<0) {
			return 0;
		}
		if(w==0 && n==0) {
			return 1;
		}
		if(cache[w][n]!=0) {
			return cache[w][n];
		}
		long ret =0;
		if(w<n) {
			ret += solve(w, n-1);
		}
		ret += solve(w-1, n);
		cache[w][n]=ret;
		return ret;
	}
}
