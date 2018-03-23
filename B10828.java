import java.util.Arrays;
import java.util.Scanner;

public class B10828 {
	public static class BackjoonStack {
		int[] stack;
		int top;
		public BackjoonStack() {
			this.stack = new int[10_000];
			top=-1;
		}
		public void push(int X) {
			stack[++top]=X;
		}
		public int pop() {
			if(empty()==0)
				return stack[top--];
			return -1;
		}
		public int empty() {
			return top ==-1 ? 1: 0;
		}
		public int size() {
			return top+1;
		}
		public int top() {
			if(empty()==0)
				return stack[top];
			return -1;
		}
	}
	public static void main(String[] args) {
		BackjoonStack backjoonStack =new BackjoonStack();
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		for(int i=0;i<N;i++) {
			String[] inputs= sc.nextLine().split(" ");
			if("push".equals(inputs[0])) {
				backjoonStack.push(Integer.parseInt(inputs[1]));
			} else if("top".equals(inputs[0])) {
				System.out.println(backjoonStack.top());
			} else if("size".equals(inputs[0])) {
				System.out.println(backjoonStack.size());
			} else if("empty".equals(inputs[0])) {
				System.out.println(backjoonStack.empty());
			} else if("pop".equals(inputs[0])) {
				System.out.println(backjoonStack.pop());
			}
		}
	}
}
