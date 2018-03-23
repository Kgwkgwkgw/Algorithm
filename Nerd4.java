import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Nerd4 {
	public static class Node implements Comparable<Node> {
		
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
		@Override
		public int compareTo(Node o) {
			return this.noodleCount- o.noodleCount;
		}
	}
	public static class Program {
//		ArrayList<Node> list = new ArrayList<>();
		TreeSet<Node> set = new TreeSet<>();
		public void addChild(Node node) {
			if(set.isEmpty()) {
				set.add(node);
				return;
			}
			Node aLittleBigNode = set.higher(node);
			System.out.println("aLittleBigNode : " +aLittleBigNode);
			System.out.println("node : " +node);
			if(aLittleBigNode==null) {
				Node aLittleSmallNode = set.lower(node);
				while(aLittleSmallNode.problemCount< node.problemCount) {
					set.remove(aLittleSmallNode);
					aLittleSmallNode= set.lower(node);
				}
				set.add(node);
			} else {
				if(aLittleBigNode.problemCount<node.problemCount) {
					set.add(node);
					return;
				} 
			}
			System.out.println(set);
		}
		public int getSize() {
			return set.size();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Program program= new Program();
		LinkedList<Node> list = new LinkedList<>();
		int ret=0;
		for(int i=0;i<n;i++) {
			program.addChild(new Node(sc.nextInt(), sc.nextInt()));
			ret+=program.getSize();
			System.out.println(ret);
			
		}
		System.out.println("답 "+ ret);
		TreeSet<Integer> set= new TreeSet<>();
		set.add(1);
		set.add(2);
		set.add(10);
		Iterator<Integer> iter= set.iterator();
		int k=0;
		while(iter.hasNext()) {
			int next= iter.next();
			System.out.println(next);
		}
//		tree.inOrder();
	}
}
