import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OilerCircuit840 {
	public static int[][] adj = new int[8][8];
	
	public static void main(String[] args) {
		LinkedList<Integer> list = null;
		adj[0][1]= 1;
		adj[1][2]= 1;
		adj[2][3]= 1;
		adj[3][4]= 1;
		adj[4][5]= 1;
		adj[5][6]= 1;
		adj[6][3]= 1;
		adj[3][7]= 1;
		adj[7][0]= 1;
		list =dfsAll(0);
		
		System.out.println(list);
		Iterator<Integer> iter = list.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	public static LinkedList<Integer> dfsAll(int start) {
		LinkedList<Integer> list = new LinkedList<>();
		dfs(start, list);
		return list;
	}

	public static void dfs(int i, LinkedList<Integer> list) {
		for(int j=0;j<8;j++) {
			if(adj[i][j]>0) {
				adj[i][j]--;
				adj[j][i]--;
				dfs(j,list);
			}
		}
		list.add(i);
	}
}
