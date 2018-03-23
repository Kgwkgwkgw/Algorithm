import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class TopologicalSortUsingDfs {
//B_2623 에서는 큐를 이용해서 옛날에 풀어봣어슴
	public static boolean[] visied;
	public static ArrayList<ArrayList <Integer>> adj = new ArrayList<>();
	public static LinkedList<Integer> linkedList= new LinkedList();
	public static void dfs(int vertex) {
		visied[vertex]=true;
		for(int i=0;i<adj.get(vertex).size();i++) {
			if(!visied[adj.get(vertex).get(i)]) {
				dfs(adj.get(vertex).get(i));
			}
		}
		System.out.println(vertex);
		linkedList.add(vertex);
		return;
	}
	public static void dfsAll() {
		for(int i=0;i<adj.size();i++) {
			if(!visied[i]) {
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> vertex1 = new ArrayList<>();
		vertex1.add(1);
		ArrayList<Integer> vertex2 = new ArrayList<>();
		vertex2.add(2);
		ArrayList<Integer> vertex3 = new ArrayList<>();
		vertex3.add(3);
		ArrayList<Integer> vertex4 = new ArrayList<>();
		vertex4.add(4);
		ArrayList<Integer> vertex5 = new ArrayList<>();
		ArrayList<Integer> vertex6 = new ArrayList<>();
		vertex6.add(6);
		vertex6.add(7);
		vertex6.add(8);
		ArrayList<Integer> vertex7 = new ArrayList<>();
		vertex7.add(0);
		ArrayList<Integer> vertex8 = new ArrayList<>();
		vertex8.add(1);
		ArrayList<Integer> vertex9 = new ArrayList<>();
		vertex9.add(3);
		ArrayList<Integer> vertex10 = new ArrayList<>();
		vertex10.add(2);
		
		adj.add(vertex1);
		adj.add(vertex2);
		adj.add(vertex3);
		adj.add(vertex4);
		adj.add(vertex5);
		adj.add(vertex6);
		adj.add(vertex7);
		adj.add(vertex8);
		adj.add(vertex9);
		adj.add(vertex10);
		visied= new boolean[adj.size()];
		dfsAll();
		System.out.println("-------");
		
		Iterator<Integer> iter =linkedList.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
