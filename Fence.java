
public class Fence {
//	public static int N = 4;
//	public static int[] fence = { 1,4,4,4,4,1,1};
	public static int[] fence = { 7,1,5,9,6,7,3};
//	public static int[] fence = { 1,8,2,2};
	public static int max = 9999;
	public static void main(String[] args) {
		System.out.println(solve(0, fence.length-1));
	}

	public static int solve(int begin, int end) {
		if(end-begin==0) {
			return 1*fence[begin];
		}
		int mid = (begin + end) / 2;
		int leftWidth =solve(begin, mid);
		System.out.println("leftWidth "+leftWidth);
		int rightWidth = solve(mid+1, end);
		System.out.println("rightWidth "+rightWidth);
		int result = 0;
		int minHeight = max;
		
		int low = mid;
		int high = mid+1;
		
		if(fence[low]<fence[high]) {
			minHeight = fence[low];
		} else {
			minHeight = fence[high];
		}
		result = Math.max(result, 2*minHeight);
		//구만종 199 쪽 참조 
		while(low>begin || high<end) {
			if(low<=begin || high<end && fence[high+1]> fence[low-1]) {
				high++;
				minHeight = Math.min(minHeight, fence[high]);
			}
			else {
				low--;
				minHeight = Math.min(minHeight, fence[low]);
			}
			result = Math.max(result, (high-low+1)* minHeight);
		}
		
		
//		for(int i=mid;i>=begin; i--) {
//			minHeight = fence[i]; 
//			int sum =0;
//			for(int j=mid;j>=begin;j--) {
//				if(fence[j]>=minHeight) {
//					sum += minHeight*1;
//				} else {
//					break;
//				}
//			}
//			for(int j=mid+1;j<=end;j++) {
//				if(fence[j]>=minHeight) {
//					sum+= minHeight*1;
//				} else {
//					break;
//				}
//			}
//			if(result < sum) {
//				result = sum;
//			}
//		}
//		for(int i=mid+1;i<=end; i++) {
//			minHeight = fence[i]; 
//			int sum =0;
//			for(int j=mid+1;j<=end;j++) {
//				if(fence[j]>=minHeight) {
//					sum+= minHeight*1;
//				} else {
//					break;
//				}
//			}
//			for(int j=mid;j>=begin;j--) {
//				if(fence[j]>=minHeight) {
//					sum += minHeight*1;
//				} else {
//					break;
//				}
//			}
//			if(result < sum) {
//				result = sum;
//			}
//		}
		System.out.println("leftAndRight : "+ result);
		return Math.max(Math.max(leftWidth, rightWidth), result);
		
	}
}
