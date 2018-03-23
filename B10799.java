import java.util.Scanner;
import java.util.Stack;

public class B10799 {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().toCharArray();
		int ret=0;
		for(int i=0;i<input.length;i++) {
			if(input[i]=='(') {
				stack.push(input[i]);
			} else {
				//레이져 
				if(input[i-1]=='(' ) {
					stack.pop();
					ret+= stack.size();
				//막대기 끝
				} else if(input[i-1]==')') {
					ret+=1;
					stack.pop();
				}
			}
		}
		System.out.println(ret);
	}
}
