import java.util.Arrays;
import java.util.Scanner;
// 구간 합 구하기 
// 펜윅트리, 세그먼트 트리 
//어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.
public class B2042_segment {
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
			arr[segmentNumber]= calcRangeTreeRight+ calcRangeTreeLeft;
			return arr[segmentNumber];
		}
		public long query(int left, int right) {
			return query(1, left, right, 0, this.size-1);
		}
		private long query(int segmentNumber, int left, int right, int rangeLeft, int rangeRight) {
			if(left> rangeRight || right < rangeLeft) {
				return 0;
			}
			if(left<= rangeLeft && right>= rangeRight) {
				return arr[segmentNumber];
			}
			int mid = (rangeLeft+rangeRight)/2;
			long resLeft = query(segmentNumber*2,left, right, rangeLeft, mid);
			long resRight = query(segmentNumber*2+1, left, right, mid+1, rangeRight);
			return resLeft+resRight;
		}
		public void update(int position, long value) {
			update(1, position, 0, this.size-1, value);
		}
		private long update(int segmentNumber, int position, int rangeLeft, int rangeRight, long value) {
			if(position < rangeLeft || position> rangeRight) {
				return arr[segmentNumber];
			}
			if(rangeRight== rangeLeft) {
				arr[segmentNumber]+= value;
				return arr[segmentNumber];
			}
			int mid = (rangeLeft+rangeRight)/2;
			long updatedLeft = update(segmentNumber*2, position, rangeLeft, mid,value);
			long updatedRight = update(segmentNumber*2+1, position, mid+1, rangeRight, value);
			
			arr[segmentNumber]= updatedLeft+ updatedRight;
			return arr[segmentNumber];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		// N개의 수
		int N= Integer.parseInt(inputs[0]);
		//변경 횟수
		int M = Integer.parseInt(inputs[1]);
		//구간의합 구하는 수 
		int K = Integer.parseInt(inputs[2]);
		long[] input = new long[N];
		for(int i=0;i<N;i++) {
			input[i]= Long.parseLong(sc.nextLine());
		}
		RangeTree rangeTree = new RangeTree(input);
//		System.out.println(Arrays.toString(rangeTree.arr));
		for(int i=0;i<M+K;i++) {
			String[] inputForPrint = sc.nextLine().split(" ");
			int a = Integer.parseInt(inputForPrint[0]);
			int b = Integer.parseInt(inputForPrint[1]);
			long c= Long.parseLong(inputForPrint[2]);
			// 변경 
			if(a==1) {
				long diff = c-input[b-1];
				rangeTree.update(b-1, diff);
				input[b-1]=c;
//				System.out.println("변경 : ");
//				System.out.println(Arrays.toString(rangeTree.arr));
			// 출력 
			} else if (a==2) {
				System.out.println( rangeTree.query(b-1, (int)c-1));
			}
		}
	}
}
