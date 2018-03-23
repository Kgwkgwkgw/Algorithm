import java.util.ArrayList;
import java.util.Arrays;

public class Bridge {
	public static ArrayList<Integer>[] adjList;
	public static int[] discovered;
	public static int vertextCounter=0;
	public static void main(String[] args) {
		adjList= new ArrayList[8];
		discovered= new int[8];
		Arrays.fill(discovered, -1);
		for(int i=0;i<adjList.length;i++) {
			adjList[i]= new ArrayList<>();
		}
		adjList[0].add(1);
		
		adjList[1].add(0);
		adjList[1].add(2);
		adjList[1].add(3);
		
		adjList[2].add(3);
		adjList[2].add(1);
		adjList[2].add(5);
		
		adjList[3].add(1);
		adjList[3].add(2);
		adjList[3].add(4);
		adjList[3].add(5);
		
		adjList[4].add(3);
		
		adjList[5].add(3);
		adjList[5].add(2);
		adjList[5].add(6);
		adjList[5].add(7);
		
		adjList[6].add(5);
		
		adjList[7].add(5);
//		findBreakPoint(3,true);
//		System.out.println(Arrays.toString(isBreakPoint));
		findBridge(2, -1);
		System.out.println(Arrays.toString(discovered));
		System.out.println(bridgeList);
	}
	public static class Edge {
		int v1; 
		int v2;
		public Edge(int v1, int v2) {
			this.v1= v1;
			this.v2= v2;
		}
		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + "]";
		}
		
		
	}
	public static ArrayList<Edge> bridgeList = new ArrayList<>();
	
	public static int findBridge(int here, int parent) {
		discovered[here]= vertextCounter++;
		int ret = discovered[here];
		
		for(int i=0;i<adjList[here].size();i++) {
			int there = adjList[here].get(i);
			if(discovered[there]==-1) {
				int minResult = findBridge(there, here);
				
				if(minResult > discovered[here]) {
					bridgeList.add(new Edge(here, there));
				}
				ret = Math.min(ret, minResult);
				
			} else if(there!=parent) {
				ret = Math.min(ret, discovered[there]);
			}
		}
		return ret;
	}
}
