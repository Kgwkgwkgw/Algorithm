import java.util.LinkedList;

public class ConcatLongestIncreasingSubsequence {
//	public static int[] A= {1,9,4};
//	public static int[] B= {3,4,7};
	public static int[] A= {10,20,30,1,2};
	public static int[] B= {10,20,30};
	public static void main(String[] args) {
		System.out.println(solve());
	}
	public static int solve() {
		int max=0;
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<B.length;j++) {
				LinkedList<Integer> aLISFromIndex = getList(A,i);
				LinkedList<Integer> bLISFromIndex = getList(B,j);
				System.out.println("i "+i);
				System.out.println("j "+j);
				System.out.println(aLISFromIndex);
				System.out.println(bLISFromIndex);
				max= Math.max(max, getJoinedLength(aLISFromIndex,bLISFromIndex));
			}
		}
		return max;
	}
	// index부터의 LogestIncreasing Subsequnce를 얻는다.
	public static LinkedList<Integer> getList(int[] arr, int index) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(arr[index]);
		for(int i=index+1; i<arr.length;i++) {
			if(arr[i]> arr[index]) {
				list.add(arr[i]);
			}
		}
		return list;
	}
	public static int getJoinedLength(LinkedList<Integer> aLISFromIndex, LinkedList<Integer> bLISFromIndex) {
		int counter =0;
		while(aLISFromIndex.size()>0 && bLISFromIndex.size()>0) {
			if(aLISFromIndex.peek() > bLISFromIndex.peek()) {
				bLISFromIndex.poll();
			} else if(aLISFromIndex.peek() < bLISFromIndex.peek()) {
				aLISFromIndex.poll();
			} else {
				bLISFromIndex.poll();
				aLISFromIndex.poll();
			}
			counter++;
		}
		while(aLISFromIndex.size()>0) {
			aLISFromIndex.poll();
			counter++;
		}
		while(bLISFromIndex.size()>0) {
			bLISFromIndex.poll();
			counter++;
		}
		return counter;
	}
}
