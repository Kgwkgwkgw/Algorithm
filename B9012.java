import java.util.Scanner;
import java.util.Stack;

public class B9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++) {
			Stack<Character> stack = new Stack<>();
			char[] input = sc.nextLine().toCharArray();
			boolean isVPS=true;
			for(int j=0;j<input.length;j++) {
				if(input[j]=='(') {
					stack.add(input[j]);
				} else {
					if(!stack.isEmpty())
						stack.pop();
					else {
						isVPS=false;
						break;
					}
				}
			}
			if(isVPS && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
