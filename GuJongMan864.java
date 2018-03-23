import java.util.ArrayList;
import java.util.Scanner;

public class GuJongMan864 {
	public static boolean[] visited;
	public static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int g = sc.nextInt();
			int h = sc.nextInt();
			visited= new boolean[g];
			adjList = new ArrayList[g];
			for(int i=0;i<g;i++) {
				adjList[i]= new ArrayList<>();
			}
			
			for(int i=0;i<h;i++) {
				int v1 = sc.nextInt();
				int v2= sc.nextInt();
				adjList[v1].add(v2);
				adjList[v2].add(v1);
			}
			
			dfsAll();
			System.out.println(counter);
		}
	}
	public static void dfsAll() {
		counter = 0;
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]) {
				if(dfs(i)==UNWATHCED) {
					counter++;
				}
			}
		}
	}
	public static int counter=0;
	public static int UNWATHCED=0;
	public static int INSTALLED=1;
	public static int NONEED=2;
	public static int dfs(int here) {
		visited[here]=true;
		int[] children= {0,0,0};
		
		for(int i=0;i<adjList[here].size();i++) {
			int there = adjList[here].get(i);
			if(!visited[there]) {
				children[dfs(there)]++;
			}
		}
		if(children[UNWATHCED]>0) {
			counter++;
			return INSTALLED;
		} else if(children[INSTALLED]>0) {
			return NONEED;
		}
		return UNWATHCED;
	}
}
