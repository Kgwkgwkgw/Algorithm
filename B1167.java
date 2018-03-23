import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Queue;
import java.util.Scanner;

public class B1167 {
	public static class Edge {
		int anotherVertex;
		int value;
		public Edge(int anotherV, int value) {
			this.anotherVertex= anotherV;
			this.value= value;
		}
		@Override
		public String toString() {
			return "Edge [anotherVertex=" + anotherVertex + ", value=" + value + "]";
		}
		
	}
	public static boolean[] visited;
	public static ArrayList<Edge>[] adjList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V= Integer.parseInt(sc.nextLine().trim());
		adjList = new ArrayList[V+1];
		visited= new boolean[V+1];
		
		for(int i=1;i<adjList.length;i++) {
			adjList[i]= new ArrayList<>();
		}
		
		for(int i=0;i<V;i++) {
			String[] inputs = sc.nextLine().split(" ");
			int current = Integer.parseInt(inputs[0]);
			for(int j=1;j+1<inputs.length;j+=2) {
				adjList[current].add(new Edge(Integer.parseInt(inputs[j]), Integer.parseInt(inputs[j+1])));				
			}
		}
		
		
//		for(int i=1;i<adjList.length;i++) {
//			System.out.println("i : " +i + " "+adjList[i]);
//		}
		for(int i=1;i<=V;i++) {
			if(!visited[i]) {
				findRoot(i);
			}
		}
		Arrays.fill(visited, false);
		
		traverse(root);
		System.out.println(longest);
	}
	public static int traverse(int root) {
		visited[root]=true;
		
		ArrayList<Integer> valueList = new ArrayList<>();
		int ret =0;
		for(int i=0;i< adjList[root].size();i++) {
			if(!visited[adjList[root].get(i).anotherVertex]) {
				valueList.add(
						traverse(adjList[root].get(i).anotherVertex)
						+adjList[root].get(i).value
						);
			}
		}
//		System.out.println("root : " + root+ " valueList : "+ valueList);
		Collections.sort(valueList);
		if(valueList.size()==0)  {
//			System.out.println(root);
			return 0;
		}
		else if(valueList.size()>1) {
			longest= Math.max(longest, valueList.get(valueList.size()-1)+ valueList.get(valueList.size()-2));
		} else if(valueList.size()==1) {
			longest= Math.max(longest, valueList.get(valueList.size()-1));
		}
		return valueList.get(valueList.size()-1);
	}
	public static int longest=0;
	public static int root=-1;
	public static void findRoot(int start) {
		visited[start]=true;
		
		for(int i=0;i< adjList[start].size();i++) {
			if(!visited[adjList[start].get(i).anotherVertex]) {
				findRoot(adjList[start].get(i).anotherVertex);
			}
		}
		root=start;
	}
}
