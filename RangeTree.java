
public class RangeTree {
	int size;
	int[] arr;
	public RangeTree(int[] input) {
		size= input.length;
		arr= new int[size*4];
		init(0,size-1,1,input);
	}
	public int init(int left, int right, int nodeNumber, int[] input) {
		if(left==right) {
			arr[nodeNumber]= input[left];
			return input[left];
		}
		int mid = (left+right)/2;
		int leftSum= init(left,mid,nodeNumber*2,input);
		int rightSum = init(mid+1,right,nodeNumber*2+1,input);
		arr[nodeNumber]= leftSum+rightSum;
		return arr[nodeNumber];
	}
	public int query(int indexLeft, int indexRight) {
		return query(indexLeft, indexRight, 0, size-1, 1);
	}
	private int query(int indexLeft, int indexRight, int nodeLeft, int nodeRight, int nodeNumber) {
		if(indexRight < nodeLeft || indexLeft > nodeRight) {
			return 0;
		}
		if(indexLeft<= nodeLeft && nodeRight<=indexRight) {
			return arr[nodeNumber];
		}
		int mid = (nodeLeft+nodeRight)/2;
		int leftSum = query(indexLeft, indexRight, nodeLeft, mid, nodeNumber*2);
		int rightSum = query(indexLeft, indexRight, mid+1, nodeRight, nodeNumber*2+1);
		return leftSum+rightSum;
	}
	public void update(int index,int value) {
		update(index, 0,size-1, 1, value);
	}
	private int update(int index, int nodeLeft, int nodeRight,  int nodeNumber, int value) {
		if(index< nodeLeft || index> nodeRight) {
			return arr[nodeNumber];
		}
		if(nodeLeft== nodeRight) {
			arr[nodeNumber]= value;
			return arr[nodeNumber];
		}
		int mid= (nodeLeft+nodeRight)/2;
		int resultLeft = update(index, nodeLeft, mid, nodeNumber*2, value);
		int resultRight = update(index, mid+1, nodeRight, nodeNumber*2+1, value);
		arr[nodeNumber]= resultLeft+resultRight;
		return arr[nodeNumber];	
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		RangeTree rangeTree = new RangeTree(arr);
		System.out.println(rangeTree.query(0,3));
		rangeTree.update(4, 10);
		System.out.println(rangeTree.query(0,3));
		
	}
}
