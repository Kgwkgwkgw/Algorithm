import java.util.ArrayList;
import java.util.Scanner;


public class B1068 {
	public static class Node {
		int i;
		ArrayList<Node> childList = new ArrayList<>();
		public Node(int i) {
			this.i =i;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((childList == null) ? 0 : childList.hashCode());
			result = prime * result + i;
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
			if (childList == null) {
				if (other.childList != null)
					return false;
			} else if (!childList.equals(other.childList))
				return false;
			if (i != other.i)
				return false;
			return true;
		}	
	}
	public static int count=0;
	public static Node[] nodeList;
	public static Node toRemove;
	public static int rootIndex;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nodeList= new Node[n];
		for(int i=0;i<nodeList.length;i++) {
			nodeList[i]= new Node(i);
		}
		for(int i=0;i<n;i++) {
			int input =sc.nextInt();
			if(input==-1) {
				rootIndex=i;
				continue;
			}
			nodeList[input].childList.add(nodeList[i]);
		}
		toRemove= nodeList[sc.nextInt()];
		if(toRemove.equals(nodeList[rootIndex])) {
			System.out.println(0);
		} else {
			traverse(nodeList[rootIndex]);
			System.out.println(count);
		}
	}
	public static void traverse(Node node) {
		if(node.childList.size()==0) {
			count++;
			return;
		}
		if(node.childList.get(0).equals(toRemove) && node.childList.size()==1) {
			count++;
			return;
		}
		for(int i=0;i<node.childList.size();i++) {
			if(!node.childList.get(i).equals(toRemove)) {
				traverse(node.childList.get(i));
			}
		}
	}
}
