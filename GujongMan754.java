import java.util.Arrays;

public class GujongMan754 {
	//펜윅트리
	public static class FenwickTree {
		int[] arr;
		public FenwickTree(int[] input) {
			this.arr= new int[input.length+1];
			for(int i=0;i<input.length;i++) {
				update(i, input[i]);
			}
			System.out.println(Arrays.toString(arr));
		}
		public int sum(int index) {
			index++;
			int sum =0;
			while(index>0) {
				sum += arr[index];
				index &= (index-1);
			}
			return sum;
		}
		public void update(int index, int value) {
			index++;
			while(index<arr.length) {
				this.arr[index]+=value;
				index += (index&(-index));
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		FenwickTree fenwickTree = new FenwickTree(arr);
		System.out.println(fenwickTree.sum(0));
		System.out.println(fenwickTree.sum(1));
		System.out.println(fenwickTree.sum(2));
		System.out.println(fenwickTree.sum(3));
		System.out.println(fenwickTree.sum(4));
	}
}
