package javaExam;

public class StackList {
	public class Node{
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data= data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next +  "]";
		}
		
	}
	private Node top;
	private int size;
	
	public StackList() {
		size=0;
	}
	public void push(int data) {
		Node a= new Node(data);
		if(size==0) {
			top= a;
		}
		else {
			a.next= top;
			top= a;
		}
		size++;
	}
	public int pop() {
		int data;
		if(size>0) {
			data= top.data;
			top = top.next;
			size--;
			return data;
		} else {
			return -999;
		}
	}
	@Override
	public String toString() {
		return "StackList [top=" + top + ", size=" + size + "]";
	}
	public static void main(String[] args) {
		StackList stackList = new StackList();
		stackList.push(0);
		System.out.println(stackList);
		System.out.println(stackList.pop());
		
		stackList.push(2);
		stackList.push(1);
		stackList.push(3);
		System.out.println(stackList.pop());
		System.out.println(stackList.pop());
		System.out.println(stackList.pop());
		stackList.push(5);
		stackList.push(6);
		
//		while(stackList.last!=null) {
//			System.out.println(stackList.pop());		
//		}
	}
}
