import java.util.Scanner;

public class GujongMan269 {
	
//	public static int[][] adj = 
//		{
//				{0,1,1,1,0},
//				{1,0,0,0,1},
//				{1,0,0,0,0},
//				{1,0,0,0,0},
//				{0,1,0,0,0}
//		};
	public static int[][] adj = 
		{
				{0,1,1,1,0,0,0,0},
				{1,0,0,1,0,0,0,0},
				{1,0,0,1,0,0,0,0},
				{1,1,1,0,1,1,0,0},
				{0,0,0,1,0,0,1,1},
				{0,0,0,1,0,0,0,1},
				{0,0,0,0,1,0,0,0},
				{0,0,0,0,1,1,0,0}
		};
	public static int[] adjCount = {
			3,2,2,5,3,2,1,2
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		int d = 2;
		int prizon = 0;
//		int q = 3;
		int q =4;
		int[] qBillage = {0,2,4};
//		System.out.println(solve(0,2,0));
//		System.out.println(solve(0,2,2));
//		System.out.println(solve(0,2,4));
		
//		System.out.println(solve(3,2,3));
//		System.out.println(solve(3,2,1));
//		System.out.println(solve(3,2,2));
//		System.out.println(solve(3,2,6));
		
		System.out.println(solve(3,2,3));
		System.out.println(solve(1,2,3));
		System.out.println(solve(2,2,3));
		System.out.println(solve(6,2,3));
	}
	public static double[][] cache = new double[8+1][3+1];
	public static double solve(int current, int d, int start) {
		if(d==0) {
//			System.out.println("current : "+current+ " dest : "+ dest);
			if(current == start) 
				return 1.0;
			else 
				return 0.0;
		}
		if(cache[current][d]!=0.0) {
//			System.out.println("here");
//			System.out.println("current : "+ current);
//			System.out.println(" d : "+d);
//			System.out.println("cache[current][d] : "+ cache[current][d]);
			return cache[current][d];
		}
		double ret =0.0;
		for(int i=0;i< adj.length;i++) {
			if(adj[current][i]>0) {
				ret+= solve(i, d-1, start)/(double)adjCount[i];
			}
		}
		cache[current][d]=ret;
		return ret;
	}
}
