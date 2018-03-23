import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7569 {
	public static int width;
	public static int col;
	public static int height;
	public static int[][][] box;
	public static class Point {
		int x;
		int y;
		int z;
		public Point(int x, int y, int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", z=" + z + "]";
		}
		
	}
	public static Queue<Point> queue = new LinkedList();
	public static int unRipeCount =0;
	public static int[] dx= {1,-1, 0, 0, 0,0};
	public static int[] dy= {0, 0, 1,-1 ,0,0};
	public static int[] dz= {0, 0, 0,0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		col = sc.nextInt();
		height = sc.nextInt();
		box = new int[height][col][width];
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<col;j++) {
				for(int k=0;k<width;k++) {
					box[i][j][k] = sc.nextInt();
					if(box[i][j][k]==1) {
						queue.add(new Point(k,j,i));
					} else if(box[i][j][k]==0) {
						unRipeCount++;
					}
				}
			}
		}
		System.out.println(findEveryRipeDate());
	}
	public static int findEveryRipeDate() {
		if(unRipeCount==0) {
			return 0;
		}
		while(!queue.isEmpty()) {
//			for(int i=0;i<height;i++) {
//				for(int j=0;j<col;j++) {
//					System.out.println(Arrays.toString(box[i][j]));
//				}
//				System.out.println();
//			}
			Point point = queue.poll();
			for(int i=0;i<6;i++) {
				int nextX = point.x+dx[i];
				int nextY = point.y+dy[i];
				int nextZ = point.z+dz[i];
				if(nextX>=0 && nextX<width && 
						nextY>=0 && nextY<col && 
						nextZ>=0 && nextZ<height && box[nextZ][nextY][nextX]==0 ) {
					unRipeCount--;
					box[nextZ][nextY][nextX]= box[point.z][point.y][point.x]+1;
					if(unRipeCount==0) {
						return box[nextZ][nextY][nextX]-1;
					}
					queue.add(new Point(nextX, nextY, nextZ));
				}
			}
		}
		
		return -1;
	}
}
