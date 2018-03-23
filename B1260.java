import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1260 {
	public static ArrayList<Integer> dfsList = new ArrayList();
	public static ArrayList<Integer> bfsList = new ArrayList();
	public static void main(String[] args) {
//		그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[][] adj = new int[n+1][n+1];
		boolean[] visited= new boolean[n+1];
		boolean[] discovered= new boolean[n+1];
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		for(int i=0;i<m;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adj[from][to]++;
			adj[to][from]++;
		}
		dfs(n, start, visited, adj);
		bfs(start, adj, discovered);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<dfsList.size();i++) {
			sb.append(dfsList.get(i)+ " ");
		}
		sb.append("\n");
		for(int i=0;i<bfsList.size();i++) {
			sb.append(bfsList.get(i)+ " ");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int n, int start, boolean[] visited, int[][] adj) {
		dfsList.add(start);
		visited[start] =true;
		for(int i=1;i<=n;i++) {
			 if(adj[start][i]>0 && !visited[i]) {
				 dfs(n, i, visited, adj);
			 }
		}
	}
	 public static void bfs(int start, int[][] adj, boolean[] discovered) {
		 Queue<Integer> queue = new LinkedList<>();
		 queue.add(start);
		 discovered[start]=true;
		 while(!queue.isEmpty()) {
			 int node = queue.poll();
			 bfsList.add(node);
			for(int i=1;i<adj.length;i++) {
				if(adj[node][i]>0&&!discovered[i]) {
					discovered[i]=true;
					queue.add(i);
				}
			}
		 }
	 }
	
}
