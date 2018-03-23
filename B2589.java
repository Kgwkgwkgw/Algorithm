import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2589 {
	public static int col;
	public static int width;
	public static char[][] board;
	public static class Point{ 
		int x;
		int y;
		public Point(int x, int y) {
			this.x= x;
			this.y= y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
//	public static Queue<Point> landPoints = new LinkedList<>();
	public static int[] dx =  { 0, 0, -1, 1};
	public static int[] dy =  { -1, 1, 0 , 0 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs= sc.nextLine().split(" ");
		col = Integer.parseInt(inputs[0]);
		width = Integer.parseInt(inputs[1]);
		
		board = new char[col][width];
		for(int i=0;i<col;i++) {
			String input = sc.nextLine();
			for (int j=0;j<input.length();j++) {
				if(input.charAt(j)=='L') {
					board[i][j]='L';
				}
			}
		}
		
		System.out.println(findShortestPath());
	}
	public static int ret=0;
	public static int findShortestPath() {
		for(int i=0;i<col;i++) {
			for(int j=0;j<width;j++) {
				if(board[i][j]=='L') {
					bfs(new Point(j,i));
				}
			}
		}
		return ret;
	}
	public static void bfs(Point bfsStartPoint) {
		boolean[][] discovered= new boolean[col][width];
		int[][] distance= new int[col][width];
		
		Queue<Point> path = new LinkedList<>();
		path.add(bfsStartPoint);
		
		discovered[bfsStartPoint.y][bfsStartPoint.x]=true;
		distance[bfsStartPoint.y][bfsStartPoint.x]=0;
		
		while(!path.isEmpty()) {
			Point pathPoint = path.poll();
			for(int k=0;k<4;k++) {
				int nextX = pathPoint.x+dx[k];
				int nextY =pathPoint.y+dy[k];
				if(nextX>=0&& nextX<width
						&& nextY>=0&& nextY<col
						&& board[nextY][nextX]=='L'
						&& !discovered[nextY][nextX]) {
					path.add(new Point(nextX, nextY));
					discovered[nextY][nextX]=true;
					distance[nextY][nextX]= distance[pathPoint.y][pathPoint.x]+1;
					ret= Math.max(ret, distance[nextY][nextX]);
				}
			}
		}
	}
}
