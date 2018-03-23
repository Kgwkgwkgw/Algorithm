import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Dfs {
	public static boolean[] visied;
	public static ArrayList<ArrayList <Integer>> adj = new ArrayList<>();
	public static int[] discovered;
	public static boolean[] finished;
	public static int counter;
	
	public static void dfs(int vertex) {
		visied[vertex]=true;
		System.out.println(vertex);
		for(int i=0;i<adj.get(vertex).size();i++) {
			if(!visied[adj.get(vertex).get(i)]) {
				dfs(adj.get(vertex).get(i));
			}
		}
		return;
	}
	//트리간선, 순행간선, 역행간선, 교차간선(무방향에서는 없음)을 보여줌
	public static void dfs2(int vertex) {
		discovered[vertex]=++counter;
		for(int i=0;i<adj.get(vertex).size();i++) {
			int there = adj.get(vertex).get(i);
			if(discovered[there]==0) {
				System.out.println("트리간선입니다. "+ there );
				dfs2(there);
			} else if (discovered[vertex] < discovered[there]) {
				System.out.println("순행간선입니다 " + there );
			} else if(!finished[there]) {
				System.out.println("역행간선입니다.. " +there);
			} else {
				System.out.println("교차간선입니다.");
			}
		}
		finished[vertex]=true;
	}
	public static boolean[] isCutVerext;
	public static int[] cutVertexCount;
//	public static int cutVertexCount = 0;
	//절단점 찾기
	public static int dfs3(boolean isRoot, int vertex) {
		System.out.println(isRoot);
		System.out.println(vertex);
		System.out.println(counter);
		System.out.println("discovered[vertext] : (before)"+discovered[vertex]);
		discovered[vertex] = ++counter;
		System.out.println("discovered[vertext] : (after)"+discovered[vertex]);
		int ret = discovered[vertex];
		int children=0;
		for(int i=0;i<adj.get(vertex).size();i++) {
			int there = adj.get(vertex).get(i);
			if(discovered[there]==0) {
				children++;
				int childReverseEdge = dfs3(false, there);
				if(childReverseEdge >= discovered[vertex]) {
//					cutVertexCount++;
					isCutVerext[vertex]=true;
					cutVertexCount[vertex]++;
				}
				ret = Math.min(ret, childReverseEdge);
				//순행이나 역행잇을수잇는데, 역행은항상 더 작을것이다. 순행은 한상 클것이다.
			} else {
				ret = Math.min(ret, discovered[there]);
			}
		}
		if(isRoot && children==0 || children==1) {
			isCutVerext[vertex]=false;
			cutVertexCount[vertex]=0;
		}
		return ret;
	}
	public static LinkedList<Edge> bridgeList= new LinkedList<>();
	public static class Edge{
		int vertex1;
		int vertex2;
		Edge(int vertex1, int vertex2) {
			this.vertex1= vertex1;
			this.vertex2 = vertex2;
		}
		@Override
		public String toString() {
			return "Edge [vertex1=" + vertex1 + ", vertex2=" + vertex2 + "]";
		}
		
	}
	public static int dfs4(int parent, int current) {
		discovered[current]= ++counter;
		int ret = discovered[current];
		boolean isBridge = true;
		for(int i=0;i<adj.get(current).size();i++) {
			int there = adj.get(current).get(i);
			
			if(discovered[there]==0) {
				int subTreeMinBackEdge  = dfs4(current, there);
				if(subTreeMinBackEdge < discovered[current]) {
					isBridge=false;
				}
				ret = Math.min(ret, subTreeMinBackEdge);
			} else {
				ret = Math.min(ret, discovered[there]);
				if(discovered[there]< discovered[parent]) {
//				if(there!=parent&& discovered[there]< discovered[current]) {
					isBridge=false;
				}
			}
		}
		if(parent!=-1 && isBridge) {
			bridgeList.add(new Edge(parent, current));
		}
		return ret;
	}
	public static void dfsAll4() {
		for(int i=0;i<adj.size();i++) {
			if(discovered[i]==0) {
				dfs4(-1, i);
			}
		}
		System.out.println(bridgeList);
	}
	public static void dfsAll3() {
		for(int i=0;i<adj.size();i++) {
			if(discovered[i]==0) {
				dfs3(true, i);
			}
		}
	}
	public static void dfsAll2() {
		for(int i=0;i<adj.size();i++) {
			if(discovered[i]==0) {
				dfs2(i);
			}
		}
	}
	public static void dfsAll() {
		for(int i=0;i<adj.size();i++) {
			if(!visied[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> vertex0 = new ArrayList<>();
		//vertex1.add(0);
		vertex0.add(1);
		ArrayList<Integer> vertex1 = new ArrayList<>();
		vertex1.add(0);
		vertex1.add(2);
		vertex1.add(3);
//		vertex2.add(4);
		ArrayList<Integer> vertex2 = new ArrayList<>();
		vertex2.add(1);
		vertex2.add(3);
		vertex2.add(5);
//		vertex3.add(0);
		ArrayList<Integer> vertex3= new ArrayList<>();
		vertex3.add(1);
		vertex3.add(2);
		vertex3.add(4);
		vertex3.add(5);
//		vertex4.add(0);
		ArrayList<Integer> vertex4= new ArrayList<>();
		vertex4.add(3);
//		vertex5.add(0);
		ArrayList<Integer> vertex5= new ArrayList<>();
		vertex5.add(2);
		vertex5.add(3);
		vertex5.add(6);
		vertex5.add(7);
		ArrayList<Integer> vertex6= new ArrayList<>();
		vertex6.add(5);
		ArrayList<Integer> vertex7= new ArrayList<>();
		vertex6.add(5);
		adj.add(vertex0);
		adj.add(vertex1);
		adj.add(vertex2);
		adj.add(vertex3);
		adj.add(vertex4);
		adj.add(vertex5);
		adj.add(vertex6);
		adj.add(vertex7);
		visied= new boolean[adj.size()];
		finished= new boolean[adj.size()];
		discovered= new int[adj.size()];
		isCutVerext =new boolean[adj.size()];;
		cutVertexCount = new int[adj.size()];
//		dfsAll();
//		System.out.println("----");
//		dfsAll2();
//		dfsAll3();
		System.out.println("----");
//		System.out.println(Arrays.toString(isCutVerext));
//		System.out.println(Arrays.toString(cutVertexCount));
		dfsAll4();
	}
}
