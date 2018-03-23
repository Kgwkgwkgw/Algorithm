import java.math.BigDecimal;
import java.util.Arrays;

public class Tiling2 {
	public static int[][] tile;
	public static int n = 5;
	public static int[] cache= new int[100];
	public static int[] synkCache = new int[100];
	static {
		tile = new int[2][n];
		Arrays.fill(cache,-1);
		Arrays.fill(synkCache,-1);
	}
	public static void main(String[] args) {
		
		System.out.println(countAsynk(92));
		System.out.println("calculating?");
		System.out.println(Arrays.toString(cache));
		System.out.println(Arrays.toString(synkCache));
	}
	public static int countAsynk(int width) {
		return solve(width)-countSynk(width);
	}
	public static int solve(int width) {
		if(width ==1) {
			return 1;
		}
		if(width==2) {
			return 2;
		}
		if(cache[width]!=-1) {
			return cache[width];
		}
		cache[width]= (solve(width-1) + solve(width-2));
		return cache[width];
	}
	public static int countSynk(int width) {
		if(width==1) {
			return 1;
		} 
		if(width==2) {
			return 2;
		}
		if(width ==3) {
			return 1;
		}
		if(synkCache[width]!=-1) {
			return synkCache[width];
		}
		if(width%2==1) {
			synkCache[width] = countSynk((width-1)/2);
		}
		else {
			synkCache[width] = (countSynk((width-2)/2)+ countSynk((width)/2));
		}
		return synkCache[width];
		
//		return countSynk(width-1)+ countSynk(width-2);
	}
}
