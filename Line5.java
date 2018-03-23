import java.util.Scanner;

public class Line5 {
	public static class Node {
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static class Tree{
		Node root;
	}
	public static int count =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int bookCount = sc.nextInt();
		Tree tree = new Tree();
		tree.root = new Node(sc.nextInt());
		Node prev=tree.root;
		for(int i=1;i<bookCount;i++) {
			int height = sc.nextInt	();
			Node node = new Node(height);
			if(height<prev.value) {
				prev.left=node;
			} else if(height>prev.value){
				prev.right=node;
			} 
			prev= node;
		}
		System.out.println(solve(tree));
	}
	public static int solve(Tree tree) {
		Node node = tree.root;
		boolean hasRight = node.right!=null? true:false;
		Node parent=null;
		int ret =1;
		
		while(node!=null) {
			if(hasRight) {
				while(node!=null) {
					parent = node;
					node = node.right;
				}
				ret++;
				if(parent.left==null) {
					break;
				}
				node = parent;
				hasRight =false;
			} else {
				while(node!=null) {
					parent = node;
					node = node.left;
				}
				ret++;
				if(parent.right==null) {
					break;
				}
				node = parent;
				hasRight =true;
			}
		}
		return ret;
	}
}
