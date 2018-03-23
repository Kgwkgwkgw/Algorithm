import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class B2213 {
	public static class Node {
		int weight;
		ArrayList<Integer> adjList = new ArrayList<>();
	}
	public static Node[] nodeList;
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		visited = new boolean[n+1];
		nodeList = new Node[n+1];
		
		for(int i=1;i<nodeList.length;i++) {
			nodeList[i]= new Node();
		}
		String[] weightInputs= sc.nextLine().split(" ");
		for(int i=1;i<nodeList.length;i++) {
			nodeList[i].weight = Integer.parseInt(weightInputs[i+1]);
		}
		
		for(int i=1;i<=n;i++) {
			String[] edgeInputs = sc.nextLine().split(" ");
			int from = Integer.parseInt(edgeInputs[0]);
			int to = Integer.parseInt(edgeInputs[1]);
			
			nodeList[from].adjList.add(to);
			nodeList[to].adjList.add(from);
		}
		findRoot(1);
		
	}
	public static LinkedList<ArrayList<Integer>> resultList;
	public static void solve(int root) {
		
		makeList(root,1, new ArrayList<Integer>());
		makeList(root,-1, new ArrayList<Integer>());
	}
	// isAdd가 1이면 포함함
	// isAdd가 -1이면 미포함
	public static void makeList(int current, int isAdd, ArrayList<Integer> arrayList) {
		ArrayList<Integer> copyWithOutThis = new ArrayList<>(arrayList);
		ArrayList<Integer> copyWithThis = new ArrayList<>(arrayList);
		copyWithThis.add(current);
		for(int i=0;i<nodeList[current].adjList.size();i++) {
			if(isAdd==1) {
				makeList(nodeList[current].adjList.get(i), isAdd, copyWithOutThis);
				makeList(nodeList[current].adjList.get(i), isAdd*-1, copyWithThis);
			} else {
				makeList(nodeList[current].adjList.get(i), isAdd*-1, copyWithOutThis);
			}
		}
	}
	public static int root =0;
	public static void findRoot(int start) {
		visited[start]=true;
		for(int i=0;i<nodeList[start].adjList.size();i++) {
			if(!visited[nodeList[start].adjList.get(i)]) {
				findRoot(nodeList[start].adjList.get(i));
			}
		}
		root=start;
	}
}
