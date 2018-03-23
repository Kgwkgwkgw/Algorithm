import java.util.Arrays;
import java.util.Scanner;

public class B2468 {
	public static int[][] board;
	public static boolean[][] visited;
	public static int MIN=0;
	public static int MAX=101; 
	public static int n; 
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			n = Integer.parseInt(sc.nextLine());
			board= new int[n][n];
			visited= new boolean[n][n];
			int max = MIN;
			int min = MAX;
			for(int i=0;i<n;i++) {
				String[] inputs = sc.nextLine().split(" ");
				for(int j=0;j<n;j++) {
					int input =Integer.parseInt(inputs[j]);
					board[i][j] = input;
					max = Math.max(max, input);
					min = Math.min(min, input);
				}
			}
			System.out.println(dfsAll(min, max));
	}
	public static int dfsAll(int min, int max) {
		int result=1;
		for(int rainDepth=min;rainDepth<=max;rainDepth++) {
			
			int ret=0;
			for(int i=0;i<visited.length;i++) {
				Arrays.fill(visited[i], false);
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(board[i][j] >rainDepth && !visited[i][j]) {
						dfsMorethanDepth(rainDepth, i, j);
						ret++;
					}
				}
			}
			result=Math.max(ret, result);
			
		}
		return result;
	}
	public static void dfsMorethanDepth(int depth, int y, int x) {
		if(y<0 || y> board.length-1 || x<0 || x>board.length-1) {
			return;
		}
		if(visited[y][x]) {
			return;
		}
		if(depth >= board[y][x] ) {
			return;
		}
		visited[y][x]=true;
		dfsMorethanDepth(depth, y+1, x);
		dfsMorethanDepth(depth, y-1, x);
		dfsMorethanDepth(depth, y, x+1);
		dfsMorethanDepth(depth, y, x-1);
		
	}
}
