import java.awt.RadialGradientPaint;

public class RangeMinimumQuery {
	public static int MAX = 9999;
	public static class RangeMinimumTree {
		int n;
		int[] rangeMinimum;
		public RangeMinimumTree(int[] input) {
			n=input.length;
			rangeMinimum= new int[n*4];
			calcMinimumTree(input, 0, n-1, 1);
		}
		public int calcMinimumTree(int[] input, int left, int right, int nodeNumber) {
			if(left==right) {
				rangeMinimum[nodeNumber]= input[left];
				return rangeMinimum[nodeNumber];
			}
			int mid = (left+right) /2;
			int rangeMinNumLeft= calcMinimumTree(input, left, mid, nodeNumber*2);
			int rangeMinNumRight= calcMinimumTree(input, mid+1, right, nodeNumber*2+1);
			rangeMinimum[nodeNumber]= Math.min(rangeMinNumLeft, rangeMinNumRight);
			return rangeMinimum[nodeNumber];
		}
		public int query(int left, int right) {
			return query(1, left, right, 0, n-1);
		}
		public int query(int nodeNumber, int left, int right, int nodeLeft, int nodeRight) {
			if(left>nodeRight || right < nodeLeft) {
				return MAX;
			}
			if(left<=nodeLeft&& nodeRight<=right) {
				return rangeMinimum[nodeNumber];
			}
			int mid = (nodeLeft+nodeRight)/2;
			return Math.min(query(2*nodeNumber, left, right, nodeLeft, mid), query(nodeNumber*2+1, left, right, mid+1, nodeRight));
		}
		public void update(int index, int newValue) {
			update(1, index, newValue, 0, n-1);
		}
		public int update(int nodeNumber, int index, int newValue, int nodeLeft, int nodeRight) {
			if(nodeLeft>index || nodeRight<index) {
				return rangeMinimum[nodeNumber];
			}
			if(nodeLeft==nodeRight) {
				rangeMinimum[nodeNumber]= newValue;
				return rangeMinimum[nodeNumber];
			}
			int mid = (nodeLeft+nodeRight)/2;
			rangeMinimum[nodeNumber] =Math.min(update(nodeNumber*2, index, newValue, nodeLeft, mid),update(nodeNumber*2+1, index, newValue, mid+1, nodeRight)); 
			return rangeMinimum[nodeNumber];
		}
	}
	public static void main(String[] args) {
		int[] arr= {1,2,1,2,3,1,2,3,4};
		RangeMinimumTree rangeMinimumTree = new RangeMinimumTree(arr);
		System.out.println(rangeMinimumTree.query(6, 8));
		rangeMinimumTree.update(7, 0);
		System.out.println(rangeMinimumTree.query(6, 8));
	}
}
