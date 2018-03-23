import java.util.Arrays;
import java.util.Stack;

public class Permutation {
	public static boolean[] visited= new boolean[6];
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5,6 };
		// permutaion(arr, 0, 4);
		// pick(4, new Stack<Integer>(), 3);
//		combination(arr, new Stack<Integer>(), 3);
		permutaion(3,new Stack<>(),3);
	}

	public static void permutaion(int[] arr, int depth, int k) {
		if (depth == k) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = depth; i < arr.length; i++) {
			swap(arr, depth, i);
			permutaion(arr, depth + 1, k);
			swap(arr, depth, i);
		}
	}
	
	public static void permutaion(int n, Stack<Integer> stack, int k) {
		 if(k==0) {
			 System.out.println(stack);
		 }
		 
		for(int i=1;i<=n; i++) {
			if(!visited[i]) {
				visited[i]=true;
				stack.add(i);
				permutaion(n, stack, k-1);
				stack.pop();
				visited[i]=false;
			}
		}
	}

//	public static void combination(int n, Stack<Integer> stack, int toPick) {
//		if (toPick == 0) {
//			System.out.println(stack);
//			return;
//		}
//		int toInsert;
//		if (stack.isEmpty()) {
//			toInsert = 1;
//		} else {
//			toInsert = stack.peek() + 1;
//		}
//		for (int i = toInsert; i <= n; i++) {
//			stack.add(i);
//			combination(n, stack, toPick - 1);
//			stack.pop();
//		}
//
//	}
	public static void combination(int n, Stack<Integer> stack, int toPick) {
		if(toPick==0) {
			System.out.println(stack);
			return;
		}
		int insertStart;
		if(stack.isEmpty()) {
			insertStart=1;
		} else {
			insertStart=stack.peek()+1;
		}
		for(int i=insertStart; i<=n; i++) {
			stack.add(i);
			combination(n, stack, toPick-1);
			stack.pop();
		}
	}

	public static void combination(int[] arr, Stack<Integer> stack, int toPick) {
		if (toPick == 0) {
			for (int i : stack) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		int toInsert;
		if (stack.isEmpty()) {
			toInsert = 0;
		} else {
			toInsert = stack.peek() + 1;
		}
		for (int i = toInsert; i < arr.length; i++) {
			stack.add(i);
			combination(arr, stack, toPick - 1);
			stack.pop();
		}

	}

	public static void swap(int[] arr, int swapping, int swapped) {
		int tmp = arr[swapping];
		arr[swapping] = arr[swapped];
		arr[swapped] = tmp;
	}
}
