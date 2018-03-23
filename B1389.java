import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1389 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int friendsCount = sc.nextInt();
		int friendshipCount = sc.nextInt();
		int[][] adj = new int[friendsCount+1][friendsCount+1];
		for(int i=0;i<friendshipCount;i++) {
			int from = sc.nextInt();
			int next = sc.nextInt();
			adj[from][next]++;
			adj[next][from]++;
		}
		System.out.println(bfsAll(adj));
		
	}
	public static int bfsAll(int[][] adj ) {
		int ret = 5001;
		int person =-1;
		for(int i=1;i<adj.length;i++) {
			int baconCount= bfs(i, adj);
			
			if(baconCount < ret) {
				person = i;
				ret= baconCount;
			}
		}
		return person;
	}
	public static int bfs(int start, int[][] adj) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] discovered = new boolean[adj.length];
		int[] distance = new int[adj.length];
		
		discovered[start]=true;
		queue.add(start);
		distance[start]= 0;
		int ret =0;
		while(!queue.isEmpty()) {
			int here = queue.poll();
			for(int there=1;there<discovered.length;there++) {
				if(adj[here][there]>0 && !discovered[there]) {
					discovered[there]=true;
					distance[there]= distance[here]+1;
					ret += distance[there];
					queue.add(there);
				}
			}
		}
		return ret;
	}
}
