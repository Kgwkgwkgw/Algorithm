import java.util.Scanner;

public class B1697 {
	public static int N;
	public static int K;
	public static int MAX = 100_001;
//	public static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		//수빈이의 위치
		N = Integer.parseInt(input[0]);
		//동생의 위치
		K = Integer.parseInt(input[1]);
		if(N==0) {
			System.out.println(solve(N+1, K,0)+1);
		} else {
			System.out.println(solve(N, K,0));
		}
	}
	public static int solve(int n, int k, int count) {
//		System.out.println("n" + n);
//		System.out.println("k : "+ k );
//		System.out.println("count : "+ count);
//		System.out.println("--------");
		
		if(k==n) {
			return count;
		}
		int ret = MAX;
		if(k%2==1) {
			ret = Math.min(ret, solve(n,k+1, count+1));
			ret = Math.min(ret, solve(n,k-1, count+1));
			while(k>n) {
				k--;
				count++;
			}
			while(k<n) {
				k++;
				count++;
			}
			ret = Math.min(ret, count);
			return ret;
		}
		if( k/n > 0) {
			ret = solve(n, k/2, count+1);
		} 
		
		while(k>n) {
			k--;
			count++;
		}
		while(k<n) {
			k++;
			count++;
		}
		ret = Math.min(ret, count);
		return ret;
	}
}
