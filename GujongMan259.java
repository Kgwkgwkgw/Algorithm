import java.util.Scanner;

public class GujongMan259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		cache= new int[100000];
		cache2= new int[100000];
		System.out.println(solve(2));
		System.out.println(solve(4));
		System.out.println(solve(92));
//		System.out.println(sovle2(5)-solve(5));
	}
	public static int sovle2(int n) {
		if(n<=1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		if(cache2[n]!=0) {
			return cache2[n];
		}
		cache2[n]=(sovle2(n-1)+ sovle2(n-2))%1_000_000_007;
		return cache2[n];
	}
	public static int[] cache2;
	public static int solve(int n) {
		if(n%2==1) {
			return (sovle2(n) - sovle2(n/2))%1_000_000_007;
		} else {
			return (sovle2(n) -((sovle2(n/2-1) + sovle2(n/2))))%1_000_000_007;
		}
	}
}
