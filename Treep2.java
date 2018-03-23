import java.util.LinkedList;

public class Treep2 {
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
		public Node(int key, int priority) {
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
	public Treep2() {
		
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
			
			System.out.println("parent : "+current);
			System.out.println("node : "+node);
			LinkedList<Node> list = split(current, node);
			System.out.println("list : "+list);
			System.out.println("-------------");
			node.left=list.get(0);
			node.right=list.get(1);
			if(current==this.root) {
				this.root=node;
			} else {
				if(parent.left==current) {
					parent.left=node;
				} else {
					parent.right=node;
				}
			}
		}
	}
	public LinkedList<Node> split(Node toSplit, Node toAdd) {
		LinkedList<Node> linkedList = new LinkedList<>();
		if(toSplit==null) {
			linkedList.add(null);
			linkedList.add(null);
			return linkedList;
		}
		if(toSplit.key<toAdd.key) {
			LinkedList<Node> list = split(toSplit.right, toAdd);
			toSplit.right=list.get(0);
			linkedList.add(toSplit);
			linkedList.add(list.get(1));
			System.out.println("toSplit : "+ toSplit);
			System.out.println("linkedList : " +linkedList);
			return linkedList;
		} else {
			LinkedList<Node> list = split(toSplit.left, toAdd);
			toSplit.left=list.get(1);
			linkedList.add(list.get(0));
			linkedList.add(toSplit);
			return linkedList;
		}
	}
//	public void addAllChild(Node parent, Node node) {
//		if(node==null) {
//			return;
//		}
//		if(node.left!=null) {
//			addAllChild(parent, node.left);
//		}
//		node.left=null;
//		addChild(parent, node);
//		if(node.right!=null) {
//			addAllChild(parent, node.right);
//		}
//		node.right=null;
//		return;
//		
//	}
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
	public static void main(String[] args) {
		Treep2 treap = new Treep2();
		treap.addChild(new Node(1,1));
		treap.addChild(new Node(2,2));
		treap.addChild(new Node(3,4));
		treap.addChild(new Node(5,2));
		treap.addChild(new Node(6,8));
		treap.inOrder();
	}
}
 