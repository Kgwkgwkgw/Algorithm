import java.util.Arrays;

public class JumpGame {
	public static int[][] board = {
			{2,5,1,6,1,4,1},
			{6,1,1,2,2,9,3},
			{7,2,3,2,1,3,1},
			{1,1,3,1,7,1,2},
			{4,1,2,3,4,1,2},
			{3,3,1,2,3,4,1},
			{1,5,2,9,4,7,0}
	};
	public static boolean[][] cache= new boolean[board.length][board.length];
	public static void main(String[] args) {
		System.out.println(solve(0,0));
		for(int i=0;i<cache.length;i++) {
			System.out.println(Arrays.toString(cache[i]));
		}
	}
	public static boolean solve(int startY, int startX) {
		if(startX < 0 || startX >= board.length || startY < 0 || startY >= board.length) {
			return false;
		}
		if(startX==board.length-1 && startY == board.length-1) {
			System.out.println("X :"+ startX + "Y :"+ startY);
			return true;
		}
		if(solve(startY+board[startY][startX], startX)) {
			cache[startY][startX]=true;
			System.out.println("X :"+ startX + "Y :"+ startY);
			return true;
		}
		if(solve(startY, startX + board[startY][startX] )) {
			cache[startY][startX]=true;
			System.out.println("X :"+ startX + "Y :"+ startY);
			return true;
		}
		return false;
	}
}
