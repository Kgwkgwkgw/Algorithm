import java.util.ArrayList;
import java.util.Scanner;

public class B1707 {
	public static ArrayList<Integer>[] adjList;
	public static boolean[] visited;
	public static boolean isBipartiteGraph;
	public static char BLUE = 'b';
	public static char RED = 'r';
	public static char[] nodeColor;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		while(k-->0) {
			int vertex= sc.nextInt();
			adjList= new ArrayList[vertex+1];
			isBipartiteGraph=true;
			nodeColor= new char[vertex+1];
			visited= new boolean[vertex+1];
			
			for(int i=1;i<adjList.length;i++) {
				adjList[i]= new ArrayList<Integer>();
			}
			
			int edge= sc.nextInt();
			
			for(int i=0;i<edge;i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				adjList[from].add(to);
				adjList[to].add(from);
			}
			dfsAll();
			
			if(isBipartiteGraph) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}	
	}
	public static void dfsAll() {
		// 여기때문에 틀렸었따..
		for(int i=1;i<visited.length;i++) {
			if(!visited[i]) {
				dfs(i,BLUE);
				// 여기에break문을 했었었따...
				// 여기에 break문이 없어야함. 왜냐면 모든 그래프가 연결되어있다는 보장이 없다.
				// 떨어져있을떄는 색깔이 어케돼든 상관없다.
			}
		}
	}
	public static char toggleColor(char ch) {
		if(ch==BLUE) {
			return RED;
		}
		return BLUE;
	}
	public static void dfs(int startVertex, char color) {
		visited[startVertex]=true;
		nodeColor[startVertex]=color;
		
		for(int i=0;i<adjList[startVertex].size();i++) {
			
			int there = adjList[startVertex].get(i);
			
			if(!visited[there]) {
				dfs(there, toggleColor(color));
			} else {
				if(nodeColor[there]== color) {
					isBipartiteGraph=false;
					break;
				}
			}
		}
		
	}
}
