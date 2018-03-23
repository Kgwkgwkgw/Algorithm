import java.util.Arrays;
import java.util.Scanner;

public class B11403 {
	public static int[][] adj;
	public static int[][] res;
	public static int N;
	public static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		adj = new int[N][N];
		res= new int[N][N];
		visited = new int[N];
		for(int i=0;i<N;i++) {
			String inputs[] = sc.nextLine().split(" ");
			for(int j=0;j<inputs.length;j++) {
				adj[i][j]= Integer.parseInt(inputs[j]);
			}
		}
		dfsAll();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(res[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static void dfsAll() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) {
					dfs(j);
					if(visited[j]==2) {
						res[i][j]=1;
					}
				}
				else if(dfs(i,j)) {
					res[i][j]=1;
				}
				Arrays.fill(visited, 0);
			}
		}
	}
	public static void dfs(int start) {
		if(visited[start]==2)
			return;
		visited[start]++;
		for(int i=0;i<N;i++) {
			if(adj[start][i]>0) {
				dfs(i);
			}
		}
		return;
	}
	public static boolean dfs(int start, int end) {
		if(start==end)
			return true;
		visited[start]++;
		for(int i=0;i<N;i++) {
			if(adj[start][i]>0&& visited[i]==0) {
				if(dfs(i, end)) {
					return true;
				}
			}
		}
		return false;
	}
}