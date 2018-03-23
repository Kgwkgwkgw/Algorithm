import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
//창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

//토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

public class B7576 {
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	public static int m;
	public static int n;

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[][] initial;
	public static int unripeCount;
	public static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1 - 익은 사과
		// 0 - 안익은 사과
		// -1 -없음
		m = sc.nextInt();
		n = sc.nextInt();
		initial = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				initial[i][j] = sc.nextInt();
				if (initial[i][j] == 0) {
					unripeCount++;
				} else if (initial[i][j] == 1) {
					queue.add(new Point(j, i));
				}
			}
		}
		bfs();
	}

	public static void bfs() {
		if (unripeCount == 0) {
			System.out.println(0);
			return;
		}
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nextX = dx[k] + point.x;
				int nextY = dy[k] + point.y;

				if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && initial[nextY][nextX] == 0) {

					initial[nextY][nextX] = initial[point.y][point.x] + 1;
					unripeCount--;
					if (unripeCount == 0) {
						System.out.println(initial[nextY][nextX] - 1);
						return;
					} else {
						queue.add(new Point(nextX, nextY));
					}
				}
			}
		}
		System.out.println(-1);
	}
}
