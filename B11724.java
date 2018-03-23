import java.util.LinkedList;
import java.util.Scanner;

public class B11724 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertexCount = sc.nextInt();
		int edgeCount = sc.nextInt();
		boolean visited[] = new boolean[vertexCount+1];
		LinkedList<Integer>[] adjList =new LinkedList[vertexCount+1];
		for(int i=1;i<adjList.length;i++) {
			adjList[i]= new LinkedList<>();
		}
		for(int i=0;i<edgeCount;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			adjList[to].add(from);
		}
		dfsAll(adjList, visited);
	}
	public static void dfsAll(LinkedList<Integer>[] adjList, boolean[] visited) {
		int ret =0;
		for(int i=1;i<visited.length;i++) {
			if(!visited[i]) {
				dfs(i, adjList, visited);
				ret++;
			}
		}
		System.out.println(ret);
		return;
	}
	public static void dfs(int here, LinkedList<Integer>[] adjList, boolean[] visited) {
		for(int i=0;i<adjList[here].size();i++) {
			if(!visited[adjList[here].get(i)]) {
				visited[adjList[here].get(i)]=true;
				dfs(adjList[here].get(i), adjList, visited);
			}
		}
	}
}
