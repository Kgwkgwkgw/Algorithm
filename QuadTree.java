import java.util.Arrays;

public class QuadTree {
	public static char[][] decompressed =new char[16][16];
	public static void main(String[] args) {
		String input = "xxwwwbxwxwbbbwwxxxwwbbbwwwwbb";
		System.out.println(solve(input));
		
//		for(int i=0;i<decompressed.length;i++) {
//			System.out.println(Arrays.toString(decompressed[i]));
//		}
		
	}
	public static String solve(String input) {
		if(input.charAt(0)=='b'|| input.charAt(0)=='w') {
			return input.substring(0,1);
		}
		
		int st_Q = getCunckLength(input.substring(1));
		
		String leftUpper = solve(input.substring(1,1+st_Q));
		System.out.println(leftUpper);
		
		int nd_Q = getCunckLength(input.substring(1+st_Q));
		String rightUpper = solve(input.substring(1+st_Q,1+st_Q+nd_Q));
		System.out.println(rightUpper);
		
		int rd_Q = getCunckLength(input.substring(1+st_Q+nd_Q));
		String leftLower = solve(input.substring(1+st_Q+nd_Q,1+st_Q+nd_Q+rd_Q));
		System.out.println(leftLower);
		
		int th_Q = getCunckLength(input.substring(1+st_Q+nd_Q+rd_Q));
		String rightLower = solve(input.substring(1+st_Q+nd_Q+rd_Q,1+st_Q+nd_Q+rd_Q+th_Q));
		System.out.println(rightLower);
		return "x"+ leftLower + rightLower + leftUpper + rightUpper;
	}
	//decompress
//	public static void solve(String input, int y, int x, int size) {
//		if(input.charAt(0)=='b'|| input.charAt(0)=='w') {
//			for(int dy=0; dy<size; dy++) {
//				for(int dx=0; dx<size; dx++) {
//					decompressed[y+dy][x+dx] = input.charAt(0);
//				}
//			}
//			return;
//		}
//		size/=2;
//		int st_Q = getCunckLength(input.substring(1));
//		System.out.println(st_Q);
//		int nd_Q = getCunckLength(input.substring(1+st_Q));
//		System.out.println(nd_Q);
//		int rd_Q = getCunckLength(input.substring(1+st_Q+nd_Q));
//		System.out.println(rd_Q);
//		int th_Q = getCunckLength(input.substring(1+st_Q+nd_Q+rd_Q));
//		System.out.println(th_Q);
//		solve(input.substring(1), y,x, size);
//		solve(input.substring(1+ st_Q), y,x+size, size);
//		solve(input.substring(1 +st_Q + nd_Q), y+size,x, size);
//		solve(input.substring(1+st_Q + nd_Q + rd_Q), y+size,x+size, size);
//	}
	public static int getCunckLength(String input) {
		if(input.charAt(0)=='w'|| input.charAt(0)=='b') {
			return 1;
		} else {
			int st_Q;
			int nd_Q;
			int rd_Q;
			int th_Q;
			st_Q = getCunckLength(input.substring(1));
			nd_Q = getCunckLength(input.substring(1+st_Q));
			rd_Q = getCunckLength(input.substring(1+st_Q+nd_Q));
			th_Q = getCunckLength(input.substring(1+st_Q+nd_Q+rd_Q));
			return st_Q+nd_Q+rd_Q+th_Q+1;
		}
	}
}
