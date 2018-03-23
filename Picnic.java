public class Picnic {
	public static int count = 0;
	public static int[][] friend;
	public static boolean[] taken;

	public static void main(String[] args) {
		int number = 6;
		friend = new int[number][number];
		taken = new boolean[number];
		friend[0][1] = 1;
		friend[1][0] = 1;
		friend[0][2] = 1;
		friend[2][0] = 1;
		friend[1][2] = 1;
		friend[2][1] = 1;
		friend[1][3] = 1;
		friend[3][1] = 1;
		friend[1][4] = 1;
		friend[4][1] = 1;
		friend[2][3] = 1;
		friend[3][2] = 1;
		friend[2][4] = 1;
		friend[4][2] = 1;
		friend[3][4] = 1;
		friend[4][3] = 1;
		friend[3][5] = 1;
		friend[5][3] = 1;
		friend[4][5] = 1;
		friend[5][4] = 1;

		System.out.println(solve());
	}

	public static int solve() {
		int firstPeople=-1;
		for (int i = 0; i < friend.length; i++) {
			if (!taken[i]) {
				firstPeople=i;
				break;
			}
		}
		if (firstPeople==-1) {
			return 1;
		}
		int ret =0;
		for (int i = firstPeople+1; i < friend.length; i++) {
			if(!taken[i] && friend[firstPeople][i]==1 ) {
				taken[i]=true;
				taken[firstPeople]=true;
				ret += solve();
				taken[i]=false;
				taken[firstPeople]=false;
			}
		}
		return ret;
	}
}
