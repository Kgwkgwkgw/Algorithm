package javaExam;

import java.util.Arrays;

public class StackArray {
	private int[] stack;
	private int top;
	private int size;
	public StackArray(int n) {
		stack = new int[n];
		top = -1;
		size = 0;
	}
	public void push(int a) {
		if(isFull()) {
			System.out.println("꽉찼수다..");
		} else {
			top = (++top)%(stack.length);
			stack[top]=a;
			size++;
		}
	}
	public int pop() {
		int tmp; 
		if(isEmpty()) {
			System.out.println("비었쑤다...");
			return -999999999;
		} else {
			tmp = stack[top];
			stack[top]=0;
			top--;
			if(top<0) {
				top = stack.length-1;
			}
			size--;
			return tmp;
		}
	}
	public boolean isFull() {
		return size==stack.length;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public static void main(String[] args) {
		StackArray stackArray = new StackArray(5);
		for(int i=0;i<5;i++) {
			stackArray.push(i);
		}
		for(int i=0;i<5;i++) {
			System.out.println(stackArray.pop());
		}
		System.out.println(stackArray);
		
		for(int i=5;i<10;i++) {
			stackArray.push(i);
		}
		for(int i=0;i<5;i++) {
			System.out.println(stackArray.pop());
		}
		System.out.println(stackArray);
	}
	@Override
	public String toString() {
		return "StackArray [stack=" + Arrays.toString(stack) + ", top=" + top + ", size=" + size + "]";
	}
}
