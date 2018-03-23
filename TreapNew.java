import java.util.Scanner;

public class TreapNew {
	public static class Node {
		long value;
		double priority;
		int size;
		Node left;
		Node right;
		public Node(long value) {
			this.value=value;
			priority=Math.random();
			size=1;
		}
		public void setLeft(Node node) {
			this.left= node;
			calcSize();
		}
		public void setRight(Node node) {
			this.right=node;
			calcSize();
		}
		public void calcSize() {
			size=1;
			if(left!=null) {
				size+=left.size;
			}
			if(right!=null) {
				size+=right.size;
			}
		}
	}
	public static class NodePair {
		Node small;
		Node big;
		public NodePair(Node small, Node big) {
			this.small=small;
			this.big=big;
		}
	}
	public static class Treap{
		Node root;
		public void insert(Node node) {
			this.root = insert(this.root, node);
		}
		public Node insert(Node root, Node node) {
			if(root==null) {
				return node;
			}
			if(root.priority < node.priority) {
				NodePair nodePair = split(root, node.value);
				node.setLeft(nodePair.small);
				node.setRight(nodePair.big);
				return node;
			} else {
				if(root.value > node.value) {
					root.setLeft(insert(root.left, node));
				} else {
					root.setRight(insert(root.right, node));
				}
			}
			return root;
		}
		public NodePair split(Node root, long value) {
			if(root==null) {
				return new NodePair(null,null);
			}
			if(root.value<value) {
				NodePair nodePair = split(root.right, value);
				root.setRight(nodePair.small);
				return new NodePair(root, nodePair.big);
			} else {
				NodePair nodePair = split(root.left, value);
				root.setLeft(nodePair.big);
				return new NodePair(nodePair.small, root);
			}
		}
		public void remove(long value) {
			this.root= remove(this.root, value);
		}
		public Node remove(Node root, long value) {
			if(root==null) {
				return null;
			}
			if(root.value==value) {
				return merge(root.left, root.right);
			} else if (root.value < value) {
				root.setRight(remove(root.right, value));
				return root;
			} else {
				root.setLeft(remove(root.left, value));
				return root;
			}
		}
		public Node merge(Node left, Node right) {
			if(left==null) {
				return right;
			} 
			if(right==null) {
				return left;
			}
			
			if(left.priority< right.priority) {
				right.setLeft(merge(left, right.left));
				return right;
			} else {
				left.setRight(merge(left.right, right));
				return left;
			}
		}
		public Node kth(int kth) {
			return kth(this.root, kth);
		}
		public Node kth(Node node , int kth) {
			if(node==null) {
				return null;
			}
			int leftCount =0;
			if(node.left!=null) {
				leftCount = node.left.size;
			}
			if(leftCount >=kth)
				return kth(node.left, kth);
			else if(leftCount+1 == kth) {
				return node;
			} else {
				return kth(node.right, kth-leftCount-1);
			}
		}
		public int countMoreThanX(long x) {
			return countMoreThanX(this.root, x);
		}
		public int countLessThanX(long x) {
			return countLessThanX(this.root, x);
		}
		public int countLessThanX(Node node, long x) {
			if(node==null) {
				return 0;
			}
			if(node.value<x) {
				return node.left!=null? node.left.size+1+countLessThanX(node.right, x) : 1+ countLessThanX(node.right, x);  
			} else {
				return countLessThanX(node.left, x);
			}
		}
		public int countMoreThanX(Node node, long x) {
			if(node==null) {
				return 0;
			}
			if(node.value == x) {
				if(node.right!=null) {
					return node.right.size;
				} else {
					return 0;
				}
			} else if(node.value< x) {
				return countMoreThanX(node.right, x);
			} else {
				int rightCount =0;
				if(node.right!=null) {
					rightCount+= node.right.size;
				}
				return countMoreThanX(node.left, x)+rightCount+1;
			}
		}
		
	}
	public static void main(String[] args) {
		Treap treap = new Treap();
//		treap.insert(new Node(10));
//		treap.insert(new Node(4));
//		treap.insert(new Node(20));
//		treap.insert(new Node(16));
//		treap.insert(new Node(25));
//		treap.insert(new Node(3));
//		System.out.println(treap.countLessThanX(5)-treap.countLessThanX(3));
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int[] diff = new int[n];
		long[] res =new long[n];
		for(int i=0;i<n;i++) {
			diff[i]= sc.nextInt();
			treap.insert(new Node(i+1));
		}
		for(int i=0;i<n;i++) {
			long value = treap.kth( (n-i)-diff[n-i-1]).value;
			res[n-i-1]= value;
			treap.remove(value);
		}
		for(int i=0;i<n;i++) {
			System.out.print(res[i]+ " ");
		}
	}
}
