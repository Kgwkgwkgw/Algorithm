import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class B1874 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> intputQueue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for(int i=1;i<=n;i++) {
			intputQueue.add(i);
		}
		boolean isPossible=true;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int sequnceNumber = sc.nextInt();
			if(stack.isEmpty()) {
				isPossible= addUntilValue(sequnceNumber, sb, intputQueue, stack);
			// 스택이 비어있지않다. 
			} else {
				if(stack.peek()==sequnceNumber) {
					stack.pop();
					sb.append("-\n");
				} else if (stack.peek()<sequnceNumber) {
					isPossible= addUntilValue(sequnceNumber, sb, intputQueue, stack);
				} else {
					isPossible=false;
				}
			}
			if(!isPossible) {
				break;
			}
		}
		if(isPossible) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
	public static boolean addUntilValue(int sequnceNumber, StringBuilder sb,
			Queue<Integer> intputQueue, Stack<Integer> stack) {
		boolean isPossible= true;
		while(!intputQueue.isEmpty()&& intputQueue.peek()!=sequnceNumber) {
			stack.add(intputQueue.poll());
			sb.append("+\n");
		}
		if(intputQueue.isEmpty()) {
			isPossible=false;
		} else {
			stack.add(intputQueue.poll());
			sb.append("+\n");
			
			stack.pop();
			
			sb.append("-\n");
		}
		return isPossible;
	}
}
