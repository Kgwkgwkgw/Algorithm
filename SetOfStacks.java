import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {
	public static class StackNode {
		Stack<Integer> stack;
		StackNode next;
		int size; 
		public StackNode () {
			stack = new Stack<>();
		}
	}
	int capicty;
	StackNode head; 
	public SetOfStacks (int capicty) {
		this.capicty= capicty;
		this.head = new StackNode();
	}
	public void push(int input) {
		if(this.head.size== this.capicty) {
			StackNode newHead = new StackNode();
			newHead.next=this.head;
			this.head= newHead;
			
			newHead.stack.push(input);
			newHead.size++;
		} else {
			this.head.stack.push(input);
			this.head.size++;
		}
	}
	public int popup() {
		if(this.head.size==0) {
			if(this.head.next==null) {
				throw new EmptyStackException();
			} else {
				this.head = head.next;
				return popup();
			}
		} else {
			int pop = this.head.stack.pop();
			this.head.size--;
			return pop;
		}
	}
	public static void main(String[] args) {
		
	}
}
