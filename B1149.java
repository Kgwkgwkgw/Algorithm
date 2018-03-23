import java.util.Arrays;
import java.util.Scanner;

public class B1149 {
	public static int[][] money;
	public static int RED= 0;
	public static int GREEN = 1;
	public static int BLUE =2;
	public static int n;
	public static int max;
//	public static boolean[] selected = new boolean[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		money= new int[n][3];
		cache= new int[n+1][3];
		for(int i=0;i<cache.length;i++) {
			Arrays.fill(cache[i], -1);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				money[i][j]= sc.nextInt();
				max= Math.max(max, money[i][j]);
			}
		}
		System.out.println(solve(0,0,-1));
	}
	public static int[][] cache;
	public static int solve(int index, int sum, int notColor) {
		if(index==n) {
			return sum;
		}
//		if(notColor!=-1) {
//			if(cache[index][notColor]!=-1) {
//				return cache[index][notColor];
//			}
//		}
		int ret =max*n+1;
		for(int i=0;i<3;i++) {
			if(i != notColor) {
				int result = solve(index+1, sum + money[index][i], i);
				ret= Math.min(ret, result);
				System.out.println("result : " + result);
//				System.out.println("money[i][index] : " + money[i][index]);
				System.out.println("i : "+i);
				System.out.println("notColor : "+notColor);
				System.out.println("index : "+ index);
				System.out.println("sum : "+ sum);
				System.out.println();
			}
		}
//		if(notColor!=-1) {
//			cache[index][notColor]=ret;
//		}
//		System.out.println("최종 : ret "+ret);
//		System.out.println("------");
		return ret;
	}
}
