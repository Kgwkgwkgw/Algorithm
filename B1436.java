import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1436 {
//	public static int count=0;
	public static int MAX = 1_000_000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		cache= new int[X+1];
		Arrays.fill(cache, -1);
		System.out.println(solve(X));
	}
	public static int[] cache;
	public static int solve(int x) {
		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> distance = new HashMap<>();
		boolean[] discovered = new boolean [(MAX+1)*3];
		distance.put(1, 0);
		queue.add(1);
		discovered[1]=true;
		while(!queue.isEmpty()) {
			int pop = queue.poll();
//			System.out.println(pop);
			int d = distance.get(pop);
			if(pop==x) {
				return d;
			}
			if(pop*3<=x && !discovered[pop*3]) {
				queue.add(pop*3);
				distance.put(pop*3,d+1);
				discovered[pop*3]=true;
			}
			if(pop*2<=x && !discovered[pop*2]) {
				queue.add(pop*2);
				distance.put(pop*2,d+1);
				discovered[pop*2]=true;
			}
			if(pop+1<=x && !discovered[pop+1]) {
				queue.add(pop+1);
				distance.put(pop+1,d+1);
				discovered[pop+1]=true;
			}
		}
		return -1;
//		distance[1]=1;
//		if(x==1) {
//			return count;
//		}
//		if(cache[x]!=-1) {
//			return cache[x];
//		}
//		int ret =MAX;
//		if(x%3==0) {
//			ret= Math.min(ret, solve(x/3, count+1));
//		}
//		if(x%2==0) {
//			ret= Math.min(ret, solve(x/2, count+1));
//		}
//		ret = Math.min(ret, solve(x-1, count+1));
//		cache[x]= ret;
//		return ret;
	}
}
