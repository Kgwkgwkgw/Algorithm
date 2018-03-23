import java.util.Iterator;
import java.util.LinkedList;

public class GuJongMan_635 {

	public static int[] A = { 1, 4, 2, 1, 4, 3, 1, 6 };
	public static int k = 7;
	public static int n = 20;

//	public static int sum=0;
	static {
		
	}
	public static void main(String[] args) {
//		int count=0;
//		for(int i=0;i<A.length;i++) {
//			count+= solve(i);
//		}
//		System.out.println(count);
//		System.out.println(counter);
		System.out.println(solve2());
	}

	public static int solve(int index) {
		int sum=0;
		int count =0;
		LinkedList<Integer> linkedList = new LinkedList<>();
	
		for(int i=index;i< A.length;i++) {
			sum+=A[i];
			linkedList.add(A[i]);
			System.out.println(linkedList);
			if(sum==k) {
				count++;
			} else if (sum>k) {
				return count;
			}
		}
		return count;
	}
	public static int solve2() {
		int sum=0;
		int count =0;
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		LinkedList<Integer> copyList = new LinkedList<>();
		for(int i=0;i<A.length;i++) {
			copyList.add(A[i]);
		}
		Iterator<Integer> iter = copyList.iterator();
		while(iter.hasNext()) {
			if(sum==k) {
				System.out.println(linkedList);
				count ++;
				sum-=linkedList.removeFirst();
			} else if (sum <k){
				int next = iter.next();
				sum+=next;
				linkedList.add(next);
			} else {
				sum-= linkedList.removeFirst();
			}
		}
		for(int i=0;i<linkedList.size()-1;i++) {
			sum =0;
			sum+=linkedList.get(i);
			for(int j=i+1;j<linkedList.size();j++) {
				sum += linkedList.get(j);
				if(sum==k) {
					count++;
				} else if(sum>k) {
					break;
				}
			}
		}
		return count;
	}
}
