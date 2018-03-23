import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class B6603 {
	static LinkedList<Integer> list = new LinkedList();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		combination2(new int[5], 0, 5, 3, 0);
//		while(true) {
//			int k = sc.nextInt();
//			if(k==0) {
//				return;
//			}
//			int[] arr = new int[k];
//			for(int i=0;i<k;i++) {
//				arr[i]=sc.nextInt();
//			}
//			
//			combination(arr, 0, 6);
//			System.out.println();
//		}
		
	}
	public static void combination2(int arr[], int index, int n, int r, int target) {
		if(r==0) {
			for(int i=0;i<index;i++) {
				System.out.print(arr[i] +" ");
			}
			System.out.println();
		} else if(target > arr.length-1) {
			return;
		} else {
			arr[index]= target;
			combination2(arr, index+1, n, r-1, target+1);
			combination2(arr, index, n, r, target+1);
		}
	}
	public static void combination(int arr[], int start, int r) {
		if(r==0) {
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()) {
				System.out.print(arr[iter.next()] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<arr.length;i++) {
			list.add(i);
			combination(arr, i+1, r-1);
			list.removeLast();
		}
	}
}
