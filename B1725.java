import java.util.Scanner;

public class B1725 {
	//히스토그램
	public static int[] histogram;
	public static int max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		histogram = new int[N];
		for(int i=0;i<N;i++) {
			histogram[i]=sc.nextInt();
		}
		System.out.println(solve(0,histogram.length-1));
		
	}
	public static int solve(int start, int end) {
//		System.out.println("무한 츠크요미, start : " + start + " end : "+end);
		if(end-start==0) {
			return histogram[start];
		}
		int mid = (start+end)/2;
		int max = solve(start, mid);
		
		max = Math.max(max, solve(mid+1, end));
		int leftIndex = mid;
		int rightIndex= mid+1;
		int minHeight = Math.min(histogram[leftIndex], histogram[rightIndex]);
		max= Math.max(max, minHeight*2);

		while(leftIndex-1>=start && rightIndex+1<=end) {
			if(histogram[leftIndex-1] > histogram[rightIndex+1]) {
				minHeight = Math.min(histogram[leftIndex-1], minHeight);
				max= Math.max(max, minHeight* (rightIndex+1- (leftIndex-1)));
				leftIndex--;
			} else {
				minHeight = Math.min(histogram[rightIndex+1], minHeight);
				max= Math.max(max, minHeight* (rightIndex+2-(leftIndex)));
				rightIndex++;
			}
		}
		while(leftIndex-1>=start) {
			minHeight = Math.min(histogram[leftIndex-1], minHeight);
			max= Math.max(max, minHeight* (rightIndex +1- (leftIndex-1)));
			leftIndex--;
		}
		while(rightIndex+1<=end) {
			minHeight = Math.min(histogram[rightIndex+1], minHeight);
			max= Math.max(max, minHeight* (rightIndex+2-(leftIndex)));
			rightIndex++;
		}
		return max;
	}
	
}
