import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7562 {
	public static class Point{
		int x;
		int y; 
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static int t;
	public static int l;
	public static Point start;
	public static Point destination;
	public static int[] dx = {2, 1, 2, 1, -2,-1, -2, -1};
	public static int[] dy = {1, 2, -1, -2, 1,2, -1, -2};
	public static int[][] board;
	public static Queue<Point> queue;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		t= sc.nextInt();
		while(t-->0) {
			l =sc.nextInt();
			board= new int[l][l];
			start = new Point(sc.nextInt(), sc.nextInt());
			destination= new Point(sc.nextInt(), sc.nextInt());
			bfs();
 		}
	}
	public static void bfs() {
		if(start.x== destination.x && start.y == destination.y) {
			System.out.println(0);
			return;
		}
		queue= new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for(int i=0;i<dx.length;i++) {
				int nextX = point.x+dx[i];
				int nextY = point.y+dy[i];
				if(nextY>=0&& nextY<l && nextX>=0&& nextX<l && board[nextY][nextX]==0) {
					if(nextY==destination.y && nextX== destination.x) {
						System.out.println(board[point.y][point.x]+1);
						return;
					} 
					queue.add(new Point(nextX, nextY));
					board[nextY][nextX]=board[point.y][point.x]+1;
					
				}
			}
		}
		System.out.println(-1);
	}
}
