import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LongestIncreasingSubsequence {
	public static int[] arr = {1,5,2,4,7};
	public static void main(String[] args) {
//		System.out.println(solve(0, new LinkedList<>()));
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(5);
		linkedList.add(2);
		linkedList.add(4);
		linkedList.add(7);
		System.out.println(solve2(linkedList));
	}
	public static int solve(int index, LinkedList<Integer> list) {
		if(index==arr.length) {
			int prev=-1;
			for(int i=0;i<list.size();i++) {
				if(i==0) {
					prev= list.get(i);
				} else {
					if(prev>=list.get(i)) {
						return 0;
					} else {
						prev= list.get(i);
					}
				}
			}
			System.out.println(list);
			return list.size();
		}
		int ret = 0;
		ret= solve(index+1,list );
		list.add(arr[index]);
		ret= Math.max(ret , solve(index+1,list));
		list.removeLast();
		return ret;
	}
	public static int solve2(LinkedList<Integer> list) {
		if(list.isEmpty()) {
			return 0;
		}
		int ret =0;
		for(int i=0;i<list.size();i++) {
			LinkedList<Integer> Lis = new LinkedList<>();
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i)<list.get(j)) {
					Lis.add(list.get(j));
				}
			}
			ret = Math.max(ret, solve2(Lis)+1);
		}
		return ret;
	}
}
