import java.util.LinkedList;

public class Treap {
	public static class Node{
		int key;
		double priority;
		Node left;
		Node right;
		int size;
		public Node(int key) {
			this.key=key;
			priority=Math.random();
			size=1;
		}
		public Node(int key, double priority) {
			this.key=key;
			this.priority=priority;
			size=1;
		}
		public void calcSize() {
			int size=0;
			if(left!=null) {
				size+=left.size;
			}
			if(right!=null) {
				size+=right.size;
			}
			this.size=size;
		}
		@Override
		public String toString() {
			return "Node [key=" + key + ", priority=" + priority + ", left=" + left + ", right=" + right + ", size="
					+ size + "]";
		}
		
	}
	Node root;
	public Treap() {
		
	}
	
	public void addChild(Node node) {
		if(this.root==null) {
			this.root=node;
			return;
		}
		addChild(null, this.root, node);
	}
	
	private void addChild(Node parent, Node current, Node node) {
		if(current.priority>=node.priority) {
			if(current.key> node.key) {
				if(current.left==null) {
					current.left=node;
				} else {
					addChild(current, current.left, node);
				}
			} else {
				if(current.right==null) {
					current.right=node;
				} else {
					addChild(current, current.right, node);
				}
			}
		} else {
//			System.out.println("split 호출전 current : "+current);
//			System.out.println("split 호출전 node: "+node);
//			System.out.println("---------------");
			split(current, node);
			
			if(parent ==null && current== this.root) {
				this.root=node;
				System.out.println(this.root);
				this.preOrder();
			}else {
				if(parent.left==current) {
					parent.left=node;
				} else {
					parent.right=node;
				}
			}
			
//			System.out.println("split 호출후 parent : "+current);
//			System.out.println("split 호출후 node: "+node);
//			System.out.println("---------------");
		}
	}
	public void split(Node toSplit, Node toAdd) {
		if(toSplit.key<toAdd.key) {
			toAdd.left = toSplit;
			Node toReInsert = toSplit.right;
			toSplit.right=null;
			addAllChild(toAdd,toReInsert);
		} else {
			toAdd.right = toSplit;
			Node toReInsert = toSplit.left;
			toSplit.left=null;
			addAllChild(toAdd, toReInsert);
			toSplit.left=null;
		}
//		System.out.println("split 호출후 함수안에서. parent : "+toSplit);
//		System.out.println("split 호출후 함수안에서..node: "+toAdd);
//		System.out.println("---------------");
	}
	public void addAllChild(Node parent, Node node) {
		if(node==null) {
			return;
		}
		addAllChild(parent, node.left);
		node.left=null;
		System.out.println(node.key);
		addChild(null, parent, node);
		addAllChild(parent, node.right);
		node.right=null;
		return;
		
	}
	public void inOrder() {
		inOrder(this.root);
	}
	public void inOrder(Node node) {
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.key);
		inOrder(node.right);
	}
	public void preOrder() {
		preOrder(this.root);
	}
	public void preOrder(Node node) {
		if(node==null) {
			return;
		}
		System.out.println(node.key);
		inOrder(node.left);
		inOrder(node.right);
	}
	
	public static void main(String[] args) {
		Treap treap = new Treap();
		treap.addChild(new Node(1,1));
		treap.addChild(new Node(2,2));
		treap.addChild(new Node(3,4));
		treap.addChild(new Node(5,3));
		System.out.println(treap.root);
		treap.addChild(new Node(6,9));
		treap.addChild(new Node(7,8));
		treap.inOrder();
	}
}
 