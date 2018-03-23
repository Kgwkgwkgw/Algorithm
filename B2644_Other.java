import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2644_Other {
	public static int start;
	public static int dest;
	public static int peopleCount;
	public static int[][] adj;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		peopleCount = sc.nextInt();
		start = sc.nextInt();
		dest = sc.nextInt();
		int edgeCount = sc.nextInt();
		adj= new int[peopleCount+1][peopleCount+1];
		
		for(int i=0;i<edgeCount;i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			// 자식에서 부모로가는 무향 그래프를 그린다.
			adj[child][parent]++;
			adj[parent][child]++;
		}
		
		findAncestor();
	}
	public static void findAncestor() {
		Queue<Integer> queue = new LinkedList();
		int[] distance= new int[peopleCount+1];
		boolean[] discovered = new boolean[peopleCount+1];
		
		discovered[start]=true;
		distance[start]=0;
		queue.add(start);
		while(!queue.isEmpty()) {
			int here = queue.poll();
			if(here == dest) {
				System.out.println(distance[here]);
				return;
			}
			for(int i=1;i<peopleCount+1;i++) {
				if(adj[here][i]>0 && !discovered[i]) {
					queue.add(i);
					discovered[i]=true;
					distance[i]= distance[here]+1;
				}
			}
		}
		System.out.println(-1);
	}
	
}
