import java.util.Arrays;

public class GuJongMan254 {
	public static int[][] triangle={
			{9},
			{5,7},
			{1,3,2},
			{3,5,5,6}
	};
	public static void main(String[] args) {
		cache= new int[triangle.length][triangle.length];
		cache2= new int[triangle.length][triangle.length];
		for(int i=0;i<triangle.length;i++) {
			Arrays.fill(cache[i], -1);
			Arrays.fill(cache2[i], -1);
		}
		System.out.println(solve(0,0));
		for(int i=0;i<triangle.length;i++) {
			System.out.println(Arrays.toString(cache[i]));
		}
		System.out.println(sovle2(0,0));
		for(int i=0;i<triangle.length;i++) {
			System.out.println(Arrays.toString(cache2[i]));
		}
	}
	public static int[][] cache2;
	public static int sovle2(int y, int x) {
		if(y>=triangle.length || x>y ) {
			return 0;
		}
		if(y==triangle.length-1) {
			cache2[y][x]= 1;
			return cache2[y][x];
		}
		if(cache2[y][x]!=-1) {
			return cache2[y][x];
		}
		if(cache[y+1][x] > cache[y+1][x+1]) {
			cache2[y][x] = sovle2(y+1,x);
			
			return cache2[y][x];
		} else if(cache[y+1][x] < cache[y+1][x+1]) {
			cache2[y][x] = sovle2(y+1,x+1);
			
			return cache2[y][x];
		}
		cache2[y][x]= sovle2(y+1,x) + sovle2(y+1, x+1);
		return cache2[y][x];
	}
	public static int[][] cache;
	public static int solve(int y, int x) {
		if(y>=triangle.length || x>y ) {
			return 0;
		}
		if(y==triangle.length-1) {
			cache[y][x]= triangle[y][x];
			return cache[y][x];
		}
		if(cache[y][x]!=-1) {
			return cache[y][x];
		}
		int ret =0;
		ret= Math.max(ret, solve(y+1, x));
		ret= Math.max(ret, solve(y+1, x+1));
		ret+= triangle[y][x]; 
		cache[y][x]=ret;
		return ret;
	}
}
