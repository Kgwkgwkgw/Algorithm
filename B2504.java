import java.util.Scanner;
import java.util.Stack;

public class B2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int res=0;
		int tmp=1;
		for(int i=0;i<input.length;i++) {
			if(input[i]=='(') {
				tmp*=2;
				stack.add(input[i]);
			}
			if(input[i]=='[') {
				tmp*=3;
				stack.add(input[i]);
			}
			if(input[i]==']') {
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if(stack.peek()!='[') {
					System.out.println(0);
					return;
				}
				
				if(input[i-1]=='[') {
					res+=tmp;
				}
				stack.pop();
				tmp/=3;
			}
			if(input[i]==')') {
				if(stack.isEmpty()) {
					System.out.println(0);
					return;
				}
				if(stack.peek()!='(') {
					System.out.println(0);
					return;
				}
				if(input[i-1]=='(') {
					res+=tmp;
				}
				stack.pop();
				tmp/=2;
			}
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
			return;
		}
		System.out.println(res);
	}
}