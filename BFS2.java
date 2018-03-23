import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS2 {
	public static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		adjList = new ArrayList[9];
		
		for(int i=0;i<adjList.length;i++) {
			adjList[i] = new ArrayList<>();
		}
		
		adjList[0].add(1);
		adjList[0].add(2);
		adjList[0].add(3);
		adjList[0].add(4);
		
		adjList[1].add(0);
		adjList[1].add(2);
		adjList[1].add(5);
		
		adjList[2].add(0);
		adjList[2].add(1);
		adjList[2].add(7);
		
		adjList[3].add(0);
		adjList[3].add(6);
		
		adjList[4].add(0);
		
		adjList[5].add(1);
		adjList[5].add(6);
		adjList[5].add(7);
		
		adjList[6].add(3);
		adjList[6].add(5);
		
		adjList[7].add(5);
		adjList[7].add(2);
		adjList[7].add(8);
		
		adjList[8].add(7);
		int[] parent = bfs(0);
		System.out.println(Arrays.toString(parent));
		System.out.println(getPath(8,parent));
	}
	public static ArrayList<Integer> getPath(int to, int[] parent) {
		 ArrayList<Integer> path= new ArrayList<>();
		 path.add(to);
		 while(parent[to]!=to) {
			 to = parent[to];
			 path.add(to);
		 }
		 return path;
	}
	public static int[] bfs(int start) {
		boolean[] discovored= new boolean[9];
		int[] parent = new int[9];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		parent[start]=start;
		discovored[start]=true;
	
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			
			for(int i=0;i<adjList[poll].size();i++) {
				int there = adjList[poll].get(i);
				if(!discovored[there]) {
					discovored[there]=true;
					parent[there]= poll;
					queue.add(there);
				}
			}
		}
		return parent;
	}
}
