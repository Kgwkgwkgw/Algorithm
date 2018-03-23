import java.util.Scanner;

public class B1991 {
	
	public static class Node {
		char value;
		Node left;
		Node right;
		public Node() {
			
		}
		public Node(char value) {
			this.value= value;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		Node[] nodeList =new Node[N];
		for(int i=0;i<N;i++) {
			nodeList[i]= new Node((char)('A'+i));
		}
		for(int i=0;i<N;i++) {
			String[] inputs= sc.nextLine().split(" ");
			if(!".".equals(inputs[1])) {
				nodeList[inputs[0].charAt(0)-'A'].left= nodeList[inputs[1].charAt(0)-'A']; 
			}
			if(!".".equals(inputs[2])) {
				nodeList[inputs[0].charAt(0)-'A'].right= nodeList[inputs[2].charAt(0)-'A']; 
			}
		}
		preOrder(nodeList[0]);
		System.out.println();
		inOrder(nodeList[0]);
		System.out.println();
		postOrder(nodeList[0]);
		System.out.println();
	}
	public static void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	public static void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	public static void postOrder(Node node) {
		if(node==null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}
	
}
