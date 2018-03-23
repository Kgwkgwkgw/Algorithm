import java.util.Arrays;
import java.util.Scanner;

public class B10026 {
	public static char[][] board;
	public static char[][] board2;
	public static boolean[][] visited;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		board= new char[N][N];
		board2= new char[N][N];
		visited= new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			board[i]=sc.nextLine().toCharArray();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(board[i][j]=='G') {
					board2[i][j]='R';
				} else {
					board2[i][j]=board[i][j];
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(board2[i]));
//		}
		int count1 = dfsAll(board);
		visited= new boolean[N][N];
		int count2= dfsAll(board2);
		System.out.println(count1 + " " + count2);
	}
	public static int dfsAll(char[][] board) {
		int count =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i,j,board);
					count++;
				}
			}
		}
		return count;
	} 
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {1,-1,0,0};
	public static void dfs(int y, int x, char[][] board) {
		visited[y][x]=true;
		
		for(int i=0;i<4;i++) {
			int nextY = y+dy[i];
			int nextX = x+dx[i];

			if(nextY>=0&& nextY<N && nextX>=0 && nextX <N && 
					!visited[nextY][nextX] && board[y][x] == board[nextY][nextX]) {
				dfs(nextY, nextX, board);
			}
		}
	}
}
