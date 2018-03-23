
public class Boggle {
	public static char[][] character = { { 'U', 'R', 'L', 'P', 'M' }, { 'X', 'P', 'R', 'E', 'T' },
			{ 'G', 'I', 'A', 'E', 'T' }, { 'X', 'T', 'N', 'Z', 'Y' }, { 'X', 'O', 'Q', 'R', 'S' } };
	public static int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	public static int dy[] = { -1, 0, 1, 1, -1, 0, 1, -1 };

	public static void main(String[] args) {
		String word = "PRETTY";
		for (int i = 0; i < character.length; i++) {
			for (int j = 0; j < character[i].length; j++) {
				if (hasWord(j, i, word)) {
					System.out.println(true);
					break;
				}
			}
		}
	}


	public static boolean hasWord(int x, int y, String word) {
		if (x < 0 || y < 0 || x >= character.length || y >= character.length) {
			return false;
		}
		if (word.length() ==0) {
			return true;
		}
		if (word.charAt(0) != character[y][x]) {
			return false;
		}
		for (int i = 0; i < dx.length; i++) {
			if (hasWord(x + dx[i], y + dy[i], word.substring(1))) {
				return true;
			}
		}
		return false;
	}
}
