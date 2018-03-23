import java.util.Scanner;

public class B1103 {
	public static int n;
	public static int m;
	public static int[][] board;
	public static int[][] cache= new int[50][50];
	public static boolean[][] visited;
	public static int HOLE = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//세로 크기 
		//가로 크기 
		
		String[] input = sc.nextLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		board= new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String[] inputs = sc.nextLine().split("");
			for(int j =0;j<m;j++) {
				try {
					board[i][j] = Integer.parseInt(inputs[j]);
				} catch (NumberFormatException e) {
					// TODO: handle exception
					board[i][j]=HOLE;
				}
			}
		}
		System.out.println(solve(0,0));
		
	}
	public static int[] dx = {0 , 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0 };
	public static boolean isCycle = false;
	public static int solve(int y, int x) {
		if(y<0 || x<0|| x>=m || y>=n ) {
			return 0;
		}
		if(board[y][x]==0) {
			return 0;
		}
		if(isCycle) {
			return -1;
		}
		if(cache[y][x]!=0) {
			return cache[y][x];
		}
		visited[y][x]=true;
		int ret=0;
		for(int i=0;i<4;i++) {
			int nextY = y+dy[i]*board[y][x];
			int nextX = x+dx[i]*board[y][x];
			
			if(nextY>=0 && nextX>=0 && nextX<m && nextY<n && visited[nextY][nextX]) {
				isCycle=true;
				break;
			}
			ret = Math.max(ret, solve(nextY, nextX)+1);
		}
		visited[y][x]=false;
		if(isCycle) {
			return -1;
		} else {
			cache[y][x]=ret;
			return ret;
		}
	}
}
 