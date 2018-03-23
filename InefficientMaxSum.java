
public class InefficientMaxSum {
	public static void main(String[] args) {
		int[] arr = { -7, 4, -3, 6, 3, -8, 3, 4 };
		int min = -99999;
		int ret = min;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
					if (sum > ret) {
						ret = sum;
					}
				}
			}
		}
		System.out.println(ret);
	}
}
