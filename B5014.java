import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B5014 {
	public static int total; 
	public static int current;
	public static int dest;
	public static int up;
	public static int down;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();
		current = sc.nextInt();
		dest = sc.nextInt();
		up = sc.nextInt();
		down = sc.nextInt();
		bfs();
	}
	public static void bfs() {
		Queue<Integer> queue= new LinkedList<>();
		int[] distance = new int[total+1];
		boolean[] discovered= new boolean[total+1];
		queue.add(current);
		discovered[current]=true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current == dest) {
				System.out.println(distance[current]);
				return;
			}
			
			if(current+up<= total && !discovered[current+up]) {
				queue.add(current+up);
				distance[current+up] = distance[current]+1;
				discovered[current+up]=true;
			}
			
			if(current-down>=1 && !discovered[current-down]) {
				queue.add(current-down);
				distance[current-down] = distance[current]+1;
				discovered[current-down]=true;
			}
		}
		System.out.println("use the stairs");
	}
}
