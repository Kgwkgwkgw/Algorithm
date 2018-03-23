import java.util.Scanner;

public class TreapNewRe {
	public static class Node {
		double priority;
		int value;
		int size;
		Node left;
		Node right;
		
		@Override
		public String toString() {
			return "Node [priority=" + priority + ", value=" + value + ", size=" + size + ", left=" + left + ", right="
					+ right + "]";
		}
		public Node(int value) {
			this.priority= Math.random();
			this.value=value;
			this.size=1;
		}
		public void setLeft(Node node) {
			this.left=node;
			calcSize();
		}
		public void setRight(Node node) {
			this.right=node;
			calcSize();
		}
		public void calcSize() {
			this.size=1;
			if(this.left!=null) {
				this.size+=this.left.size;
			}
			if(this.right!=null) {
				this.size+=this.right.size;
			}
		}
	}
	public static class NodePair{
		Node small;
		Node big;
	}
	public static class Treap {
		
		@Override
		public String toString() {
			return "Treap [root=" + root + "]";
		}
		Node root;
		public Treap  () {
			
		}
		public void insert(int value) {
			this.root = insert(this.root, new Node(value));
		}
		public Node insert(Node parent, Node toInsert) {
			if(parent ==null) {
				return toInsert;
			}
			if(parent.priority< toInsert.priority) {
				NodePair splited = split(parent, toInsert.value);
				toInsert.setLeft(splited.small);
				toInsert.setRight(splited.big);
				return toInsert;
			} else if(parent.value > toInsert.value){
				parent.setLeft(insert(parent.left, toInsert));
			} else {
				parent.setRight(insert(parent.right, toInsert));
			}
			return parent;
		}
		public NodePair split(Node parent, int value) {
			if(parent==null) {
				return new NodePair();
			}
			NodePair nodePair = new NodePair();
			if(parent.value < value) {
				NodePair nodePairRight = split(parent.right, value);
				parent.setRight(nodePairRight.small);
				nodePair.small=parent;
				nodePair.big = nodePairRight.big;
			} else {
				NodePair nodePairLeft = split(parent.left, value);
				parent.setLeft(nodePairLeft.big);
				nodePair.small=nodePairLeft.small;
				nodePair.big = parent;
			}
			return nodePair;
		}
		public void remove(int value) {
			this.root = remove(this.root, value);
		}
		private Node remove(Node node, int value) {
			if(node==null) {
				return null;
			}
			if(node.value==value) {
				return merge(node.left, node.right);
			} else if(node.value<value) {
				node.setRight(remove(node.right, value));
			} else {
				node.setLeft(remove(node.left, value));
			}
			return node;
		}
		private Node merge(Node left, Node right) {
			if(left==null) {
				return right;
			}
			if(right==null) {
				return left;
			}
			if(left.priority< right.priority) {
				right.setLeft(merge(left,right.left));
				return right;
			} else {
				left.setRight(merge(left.right, right));
				return left;
			}

		}
		public int getKth(int k) {
			return getKth(this.root, k);
		}
		private int getKth(Node node, int k) {
			if(k>node.size) {
				return  -1;
			}
			int leftSize = node.left==null? 0 : node.left.size;
			if(leftSize >= k) {
				return getKth(node.left, k);
			} else if(leftSize+1 == k ) {
				return node.value;
			} else {
				return getKth(node.right, k-leftSize-1);
			}
		}
		public int getCountLessThanValue(int value) {
			return getCountLessThanValue(this.root, value);
		}
		private int getCountLessThanValue(Node node, int value) {
			if(node==null) {
				return 0;
			}
			
			if(node.value>=value) {
				return getCountLessThanValue(node.left,value);
			} else {
				int leftSize =node.left==null? 0:node.left.size;
				return leftSize+1+getCountLessThanValue(node.right, value);
			}
		}
		public int getCountMoreThanValue(int value) {
			return getCountMoreThanValue(this.root, value);
		}
		private int getCountMoreThanValue(Node node, int value) {
			if(node==null) {
				return 0;
			}
			if(node.value<=value) {
				return getCountMoreThanValue(node.right, value);
			} else {
				int leftCount =0;
				int rightCount =0;
				if(node.left!=null) {
					leftCount = getCountMoreThanValue(node.left, value);
				}
				if(node.right!=null) {
					rightCount = node.right.size;
				}
				return leftCount+1+rightCount;
			}
		}
	}
	public static void main(String[] args) {
		Treap treap = new Treap();
		Scanner sc= new Scanner(System.in);
//		

		int ret =0;
//		for(int i=0;i<n;i++) {
//			int input= sc.nextInt();
//			treap.insert(input);
//			int raise =treap.getCountMoreThanValue(input);
//			ret += raise;
//			System.out.println(raise);
//		}
//		System.out.println(ret);
		treap.insert(1);
		treap.insert(2);
		treap.insert(2);
		treap.insert(3);
		treap.insert(3);
		treap.insert(4);
		treap.insert(5);
		treap.insert(4);
		treap.insert(3);
		treap.insert(3);
		treap.insert(8);
		treap.insert(7);
		treap.insert(7);
		System.out.println(treap.root);
		System.out.println(treap.getKth(1));
		System.out.println(treap.getKth(2));
		System.out.println(treap.getKth(3));
		System.out.println(treap.getKth(4));
		System.out.println(treap.getKth(5));
		System.out.println(treap.getKth(6));
		System.out.println();
		System.out.println(treap.getCountMoreThanValue(1));
		System.out.println(treap.getCountMoreThanValue(2));
		System.out.println(treap.getCountMoreThanValue(3));
		System.out.println(treap.getCountMoreThanValue(4));
		System.out.println(treap.getCountMoreThanValue(5));
	}
}
