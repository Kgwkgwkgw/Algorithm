import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GuJongMan_864 {
	public static int g;
	public static int h;
	public static ArrayList<LinkedList<Integer>> adj= new ArrayList<>();
	public static boolean[] visited;
	public static int cctvCount;
	public static int WATCHED =0;
	public static int NEED_TV =1;
	public static int NO_NEED_TV =2;
	
	// 해당 노드의 상태를 반환 (감시 되는지 그런거//);
	public static int dfs(int current) {
		visited[current] = true;
		int[] childState= {0, 0, 0};
		for(int i=0;i<adj.get(current).size();i++) {
			int there = adj.get(current).get(i);
			if(!visited[there]) {
				childState[dfs(there)]++;
				System.out.println("current : "+ current);
				System.out.println("there : "+ there);
				System.out.println("----");
			}
		}
		if(childState[NEED_TV]>0) {
			cctvCount++;
			return WATCHED;
		}
		if(childState[WATCHED]>0) {
			return NO_NEED_TV;
		}
		return NEED_TV;
	}
	public static void dfsAll() {
		for(int i=0;i<g;i++) {
			if(!visited[i]&& dfs(i)==NEED_TV) {
				cctvCount++;
			}
		}
		System.out.println(cctvCount);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		g=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<g;i++) {
			adj.add(new LinkedList<>());
		}
		
		visited= new boolean[g];
		h=Integer.parseInt(sc.nextLine());
		for(int i=0;i<h;i++) {
			String[] inputs =sc.nextLine().split(" ");
			int v1 = Integer.parseInt(inputs[0]);
			int v2 = Integer.parseInt(inputs[1]);
			adj.get(v1).add(v2);
			adj.get(v2).add(v1);
		}
		dfsAll();
	}
}
