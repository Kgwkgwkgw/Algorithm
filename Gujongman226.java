import java.util.Arrays;
import java.util.Scanner;

public class Gujongman226 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[][] triangle= {
				{6},
				{1,2},
				{3,7,4},
				{9,4,1,7},
				{2,7,5,9,4}
		};
		cache= new int[triangle.length][triangle.length];
		System.out.println(solve(triangle,0,0));
		for(int i=0;i<triangle.length;i++) {
			System.out.println(Arrays.toString(cache[i]));
		}
	}
	public static int[][] cache;
	public static int solve(int[][] triangle, int y , int x) {
		if(y>=triangle.length || x > y ) {
			return 0;
		}
		if(y==triangle.length-1) {
			return triangle[y][x];
		}
		if(cache[y][x]!=0) {
			return cache[y][x]+triangle[y][x];
		}
		cache[y][x]= solve(triangle, y+1, x);
		cache[y][x]= Math.max(cache[y][x], solve(triangle, y+1, x+1));
		
		return cache[y][x]+triangle[y][x];
	}
}
