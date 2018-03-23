import java.util.Scanner;
import java.util.Stack;

public class Line5_another {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		boolean isNextMinus=false;
		for(int i=0;i<n;i++) {
			int input =sc.nextInt();
			if(stack.isEmpty()) {
				stack.add(input);
			} else if(stack.size()==1) {
				if(input == stack.peek()) {
					continue;
				}
				isNextMinus = input - stack.peek() > 0 ? true :false;
				stack.add(input);
			} else {
				if(isNextMinus && input-stack.peek() <0) {
					stack.add(input);
					isNextMinus =false;
				} else if(!isNextMinus && input-stack.peek() >0) {
					stack.add(input);
					isNextMinus=true;
				} else {
					continue;
				}
			}
		}
		System.out.println(stack);
		System.out.println(stack.size());
	}
}
