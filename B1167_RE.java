import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1167_RE {
	public static int v;
	public static class Edge {
		int to;
		int value;
		public Edge (int to, int value) {	
			this.to=to;
			this.value=value;
		}
	}
	public static ArrayList<Edge>[] adjList;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		v= sc.nextInt();
		adjList= new ArrayList[v];
		visited= new boolean[v];
		for(int i=0;i<adjList.length;i++) {
			adjList[i]= new ArrayList<>();
		}
		for(int i=0;i<v;i++) {
			int vertex= sc.nextInt()-1;
//			System.out.println("vertex : "+vertex);
			while(true) {
				int connectedVertex= sc.nextInt()-1;
				if(connectedVertex==-2) {
					break;
				}
				int value = sc.nextInt();
				adjList[vertex].add(new Edge(connectedVertex, value));
				
			}
		}
		solve(0);
		System.out.println(longest);
	}
	public static int longest = 0;
	public static boolean[] visited;
	// i노드에서 가장 큰 높이 반환 
	public static int solve(int here) {
		visited[here]=true;
		
		ArrayList<Integer> heights = new ArrayList<>();
		for(int i=0;i<adjList[here].size();i++) {
			if(!visited[adjList[here].get(i).to]) {
				heights.add(adjList[here].get(i).value+ solve(adjList[here].get(i).to));
			}
		}
		Collections.sort(heights);
//		System.out.println("height : "+ heights );
		if(heights.size()==0) {
			return 0;
		} else if(heights.size()>1) {
			longest= Math.max(longest, heights.get(heights.size()-1)+ heights.get(heights.size()-2));
		} else if (heights.size()==1) {
			longest= Math.max(longest, heights.get(heights.size()-1));
		}
		return heights.get(heights.size()-1);
	}
}
 