import java.util.Scanner;
// ㅈㅈ
public class B2718 {
	public static int cache[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			cache= new int[5000];
			System.out.println(solve(n));
		}
	}
	public static int solve(int n) {
		if(n==1) {
			return 1;
		}
		int ret =two(n);
		return ret*ret + ret-1;
	}
	public static int two(int n) {
		if(n<=1) {
			return 1;
		}
		cache[n]=two(n-1)+ two(n-2);
		return cache[n];
	}
}
