import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Fortress {
	public static class Node {
		int number;
		int x;
		int y;
		int r;
		LinkedList<Node> childList;
		public Node(int number, int x, int y, int r) {
			this.number= number;
			this.x=x;
			this.y=y;
			this.r=r;
			childList = new LinkedList<>();
		}
//		public void setChild(Node child) {
//			this.child = child;
//		}
		public Node addChild(Node node) {
			if(this.isContain(node)) {
				if(childList.size()==0) {
					childList.add(node);
					return this;
				} 
				for(int i=0;i<childList.size();i++) {
					Node child = childList.get(i);
					Node newNode = child.addChild(node);
					if(newNode!=null) {
						childList.remove(child);
						childList.add(newNode);
						return this;
					}
				}
				childList.add(node);
				return this;
			} else if(node.isContain(this)) {
				node.addChild(this);
				return node;
			}
			return null;
			
		}
		public LinkedList<Node> getChildList() {
			return childList;
		}
		public boolean isContain(Node node) {
			double d = getDistance(node); 
			return (r-node.getR()) > d;
			
		}
		public static boolean isContains(Node parent, Node child) {
			double d = getDistances(parent, child); 
			return (parent.getR()-child.getR()) > d;
			
		}
		public static double getDistances(Node parent, Node child) {
			return Math.sqrt( ( parent.x - child.getX() ) * ( parent.x -child.getX() ) + ( parent.y -child.getY() ) * ( parent.y -child.getY()) );
		}
		public double getDistance(Node node) {
			return Math.sqrt( ( this.x - node.getX() ) * ( this.x -node.getX() ) + ( this.y -node.getY() ) * ( this.y -node.getY()) );
		}
		public int getX() {
			return x;
		}
		public int getR() {
			return r;
		}
		public int getY() {
			return y;
		}

		public int getNumber() {
			return number;
		}
		public static void printNode(Node node) {
			if(node==null) {
				return;
			}
			System.out.println(node.number);
			for(int i=0;i<node.getChildList().size();i++) {
				printNode(node.getChildList().get(i));
			}
		}
		public static Node getParent(Node parent,Node current, int num) {
			if(num == current.number) {
				return parent;
			} else {
				for(int i=0;i<current.childList.size();i++) {
					Node node = getParent(current, current.childList.get(i), num);
					if(node!= null) {
						return node;
					}
				}
			}
			return null;
		}
		public static int getHeight(Node node) {
			int ret =0;
			if(node.childList.size()==0) {
				return 0;
			}else {
				for(int i=0;i<node.childList.size();i++) {
					int childHeight = getHeight(node.childList.get(i)) +1;
					ret = Math.max(ret, childHeight);
				}
			}
			return ret;
		}
		public static Node getNodeByNum(Node node, int number) {
			if(node.getNumber()== number) {
				return node;
			 }
			else {
				for(int i=0;i<node.childList.size();i++) {
					Node findNode = getNodeByNum(node.childList.get(i), number);
					if(findNode!=null) {
						return findNode;
					}
				}
			}
			return null;
		}
//		public Node getChild() {
//			return this.child;
//		}
//		public Node makeTree(Node parent, Node node) {
//			if(parent.isContain(node)) {
//				if(parent.getChild()==null) {
//					parent.setChild(node);
//				} else {
//					parent.setChild(makeTree(parent.getChild(), node));
//				}
//				return parent;
//			} else {
//				node.setChild(parent);
//				return node;
//			}
//		}
		public static int getHeight(Node from, Node to) {
			if(from.getNumber()==to.getNumber()) {
				return 0;
			}
			else {
				for(int i=0;i<from.getChildList().size();i++) {
					try{
						int height= getHeight(from.getChildList().get(i), to);
						return height+1;
					} catch( Exception e ) {
						continue;
					}
				}
			}
			throw new RuntimeException("노노찾을수없음...");
		}
		public static int getHeight(Node node, int num) {
			if(node == null) {
				return -9999999;
			}
			if(node.getNumber()==num) {
				return 1;
			} else {
				for(int i=0;i<node.getChildList().size();i++) {
					int ret = getHeight(node.getChildList().get(i), num)+1;
					if(ret>0) {
						return ret;
					}
				}
				return -9999999;
			}
		}
		@Override
		public String toString() {
			return "Node [number=" + number + ", x=" + x + ", y=" + y + ", r=" + r + ", child=" + childList + "]";
		}
		
	}
	public static class Tree {
		Node root;
//		LinkedList<Node> childList;
		public Tree() {
			
		}
		public Tree(Node node) {
			this.root = node;
//			childList= new LinkedList<>();
		}
		public void setRoot(Node node) {
			// TODO Auto-generated method stub
			this.root= node;
		}
		public Node getRoot() {
			return this.root;
		}
		public static ArrayList<Node> sort(ArrayList<Node> nodeList) {
			nodeList.sort(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					// TODO Auto-generated z
					return o2.getR()-o1.getR();
				}
			});
			return nodeList;
		}
		public void makeTree(ArrayList<Node> nodeList) {
			nodeList = sort(nodeList);
			this.root = make(nodeList,0);
		}
		public Node make(ArrayList<Node> nodeList, int index) {
			for(int i=0;i<nodeList.size();i++) {
				if(i==index) {
					continue;
				}
				if(isChild(nodeList, index, i)) {
					nodeList.get(index).getChildList().add(make(nodeList, i));
				}
			}
			return nodeList.get(index);
		}
		public boolean isChild(ArrayList<Node> nodeList, int parent, int child) {
			if(!Node.isContains(nodeList.get(parent),nodeList.get(child))) {
				return false;
			}
			for(int i=0;i<nodeList.size();i++) {
				if(i!=parent && i!=child) {
					if(Node.isContains(nodeList.get(parent), nodeList.get(i)) && Node.isContains(nodeList.get(i), nodeList.get(child))) {
						return false;
					}
				}
			}
			return true;
		}
		public void showTree() {
			for(int i=0;i<root.getChildList().size();i++) {
				System.out.println(i+1+"번째 트리");
				Node node = root.getChildList().get(i);
				Node.printNode(node);
				System.out.println();
				
			}
			for(Node child : root.getChildList()) {
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
//		LinkedList<Tree> treeList = new LinkedList<>();
		Tree tree = new Tree();
		Node node;
		Node root;
		ArrayList<Node> list = new ArrayList<>();
		for(int i=1; i<=n;i++) {
			node = new Node(i, sc.nextInt(),sc.nextInt(),sc.nextInt());
			list.add(node);
//			root = tree.getRoot();
//			if(root==null) {
//				tree.setRoot(node);
//				continue;
//			}
//			System.out.println(node);
//			tree.setRoot(root.addChild(node));
		}
		tree.makeTree(list);
		tree.showTree();
//		Math.max(longest,solve(tree.getRoot()));
//		System.out.println(longest);
		int start =4;
		int end =8;
		//트리에 있는게 나을듯?
		
		Node startNode = Node.getNodeByNum(tree.getRoot(), start);
		Node endNode = Node.getNodeByNum(tree.getRoot(), end);
		Node startParentNode = Node.getParent(null, tree.getRoot(), start);
		Node endParentNode = Node.getParent(null, tree.getRoot(), end);
		
		if(startParentNode==null) {
			System.out.println(Node.getHeight(tree.getRoot(),endNode));
			return;
		}
		if(endParentNode==null) {
			System.out.println(Node.getHeight(tree.getRoot(),startNode));
			return;
		}
		while(startParentNode!= endParentNode && startNode !=endParentNode && endNode != startParentNode  ) {
			int startParentNodeHeight = Node.getHeight(tree.getRoot(),startParentNode);
			int endParentNodeHeight = Node.getHeight(tree.getRoot(),endParentNode);
			if(startParentNodeHeight< endParentNodeHeight) {
				endParentNode = Node.getParent(null, tree.getRoot(), endParentNode.getNumber());
			} else {
				startParentNode = Node.getParent(null, tree.getRoot(), startParentNode.getNumber());
			}
		}
		if(startParentNode== endParentNode)
			System.out.println(Node.getHeight(startParentNode,startNode)+Node.getHeight(endParentNode, endNode));
		else if(startNode == endParentNode) {
			System.out.println("여기");
			System.out.println(Node.getHeight(startNode, endNode));
		} else {
			System.out.println(Node.getHeight(endNode, startNode));
		}
		
		
	}
//	public static int longest =0;
	
//	public static int solve(Node node) {
//		LinkedList<Node> list = node.getChildList();
//		if(list.size()==0) {
//			return 0;
//		}
//		ArrayList<Integer> childHeightList= new ArrayList<>();
//		for(int i=0;i<list.size();i++) {
//			childHeightList.add(solve(list.get(i)));
//		}
//		Collections.sort(childHeightList);
//		System.out.println(childHeightList);
//		System.out.println("________");
//		if(childHeightList.size()>=2) {
//			int leftChildHeight =childHeightList.get(childHeightList.size()-1);
//			int rightchildHeight =childHeightList.get(childHeightList.size()-2);
//			longest= Math.max(longest, leftChildHeight+rightchildHeight+2);
//		}
//		return childHeightList.get(childHeightList.size()-1)+1; 
//	}
}

