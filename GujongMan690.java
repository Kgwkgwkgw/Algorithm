import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GujongMan690 {
	public static class Node {
		int x;
		int y;
		int r; 
		ArrayList<Node> children = new ArrayList<>();
		public Node(int x, int y, int r) {
			this.x=x;
			this.y=y;
			this.r=r;
		}
		public int getDepth() {
			int ret =0;
			for(int i=0;i<children.size();i++) {
				ret = Math.max(ret, children.get(i).getDepth()+1);
			}
			return ret; 
		}
		public double getDistance(Node other) {
			return Math.sqrt(Math.pow(this.x- other.x, 2)+Math.pow(this.y-  other.y, 2));
		}
		public boolean isCover(Node other) {
			return this.r-other.r >= this.getDistance(other);
		}
		public boolean isChild(Node parent, ArrayList<Node> arrayList) {
			for(int i=0;i<arrayList.size();i++) {
				if(this.equals(arrayList.get(i)) || parent.equals(arrayList.get(i))) {
					continue;
				}
				else {
					if(parent.isCover(arrayList.get(i)) && arrayList.get(i).isCover(this)) {
						return false;
					}
				}
			}
			return true;
		}
		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", r=" + r + ", children=" + children + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
//			result = prime * result + ((children == null) ? 0 : children.hashCode());
			result = prime * result + r;
			result = prime * result + x;
			result = prime * result + y;
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
//			if (children == null) {
//				if (other.children != null)
//					return false;
//			} else if (!children.equals(other.children))
//				return false;
			if (r != other.r)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	public static class Tree {
		Node root;
		public Tree(Node node) {
			this.root=node;
		}
		public Node makeTree(Node parent, ArrayList<Node> arrayList) {
			for(int i=0;i<arrayList.size();i++) {
				if(parent.equals(arrayList.get(i))) {
					continue;
				}
				if(parent.isCover(arrayList.get(i)) && arrayList.get(i).isChild(parent, arrayList)) {
					parent.children.add(makeTree(arrayList.get(i),arrayList));
				}
			}
//			for(int i=0;i<parent.children.size();i++) {
//				arrayList.remove(parent.children.get(i));
//				makeTree(parent.children.get(i), arrayList);
//			}
			return parent;
		}
		public void makeTree(ArrayList<Node> arrayList) {
			makeTree(this.root, arrayList);
		}
		public static int longest=0;
		public int getMaxDistance() {
			longest=0;
			int heihgt = getMaxDistance(this.root);
			return Math.max(longest, heihgt);
		} 
		//높이를 반환한다. 
		public int getMaxDistance(Node node) {
			ArrayList<Integer> hList =new ArrayList<>();
			for(int i=0;i<node.children.size();i++) {
				hList.add(getMaxDistance(node.children.get(i)));
			}
			if(hList.isEmpty()) 
				return 0;
			Collections.sort(hList);
			if(hList.size()>1) {
				longest = Math.max(longest, hList.get(hList.size()-1)+ hList.get(hList.size()-2)+2 );
			}
			return hList.get(hList.size()-1)+1;
		}
		public Node getParent(Node toFind) {
			return getParet(this.root, toFind);
		}
		public Node getParet(Node parent, Node toFind) {
			for(int i=0;i<parent.children.size();i++) {
				if(parent.children.get(i).equals(toFind)) {
					return parent;
				} else {
					Node node = getParet(parent.children.get(i), toFind);
					if(node!=null)
						return node;
				}
			}
			return null;
		}
//		public void printPreOrder() {
//			printPreOrder(this.root);
//		}
//		public void printPreOrder(Node node) {
//			System.out.println(node);
//			for(int i=0;i<node.children.size();i++) {
//				printPreOrder(node.children.get(i));
//			}
//		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		Tree tree = new Tree(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		ArrayList<Node> nodeList = new ArrayList<>();
		for(int i=1;i<N;i++) {
			Node node = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
			nodeList.add(node);
		}
		tree.makeTree(nodeList);
		System.out.println(tree.getMaxDistance());
		System.out.println("----출력");
		System.out.println(tree.root);
		System.out.println(tree.getParent(new Node(32, 10, 7)));
		
	}
}
