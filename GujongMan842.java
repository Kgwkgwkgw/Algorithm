import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GujongMan842 {
	// 여기서는 방향 그래프이므로,
	// 오일러 서킷은 상관 없는데 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =Integer.parseInt(sc.nextLine());
		
		// vertex i와 vertex j사이의 간선 숫자
		int[][] adj = new int[26][26];
		// vertex i와 vertex j사이의 간선의 문자 
		Queue<String>[][] graph = new LinkedList[26][26];
		int[] outDegree = new int[26];
		int[] inDegree = new int[26];
		for(int i=0;i<26;i++) {
			for(int j=0;j<26;j++) {
				graph[i][j] = new LinkedList<>();
			}
		}
		
		LinkedList<String>stringList = new LinkedList<>();
		for(int i=0;i<n;i++) {
			stringList.add(sc.nextLine());
		
		}
		
		for(int i=0;i<n;i++) {
			String string = stringList.get(i);
			char first =string.charAt(0);
			char last = string.charAt(string.length()-1);
			graph[first-'a'][last-'a'].add(string);
			outDegree[first-'a']++;
			inDegree[last-'a']++;
			adj[first-'a'][last-'a']++;
		}
		LinkedList<Integer> edgeList = dfsAll(outDegree,inDegree, adj);
		LinkedList<String> resultList = new LinkedList<>();
		System.out.println(edgeList);
		for(int i=0;i<adj.length;i++) {
			for(int j=0;j<adj[i].length;j++) {
				if(adj[i][j]>0) {
					System.out.println("IMPOSSIBLE");
					return;
				}
			}
		}
		Iterator<Integer> iter = edgeList.descendingIterator();
		int from = iter.next();
		while(iter.hasNext()) {
			int to = iter.next();
			resultList.add(graph[from][to].poll());
			from =to;
		}
		System.out.println(resultList);
	}
	public static LinkedList<Integer> dfsAll(int[] outDegree,int[] inDegree ,int[][] adj) {
		LinkedList<Integer> vertextList = new LinkedList<>();
		for(int i=0;i<outDegree.length;i++) {
			if(outDegree[i]== inDegree[i]+1) {
				dfs(i, adj, vertextList);
				return vertextList;
			}
		}
//		System.out.println("start"+start);
		for(int i=0;i<outDegree.length;i++) {
			if(outDegree[i]>0) {
				dfs(i, adj, vertextList);
				return vertextList;
			}
		}
		return vertextList;
	}
	public static void dfs(int start, int[][] adj, LinkedList<Integer> vertexList) {
		for(int next=0;next<adj[start].length;next++) {
			if(adj[start][next]>0) {
				adj[start][next]--;
//				System.out.println("string :"+string);
//				graph[start][next].remove(string);
				dfs(next, adj, vertexList);
			}
		}
//		System.out.println("아래 string : "+string);
		vertexList.add(start);
	}
}
