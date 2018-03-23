import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.


public class B1697_Re {
	public static int subinPosition;
	public static int dongsangPosition;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		subinPosition = sc.nextInt();
		dongsangPosition = sc.nextInt();
		bfs();
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[100_001 * 2 ];
		boolean[] discovered = new boolean[distance.length];

		queue.add(subinPosition);
		distance[subinPosition] = 0;
		discovered[subinPosition] = true;

		while (!queue.isEmpty()) {
			int currentSubinPosition = queue.poll();
			if (currentSubinPosition == dongsangPosition) {
				System.out.println(distance[currentSubinPosition]);
				return;
			}
			if (currentSubinPosition * 2 < distance.length && !discovered[currentSubinPosition * 2]) {
				queue.add(currentSubinPosition * 2);
				distance[currentSubinPosition * 2] = distance[currentSubinPosition] + 1;
				discovered[currentSubinPosition * 2] = true;
			}
			if (currentSubinPosition + 1 < distance.length && !discovered[currentSubinPosition + 1]) {
				queue.add(currentSubinPosition + 1);
				distance[currentSubinPosition + 1] = distance[currentSubinPosition] + 1;
				discovered[currentSubinPosition + 1] = true;
			}
			if (currentSubinPosition - 1 >= 0 && !discovered[currentSubinPosition - 1]) {
				queue.add(currentSubinPosition - 1);
				distance[currentSubinPosition - 1] = distance[currentSubinPosition] + 1;
				discovered[currentSubinPosition - 1] = true;
			}
		}
	}
}
