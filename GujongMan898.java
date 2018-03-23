import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GujongMan898 {
	public static class State {
		int[][] board;
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };

		public ArrayList<State> getAdjList() {
			int y = -1;
			int x = -1;
			ArrayList<State> adjList = new ArrayList<>();
			boolean isFind = false;
			for (y = 0; y < board.length; y++) {
				for (x = 0; x < board[y].length; x++) {
					if (board[y][x] == 0) {
						isFind = true;
						break;
					}
				}
				if (isFind) {
					break;
				}
			}
			for (int i = 0; i < 4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];
				if (nextY >= 0 && nextY < board.length && nextX >= 0 && nextX < board[nextY].length) {
					State newState = new State();
					newState.board = new int[board.length][board.length];
					for (int l = 0; l < board.length; l++) {
						for (int m = 0; m < board[l].length; m++) {
							newState.board[l][m] = board[l][m];
						}
					}
					newState.board[y][x] = newState.board[nextY][nextX];
					newState.board[nextY][nextX] = 0;
					// System.out.println("y " + y);
					// System.out.println("x "+x);
					// System.out.println("y+dx[i] " + nextY);
					// System.out.println("x+dx[i] "+nextX);
					// System.out.println("newState");
					// System.out.println(newState);
					adjList.add(newState);

				}
			}
			return adjList;
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
			State other = (State) obj;
			if (!Arrays.deepEquals(board, other.board))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < board.length; i++) {
				sb.append(Arrays.toString(board[i]) + "\n");
			}
			return sb.toString();
		}

	}

	public static int sign(int x) {
		if (x == 0) {
			return 0;
		}
		return x > 0 ? 1 : -1;
	}

	public static int increment(int x) {
		if (x < 0) {
			return x - 1;
		}
		return x + 1;
	}

	public static void main(String[] args) {
		State current = new State();
		State finish = new State();
		current.board = new int[4][4];
		current.board[0][0] = 1;
		current.board[0][1] = 2;
		current.board[0][2] = 3;
		current.board[0][3] = 4;

		current.board[1][0] = 5;
		current.board[1][1] = 6;
		current.board[1][2] = 7;
		current.board[1][3] = 8;

		current.board[2][0] = 9;
		current.board[2][1] = 10;
		current.board[2][2] = 0;
		current.board[2][3] = 12;

		current.board[3][0] = 13;
		current.board[3][1] = 14;
		current.board[3][2] = 15;
		current.board[3][3] = 11;

		finish.board = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				finish.board[i][j] = (i) * finish.board.length + j + 1;
			}
		}
		finish.board[finish.board.length - 1][finish.board.length - 1] = 0;
		for (int i = 0; i < finish.board.length; i++) {
			System.out.println(Arrays.toString(finish.board[i]));
		}
		Queue<State> queue = new LinkedList<>();
		HashMap<State, Integer> distance = new HashMap<>();
		if (current.equals(finish)) {
			System.out.println(0);
			return;
		}
		distance.put(current, 1);
		distance.put(finish, -1);
		queue.add(current);
		queue.add(finish);
		
		while (!queue.isEmpty()) {
			State state = queue.poll();
			int d = distance.get(state);
		
			ArrayList<State> adjList = state.getAdjList();
			for (int i = 0; i < adjList.size(); i++) {
				State next = adjList.get(i);
				if (!distance.containsKey(next)) {
					queue.add(next);
					distance.put(next, increment(d));
				} else if(sign(distance.get(next))!= sign(d)){
					System.out.println(Math.abs(d)+ Math.abs(distance.get(next)-1));
					return;
				}
			}
		}
	
		System.out.println("-1");
	}
}
