import java.util.Scanner;
import java.util.TreeSet;

public class Nerd3 {
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + noodleCount;
			result = prime * result + problemCount;
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (left == null) {
				if (other.left != null)
					return false;
			} else if (!left.equals(other.left))
				return false;
			if (noodleCount != other.noodleCount)
				return false;
			if (problemCount != other.problemCount)
				return false;
			if (right == null) {
				if (other.right != null)
					return false;
			} else if (!right.equals(other.right))
				return false;
			return true;
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
			
			this.addChild(null, this.root, node);
		}
		
		private void addChild(Node parent, Node current, Node node) {
			if(current==null) {
				this.root= node;
				return;
			}
			if(current.noodleCount<node.noodleCount) {
				if(current.problemCount> node.problemCount) {
					if(current.right==null) {
						current.right=node;
						return;
					} else {
						addChild(current, current.right, node);
						return;
					}
				} else {
					if(current==this.root) {
						this.root=node;
					} else {
						parent.right=node;
					}
					node.right=current.right;
				}
			} else {
				if(current.problemCount> node.problemCount) {
					return;
				} else {
					if(current==this.root) {
						this.root=node;
					} else {
						parent.right=node;
					}
					node.right=current;
					return;
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
		public void inOrder() {
			inOrder(this.root);
		}
		private void inOrder(Node node) {
			if(node==null) {
				return;
			}
			inOrder(node.left);
			System.out.println(node);
			inOrder(node.right);
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
		tree.inOrder();
	}
}
