import java.util.Scanner;

import javax.swing.tree.TreeNode;

public class Nerd2 {
	public static class Node {
		int noodleCount;
		int problemCount;
		Node left;
		Node right;
		public Node() {
			
		}
		public Node(int noodleCount, int problemCount) {
			this.noodleCount = noodleCount;
			this.problemCount = problemCount;
		}
		@Override
		public String toString() {
			return "Node [noodleCount=" + noodleCount + ", problemCount=" + problemCount + ", left=" + left + ", right="
					+ right + "]";
		}
	}
	public static class Tree {
		private Node root;
		public Node getRoot() {
			return this.root;
		}
		public void setRoot(Node node) {
			this.root= node;
		}
		public void addChild(Node node) {
			this.addChild(this.root, node);
		}
		private void rearrange(Node parent, Node node) {
			if(node ==null) {
				return;
			}
//			System.out.println("parent :" +parent);
//			System.out.println("node : "+node);
//			rearrange(parent, node.left);
			node.left=null;
			addChild(parent, node);
			rearrange(parent, node.right);
			node.right=null;
			
		}
		private void addChild(Node parent, Node node) {
			if(parent==null) {
				this.root= node;
				return;
			}
			if(parent.noodleCount> node.noodleCount && parent.problemCount> node.problemCount) {
				if(parent.left==null) {
					parent.left= node;
				} else {
					addChild(parent.left, node);
				}
			} else if (parent.noodleCount < node.noodleCount && parent.problemCount < node.problemCount) {
				if(parent == this.root) {
					this.root = node;
				}
				rearrange(node, parent);
				return;
			} else {
				if(parent.right==null) {
					parent.right= node;
				} else {
					addChild(parent.right, node);
				}
			}
		}
		public int getProbablityPeople() {
			
			return getProbablityPeople(this.root);
		}
		//해당노드에서부터 가능한사람을 찾음.
		private int getProbablityPeople(Node node) {
			if(node==null) {
				return 0;
			}
			return 1 + getProbablityPeople(node.right);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Tree tree = new Tree();
		int ret =0;
		for(int i=0;i<n;i++) {
			tree.addChild(new Node(sc.nextInt(), sc.nextInt()));
			ret+=tree.getProbablityPeople();
			System.out.println(ret);
		}
		System.out.println("답 "+ ret);
	}
}
