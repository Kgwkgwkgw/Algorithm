import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class JongMan718 {
	public static int[] arr = {0, 1,1, 2,3};
	public static int[] n = new int[arr.length];
	public static int[] answer = new int[arr.length];
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		
		for(int i=0;i<arr.length;i++) {
			set.add(i+1);
		}
		LinkedList<Integer> list = new LinkedList<>();
		int i=arr.length-1;
		while(list.size()<arr.length) {
			int k = arr[i];
			Iterator<Integer> iter = set.descendingIterator();
			int next=-1;
			while(k>=0) {
				next= iter.next();
				k--;
			} 
			list.addFirst(next);
			set.remove(next);
			i--;
		}
		System.out.println(list);
	}
	//내가 첨에푼건데 너무느리다.
//	public static void main(String[] args) {
//		 for(int i=arr.length-1;i>-1;i--) {
//			 int index = i-arr[i];
//			 while(n[index]!=0 &&  index< n.length-1) {
//				 index++;
//			 }
//			 n[index]= index+1;
//			 answer[i]=index+1;
//		 }
//		 System.out.println(Arrays.toString(n));
//		 System.out.println(Arrays.toString(answer));
//	}
}
