
public class FastestMaxSum {
	private static int[] arr = { -7, 4, -3, 6, 3, -8, 3, 4 };

	public static void main(String[] args) {
		int sum = 0;
		int result = -99999;
		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] < arr[i]) {
				sum = arr[i];
			} else {
				sum = sum + arr[i];
			}
			if (result < sum) {
				result = sum;
			}
		}
		System.out.println(result);
	}
}
