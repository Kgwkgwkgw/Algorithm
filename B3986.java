import java.util.Scanner;
import java.util.Stack;

public class B3986 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int count=0;
		for(int i=0;i<N;i++) {
			char[] input = sc.nextLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			for(int j=0;j<input.length;j++) {
				if(stack.isEmpty()) {
					stack.add(input[j]);
				} else {
					if(stack.peek()==input[j]) {
						stack.pop();
					} else {
						stack.add(input[j]);
					}
				}
			}
			if(stack.isEmpty()) {
				count++;
			}
		}
		System.out.println(count);
	}
}
