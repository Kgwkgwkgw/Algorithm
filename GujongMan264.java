import java.util.Scanner;

public class GujongMan264 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		cache= new int[n+1][n+1];
		int ret=0;
		for(int i=1;i<=n;i++) {
			ret+= solve(n,i);
		}
		System.out.println(ret);
	}
	public static int[][] cache;
	public static int solve(int n, int first) {
		if(n==first) {
			cache[n][first]=1;
			return cache[n][first];
		}
		if(cache[n][first]!=0) {
			return cache[n][first];
		}
		int ret = 0;
		for(int i=1;i<=n-first;i++) {
			ret+= solve(n-first, i)*(first+i-1);
		}
		cache[n][first]=ret;
		return ret;
	}
}
