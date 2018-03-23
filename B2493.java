import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;

public class B2493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		// 높이 / 번째수 
//		LinkedHashMap<Long, Integer> hashMap= new LinkedHashMap<>();
		for(int i=0;i<n;i++) {
			int h = sc.nextInt();
			arr[i]=h;
//			hashMap.put(h, i+1);
			
			if(stack.isEmpty()) {
				stack.add(i);
				sb.append(0+ " ");
			} else if(arr[stack.peek()]>h) {
//				sb.append(hashMap.get(stack.peek()) + " ");
				sb.append((stack.peek()+1) + " ");
				stack.add(i);
			} else if(arr[stack.peek()]<h){
				while(!stack.isEmpty()&& arr[stack.peek()]<h) {
					stack.pop();
				}
				if(!stack.isEmpty())
					sb.append((stack.peek()+1) + " ");
				else {
					sb.append(0 + " ");
				}
				stack.add(i);
			}
		}
		System.out.println(sb.toString());
	}
}
