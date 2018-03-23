import java.util.Scanner;

import javax.management.Query;

public class B10868 {
	public static class RangeTree {
		int size;
		long[] arr;
		public RangeTree(long[] input) {
			this.size= input.length;
			this.arr= new long[this.size*4];
			calcRangeTree(1, 0, this.size-1, input);
		}
		public long calcRangeTree(int segmentNumber, int left, int right, long[] input) {
			if(left==right) {
				arr[segmentNumber]= input[left];
				return arr[segmentNumber];
			}
			int mid = (left+right)/2;
			long calcRangeTreeLeft = calcRangeTree(segmentNumber*2, left, mid, input);
			long calcRangeTreeRight = calcRangeTree(segmentNumber*2+1, mid+1, right, input);
			arr[segmentNumber]= Math.min(calcRangeTreeRight, calcRangeTreeLeft);
			return arr[segmentNumber];
		}
		public long query(int left, int right) {
			return query(1, left, right, 0, this.size-1);
		}
		private long query(int segmentNumber, int left, int right, int rangeLeft, int rangeRight) {
			if(left> rangeRight || right < rangeLeft) {
				return 1_000_000_001;
			}
			if(left<= rangeLeft && right>= rangeRight) {
				return arr[segmentNumber];
			}
			int mid = (rangeLeft+rangeRight)/2;
			long resLeft = query(segmentNumber*2,left, right, rangeLeft, mid);
			long resRight = query(segmentNumber*2+1, left, right, mid+1, rangeRight);
			return Math.min(resLeft, resRight);
		}
		public void update(int position, long value) {
			update(1, position, 0, this.size-1, value);
		}
		private long update(int segmentNumber, int position, int rangeLeft, int rangeRight, long value) {
			if(position < rangeLeft || position> rangeRight) {
				return arr[segmentNumber];
			}
			if(rangeRight== rangeLeft) {
				arr[segmentNumber]= Math.min(arr[segmentNumber], value);
				return arr[segmentNumber];
			}
			int mid = (rangeLeft+rangeRight)/2;
			long updatedLeft = update(segmentNumber*2, position, rangeLeft, mid,value);
			long updatedRight = update(segmentNumber*2+1, position, mid+1, rangeRight, value);
			
			arr[segmentNumber]= Math.min(updatedLeft, updatedRight);
			return arr[segmentNumber];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] input = new long[N];
		
		for(int i=0;i<N;i++) {
			input[i]= sc.nextInt();
		}
		
		RangeTree rangeTree = new RangeTree(input);
		
		for(int i=0;i<M;i++) {
			System.out.println(rangeTree.query(sc.nextInt()-1, sc.nextInt()-1));
		}
	}
}
