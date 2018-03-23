import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055 {
	public static int R;
	public static int C;
	public static char WATER = '*';
	public static char ROCK = 'X';
	public static char EMPTY = '.';
	public static char GOSMDOCHI = 'S';
	public static char VIVOR = 'D';
	public static char[][] map;
//	public static class Point{
//		int x;
//		int y;
//		public Point(int x, int y) {
//			this.x=x;
//			this.y=y;
//		}
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + x;
//			result = prime * result + y;
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Point other = (Point) obj;
//			if (x != other.x)
//				return false;
//			if (y != other.y)
//				return false;
//			return true;
//		}
//		
//	}
//	public static Queue<Point> waterQueue= new LinkedList<>();
//	public static Queue<Point> gosmdochiQueue = new LinkedList<>();
//	public static Point dest;
	public static class Game {
		int x;
		int y;
		char[][] board=new char[R][C];
		public Game(char[][] board, int x, int y) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					this.board[i][j]= board[i][j];
				}
			}
			this.x= x;
			this.y=y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.deepHashCode(board);
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
			Game other = (Game) obj;
			if (!Arrays.deepEquals(board, other.board))
				return false;
			return true;
		}
		
	}
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
		int y=0;
		int x=0;
		for(int i=0;i<R;i++) {
			map[i]= sc.nextLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j]==GOSMDOCHI) {
					y=i;
					x=j;
				}
			}
		}
		bfs(map, x, y);
		
	}
	public static void bfs(char[][] initial, int initialX, int initialY) {
		
		HashMap<Game, Integer> distance = new HashMap<>();
		Game init= new Game(initial, initialX, initialY);
		Queue<Game> gameQueue = new LinkedList();
		gameQueue.add(init);
		distance.put(init, 0);
		
		while(!gameQueue.isEmpty()) {
			Game game = gameQueue.poll();
			int d = distance.get(game);
			waterInfluence(game.board);
			
			for(int k=0;k<4;k++) {
				int nextY= game.y+dy[k];
				int nextX= game.x+dx[k];
				if(nextY>=0&& nextY<R&& nextX>=0 && nextX<C) {
					if(game.board[nextY][nextX]== VIVOR) {
						System.out.println(d+1);
						return;
					}else if(game.board[nextY][nextX]==EMPTY) {
						Game newGame = new Game(game.board, nextX, nextY);
						newGame.board[game.y][game.x] = EMPTY;
						newGame.board[nextY][nextX] = GOSMDOCHI;
						
						if(!distance.containsKey(newGame)) {
							gameQueue.add(newGame);
							distance.put(newGame, d+1);
						}
					}
				}
					
			}
		}
		System.out.println("KAKTUS");
	}
	public static int[] dx = {0 ,0, 1, -1 };
	public static int[] dy = {-1, 1, 0, 0};
	public static void waterInfluence(char[][] map) {
		boolean[][] discovered= new boolean[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==WATER && !discovered[i][j]) {
					discovered[i][j]=true;
					for(int k=0;k<4;k++) {
						int nextY= i+dy[k];
						int nextX= j+dx[k];
						if(nextY>=0&& nextY<R&& nextX>=0 && nextX<C&& 
								map[nextY][nextX]==EMPTY&& !discovered[nextY][nextX]) {
							map[nextY][nextX]=WATER;
							discovered[nextY][nextX]=true;
						}
							
					}
				}
			}
		}
	}
}
