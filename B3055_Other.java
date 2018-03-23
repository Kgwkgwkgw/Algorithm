import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055_Other {
	public static int R;
	public static int C;
	public static char WATER = '*';
	public static char ROCK = 'X';
	public static char EMPTY = '.';
	public static char GOSMDOCHI = 'S';
	public static char VIVOR = 'D';
	public static char[][] map;
	public static int[] dx = {0 ,0, 1, -1 };
	public static int[] dy = {-1, 1, 0, 0};
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	public static Queue<Point> waterQueue= new LinkedList<>();
	public static Queue<Point> gosmdochiQueue = new LinkedList<>();
	
	public static void main(String[] args) {
		//R행 C열 
		//비어있는곳 .
		//물이 차있는 지역은 * 
		// 돌은 X
		//비버의 D
		// 고슴도치의 위치는 S
		// 물과 고슴도치는 돌을 통과할 수 없다. 
		// 고슴도치는 물로 차있는 구역을 이동할 수 없다. 
		// 물은 비버의 소굴로 이동할 수 없다. 
		// 물이 찰 예정인 칸으로 이동할 수 없다. 
		// 그래서 물을 먼저 실행시켜야할듯
		Scanner sc= new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		R = Integer.parseInt(inputs[0]);
		C = Integer.parseInt(inputs[1]);
		map = new char[R][C];
		
		for(int i=0;i<R;i++) {
			map[i]= sc.nextLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j]==WATER) {
					waterQueue.add(new Point(j,i));
				} else if (map[i][j]==GOSMDOCHI) {
					gosmdochiQueue.add(new Point(j, i));
				}
			}
		}
		bfs();
		
	}
	public static void bfs() {
		boolean[][] discovered = new boolean[R][C];
		HashMap<Point, Integer> distance = new HashMap<>();
		
		while(!gosmdochiQueue.isEmpty()) {
			int waterSize = waterQueue.size();
			for(int i=0;i<waterSize;i++) {
				Point waterPoint = waterQueue.poll();
				for(int j=0;j<4;j++) {
					int nextY= waterPoint.y+dy[j];
					int nextX= waterPoint.x+dx[j];
					
					if(nextY>=0&& nextY<R&& nextX>=0 && nextX<C &&
							map[nextY][nextX]== EMPTY) {
						map[nextY][nextX]=WATER;
						waterQueue.add(new Point(nextX,nextY));
					}
				}
			}
			
			int gosmdochiSize = gosmdochiQueue.size();
			for(int i=0;i<gosmdochiSize;i++) {
				Point gosmdochiPoint = gosmdochiQueue.poll();
				if(distance.size()==0) {
					distance.put(gosmdochiPoint, 0);
				}
				
				for(int j=0;j<4;j++) {
					int nextY= gosmdochiPoint.y+dy[j];
					int nextX= gosmdochiPoint.x+dx[j];
					
					if(nextY>=0&& nextY<R&& nextX>=0 && nextX<C ) {
						if( map[nextY][nextX] == VIVOR) {
							System.out.println(distance.get(gosmdochiPoint)+1);
							return;
							
						} else if ( map[nextY][nextX]== EMPTY && !discovered[nextY][nextX]) {
							gosmdochiQueue.add(new Point(nextX,nextY));
							distance.put(new Point(nextX,nextY), distance.get(gosmdochiPoint)+1);
							discovered[nextY][nextX]=true;
						}
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
}
