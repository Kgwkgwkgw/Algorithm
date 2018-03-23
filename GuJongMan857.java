import java.util.ArrayList;
import java.util.Arrays;

public class GuJongMan857 {
	public static int[][] adj = {
			{0,1,0,0,0,0,0,0},
			{1,0,1,1,0,0,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,1,0,1,1,0,0},
			{0,0,0,1,0,0,0,0},
			{0,0,1,1,0,0,1,1},
			{0,0,0,0,0,1,0,0},
			{0,0,0,0,0,1,0,0}
	};
	public static void main(String[] args) {
		discovered= new int[adj.length];
		Arrays.fill(discovered, -1);
		counter =0;
		findBridge(3,-1);
		System.out.println(resultList);
	}
	public static class Edge {
		int v1;
		int v2;
		public Edge(int v1, int v2) {
			this.v1=v1;
			this.v2=v2;
		}
		@Override
		public String toString() {
			return "Edge [v1=" + v1 + ", v2=" + v2 + "]";
		}
	}
	public static int[] discovered;
	public static int counter;
	public static ArrayList<Edge> resultList = new ArrayList<>();
	public static int findBridge(int here, int parent) {
		discovered[here]= counter++;
		int ret = discovered[here];
		
		for(int i=0;i<adj[here].length;i++) {
			if(adj[here][i]>0 && discovered[i]== -1) {
				int result = findBridge(i, here);
				if(result > discovered[here]) {
					resultList.add(new Edge(here, i ));
				}
				ret= Math.min(ret, result);
			} else if(i!= parent && adj[here][i]>0 && discovered[i]!=-1) {
				ret= Math.min(ret, discovered[i]);
			}
		}
		return ret;
	}
}
