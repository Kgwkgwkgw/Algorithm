import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1963 {
	// 소수를 유난히도 좋아하는 창영이는 게임 아이디 비밀번호를 4자리 ‘소수’로 정해놓았다. 어느 날 창영이는 친한 친구와 대화를 나누었는데:
	// 입력은 항상1000이상
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			bfs(start, end);
		}
	}

	public static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] discovered = new boolean[10000];
		int[] distance = new int[10000];

		discovered[start] = true;
		distance[start] = 0;
		queue.add(start);
		while (!queue.isEmpty()) {
			int number = queue.poll();
			if (number == end) {
				System.out.println(distance[number]);
				return;
			}
			int[] numberJarisu = new int[4];
			int copyNumber = number;
			for (int i = 0; i < numberJarisu.length; i++) {
				numberJarisu[i] = copyNumber % 10;
				copyNumber /= 10;
			}
			for (int i = 3; i >= 0; i--) {
				copyNumber = number;
				int posi = (int) Math.pow(10, i);
				copyNumber -= numberJarisu[i] * posi;
				for (int j = 0; j <= 9; j++) {
					if (i == 3 && j == 0) {
						continue;
					}
					// System.out.println("copyNumber : "+ copyNumber);
					// System.out.println("posi*j : "+ posi*j);
					// System.out.println("toAddNumber+ posi*j : "+ (copyNumber+ posi*j));
					if (copyNumber + posi * j < discovered.length && !discovered[copyNumber + posi * j]
							&& isSosu(copyNumber + posi * j)) {
						queue.add(copyNumber + posi * j);
						discovered[copyNumber + posi * j] = true;
						distance[copyNumber + posi * j] = distance[number] + 1;
					}

				}
			}
		}
	}

	public static boolean isSosu(int value) {
		for (int i = 2; i <= Math.sqrt(value); i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

}
