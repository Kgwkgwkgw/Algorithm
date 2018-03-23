import java.util.Scanner;
import java.util.Stack;

public class B9935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] bomb = sc.nextLine().toCharArray();
		char[] bombReverse= new char[bomb.length];
		for(int i=bomb.length-1;i>=0;i--) {
			bombReverse[bomb.length-i-1]= bomb[i];
		}
		
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<input.length();i++) {
			stack.add(input.charAt(i));
			if(stack.peek()==bombReverse[0]&& stack.size()>=bombReverse.length) {
				boolean isBomb = true;
				for(int j=0;j<bombReverse.length;j++) {
					if(bombReverse[j]!= stack.get(stack.size()-1-j)) {
						isBomb= false;
					}
				}
				if(isBomb) {
					for(int j=0;j<bombReverse.length;j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb =new StringBuilder();
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			String result =sb.toString();
			for(int i=result.length()-1;i>=0;i--) {
				System.out.print(result.charAt(i));
			}
		}		
	}
}
