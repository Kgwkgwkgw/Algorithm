import java.util.Arrays;

public class TrianglePath {
	public static int[][] triangle = {
//			{6},
//			{1,2},
//			{3,7,4},
//			{9,4,1,7},
//			{2,7,5,9,4}
			{1},
			{1,1},
			{1,1,1},
			{1,10,1,1},
			{1,1,1,1,1}
	};
	public static int[][] cache = new int[triangle.length][triangle.length];
	public static void main(String[] args) {
		System.out.println(solve(0,0));
		for(int i=0;i<cache.length;i++) {
			System.out.println(Arrays.toString(cache[i]));
		}
	}
	public static int solve(int y, int x) {
		if(y<triangle.length && x>=triangle[y].length) {
			return 0;
		}
		if(y== triangle.length-1) {
			return triangle[y][x];
		}
		int max = 0;
		max = Math.max(solve(y+1, x), solve(y+1,x+1))+triangle[y][x];
		cache[y][x]= max;
		return max;
	}
}
