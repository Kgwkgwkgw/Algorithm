import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697_ANOTHER {
	public static class Node{
		int distance;
		int clock;
		public Node(int distance, int clock) {
			this.distance = distance; 
			this.clock= clock;
		}
		@Override
		public String toString() {
			return "Node [distance=" + distance + ", clock=" + clock + "]";
		}
		
	}
	public static int MAX = 100_001;
	public static boolean[] visited= new boolean[MAX*2];
	public static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		//수빈이의 위치
		Node startNode = new Node(Integer.parseInt(input[0]), 0);
		//동생의 위치
		K = Integer.parseInt(input[1]);
		Queue<Node> queue = new LinkedList<>();
		queue.add(startNode);
		while(true) {
//			System.out.println(queue);
			Node node = queue.poll();
			System.out.println(node.distance);
			if(node.distance==K) {
				System.out.println(node.clock);
				break;
			}
			if(node.distance-1<MAX && !visited[node.distance+1]) {
				queue.add(new Node(node.distance-1, node.clock+1));
			}
			if(node.distance+1>=0 && !visited[node.distance-1]) {
				queue.add(new Node(node.distance+1, node.clock+1));
			}
			if(node.distance*2<MAX && !visited[node.distance*2]) {
				queue.add(new Node(node.distance*2, node.clock+1));
			}
		}
	}
}
