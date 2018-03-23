import java.util.Scanner;

public class GuJongMan746 {
	public static class RangeResult {
		int min;
		int max;
		@Override
		public String toString() {
			return "RangeResult [min=" + min + ", max=" + max + "]";
		}
	}
	public static class RangeTree {
		int n;
		RangeResult[] rangeResults;
		public RangeTree(int[] input) {
			this.n=input.length;
			this.rangeResults= new RangeResult[4*n];
			calcRangeResults(input, 1, 0, n-1);
		}
		public RangeResult calcRangeResults(int[] input, int nodeNumber ,int left, int right) {
			if(left==right) {
				RangeResult rangeResult= new RangeResult();
				rangeResult.min= input[left];
				rangeResult.max= input[left];
				rangeResults[nodeNumber]=rangeResult;
				return rangeResult;
			}
			int mid = (left+right)/2;
			RangeResult thisResult = new RangeResult();
			RangeResult leftResult = calcRangeResults(input, nodeNumber*2, left, mid);
			RangeResult rightResult = calcRangeResults(input, nodeNumber*2+1, mid+1, right);
			if(leftResult.min<rightResult.min) {
				thisResult.min=leftResult.min;
			} else {
				thisResult.min=rightResult.min;
			}
			if(leftResult.max<rightResult.max) {
				thisResult.max=rightResult.max;
			} else {
				thisResult.max=leftResult.max;
			}
			rangeResults[nodeNumber]=thisResult;
			return thisResult;
		}
		public int query(int left, int right) {
			RangeResult rangeResult = query(1, left, right, 0, n-1);
			return rangeResult.max-rangeResult.min;
		}
		private RangeResult query(int nodeNumber, int left, int right, int nodeLeft, int nodeRight) {
			if(left>nodeRight || right < nodeLeft) {
				return null;
			}
			if(left<=nodeLeft&& right>=nodeRight) {
				return rangeResults[nodeNumber];
			}
			int mid = (nodeLeft+nodeRight)/2;
			RangeResult thisResult = new RangeResult();
			RangeResult leftResult = query(nodeNumber*2, left, right, nodeLeft, mid);
			RangeResult rightResult = query(nodeNumber*2+1, left, right, mid+1, nodeRight);
			if(leftResult!=null && rightResult!=null) {
				if(leftResult.min<rightResult.min) {
					thisResult.min=leftResult.min;
				} else {
					thisResult.min=rightResult.min;
				}
				if(leftResult.max<rightResult.max) {
					thisResult.max=rightResult.max;
				} else {
					thisResult.max=leftResult.max;
				}
			} else if(rightResult==null) {
				thisResult.min=leftResult.min;
				thisResult.max=leftResult.max;
			} else {
				thisResult.min=rightResult.min;
				thisResult.max=rightResult.max;
			}
			return thisResult;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] firstInput = sc.nextLine().split(" ");
		int n = Integer.parseInt(firstInput[0]);
		int[] input = new int[n];
		int Q = Integer.parseInt(firstInput[1]);

		String[] heights = sc.nextLine().split(" ");
		
		for(int i=0;i<n;i++) {
			input[i]= Integer.parseInt(heights[i]);
		}
		
		RangeTree rangeTree = new RangeTree(input);
		for(int i=0;i<rangeTree.rangeResults.length;i++) {
			System.out.println(rangeTree.rangeResults[i]);
		}
		for(int i=0;i<Q;i++) {
			String[] inputs = sc.nextLine().split(" ");
			System.out.println(rangeTree.query(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
		}
	}
}
