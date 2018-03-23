import java.util.Arrays;
import java.util.Scanner;

public class B1012 {
	public static int[][] diff = { 
			{ 0, 1},
			{ 0, -1},
			{ 1, 0},
			{-1, 0}
	};
	public static int counter;
	public static void main(String[] args) {
		//유기농 배추
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int z=0;z<t;z++) {
			counter=0;
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] farm = new int[n][m];
			boolean[][] visited= new boolean[n][m];
			int k = sc.nextInt();
			
			for(int i=0;i<k;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				farm[y][x]=1;
			}
			dfsAll(n,m,visited, farm);
			System.out.println(counter);
		}
		
		
	}
	public static void dfsAll(int n, int m, boolean[][] visited,int[][] farm) {
		for(int i=0;i<n;i++) {
			for(int j=0; j<m;j++) {
				if(!visited[i][j]&& farm[i][j]>0) {
					dfs(i,j, visited, farm);
					counter++;
				}
			}
		}
	}
	public static int dfs(int y, int x, boolean[][] visited, int[][] farm) {
		visited[y][x]=true;
		int ret=1;
		for(int i=0;i<diff.length;i++) {
			int nextY= y + diff[i][0];
			int nextX= x+ diff[i][1];
			if(nextY>=0 && nextY< visited.length && 
					nextX>=0 && nextX<visited[y].length && 
					!visited[nextY][nextX] && farm[nextY][nextX]>0) {
				ret+=dfs(nextY, nextX, visited, farm);
			}
		}
		return ret;
	}
}
