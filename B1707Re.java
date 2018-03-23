import java.util.ArrayList;
import java.util.Scanner;

public class B1707Re {
	public static boolean[] visited;
	public static int[] colored;
	public static int RED= 1;
	public static int BLUE=-1;
	public static ArrayList<Integer>[] adj;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		for(int i=0;i<k;i++) {
			isBi=true;
			int v = scanner.nextInt();
			int e = scanner.nextInt();
			visited= new boolean[v+1];
			colored= new int[v+1];
			adj= new ArrayList[v+1];
			for(int j=1;j<adj.length;j++) {
				adj[j]= new ArrayList<>();
			}
			for(int j=0;j<e;j++) {
//				String[] inputs= scanner.nextLine().split(" ");
				int from = scanner.nextInt();
				int to = scanner.nextInt();

				adj[from].add(to);
				adj[to].add(from);
			}
			dfsAll();
			if(isBi) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	public static void dfsAll() {
		for(int i=1;i<visited.length;i++) {
			if(!visited[i]) {
				dfs(i,BLUE);
			}
		}
	}
	public static boolean isBi=true;
	public static void dfs(int nodeNumber, int color) {
		colored[nodeNumber]=color;
		visited[nodeNumber]=true;
//		System.out.println("colored : "+ Arrays.toString(colored));
//		System.out.println("visited : " +Arrays.toString(visited));
		for(int i=0;i<adj[nodeNumber].size();i++) {
			int next = adj[nodeNumber].get(i);
			if(!visited[next]) {
				dfs(next, color*-1);
			} else {
				if(colored[next]==colored[nodeNumber]) {
					isBi=false;
					return;
				}
			}
		}
	}
}
