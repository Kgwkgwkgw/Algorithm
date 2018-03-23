import java.util.Arrays;
import java.util.Scanner;

public class B2098 {
	public static int n;
	public static int[][] adj;
	public static int[] cities;
	public static int[][] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache= new int[n][1<<n];
		for(int i=0;i<cache.length;i++) {
			Arrays.fill(cache[i], -1);
		}

		adj= new int[n][n];
		cities= new int[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				adj[i][j]= sc.nextInt();
				if(adj[i][j]>0) {
					cities[i]|= (1<<j);
				}
			}
		}
		int result =MAX;
		System.out.println(solve(0,1,0));
	}
	public static int MAX = 1_000_000*15+1;
	public static int solve(int current, int visited, int start) {
		if(Integer.bitCount(visited)==n) {
			if(adj[current][start]>0) {
				
//				System.out.println("최종 : " + (cost+ adj[current][start]));
//				System.out.println("start이고 마지막이 current일때 : "+ start +" "+current);
//				cache[current][visited]=cost + adj[current][start];
				return adj[current][start];
			} else {
				return MAX;
			}
		}
		if(cache[current][visited]!=-1) {
//			if(start == 1) {
//				System.out.println("current : "+ current + " visited : "+ visited);
//				System.out.println("cache[start][visted] : "+cache[start][visited]);
//			}
			return cache[current][visited];
		}
		int ret = MAX;
		int canVisit = cities[current]&~(visited);
		int next  = (canVisit) & (-canVisit);
		while(next>0) {
			ret = Math.min(ret, adj[current][Integer.numberOfTrailingZeros(next)]+ solve(Integer.numberOfTrailingZeros(next),visited | next, start));
			canVisit&= (canVisit-1);
			next = (canVisit) & (-canVisit);
		}
		cache[current][visited]= ret;
//		cache[prev][visited]=ret;
		return ret;
	}
}