import java.util.NoSuchElementException;
import java.util.Scanner;

public class B5639 {
	public static class Node {
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value=value;
		}
	}
	public static class Tree {
		Node root;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tree tree= new Tree();
		while(true) {
			try {
				int input = Integer.parseInt(sc.nextLine());
				if(tree.root==null) {
					tree.root= new Node(input);
				} else {
					makeBinarySearchTree(tree.root, new Node(input));
				}
			} catch (NoSuchElementException e) {
				postOrder(tree.root);
				break;
			}
			
		}
	}
	public static void postOrder(Node node) {
		if(node.left!=null) {
			postOrder(node.left);
		} 
		if(node.right!=null) {
			postOrder(node.right);
		}
		System.out.println(node.value);
	}
	public static void makeBinarySearchTree(Node parent, Node child) {
		if(parent.value > child.value) {
			if(parent.left==null) {
				parent.left=child;
			} else {
				makeBinarySearchTree(parent.left, child);
			}
		} else if(parent.value < child.value) {
			if(parent.right==null) {
				parent.right=child;
			} else {
				makeBinarySearchTree(parent.right, child);
			}
		}
	}
}
