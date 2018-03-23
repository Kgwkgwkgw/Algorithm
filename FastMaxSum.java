
public class FastMaxSum {
	private static int[] arr = { -7, 4, -3, 6, 3, -8, 3, 4 };

	public static void main(String[] args) {
		System.out.println(fastMaxSum(0, arr.length - 1));
	}

	public static int fastMaxSum(int begin, int end) {
		if(end- begin <=0) {
			return arr[begin];
		}
		int mid = (begin + end) / 2;
		int result;
		int sum = 0;
		int resultLeft= fastMaxSum(begin, mid);
		int resultRight = fastMaxSum(mid+1, end);
		int resultMid = -99999;
		 
		if (resultLeft > resultRight) {
			result = resultLeft;
		} else {
			result = resultRight;
		}
		
		for(int i= mid; i>=begin; i--) {
			sum += arr[i];
			if(sum > resultMid) {
				resultMid = sum;
			}
		}
		sum = resultMid;
		for(int i=mid+1;i<=end;i++) {
			sum+= arr[i];
			if(sum> resultMid) {
				resultMid = sum;
			}
		}
		return result > resultMid ? result : resultMid;
	}
}
