import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1967 {
	public static class Edge {
		int value;
		Node node;
		public Edge(Node node, int value) {
			this.value= value;
			this.node = node;
		}
		@Override
		public String toString() {
			return "Edge [value=" + value + ", node=" + node + "]";
		}
		
	}
	public static class Node {
		ArrayList<Edge> edgeList= new ArrayList<>();
		public Node() {
		}
		@Override
		public String toString() {
			return "Node [edgeList=" + edgeList + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		Node[] nodeList = new Node[n+1];
		for(int i=1;i<nodeList.length;i++) {
			nodeList[i]= new Node();
		}
		for(int i=1;i<n;i++) {
			nodeList[sc.nextInt()].edgeList.add(new Edge (nodeList[sc.nextInt()], sc.nextInt()));
		}
		traverse(nodeList[1]);
		System.out.println(longest);
	}
	public static int longest=0;
	public static int traverse(Node node) {
//		System.out.println(node);
		if(node.edgeList.size()==0) {
			return 0;
		}
		ArrayList<Integer> valueList = new ArrayList<>();
		for(int i=0;i<node.edgeList.size();i++) {
			valueList.add(traverse(node.edgeList.get(i).node)+ node.edgeList.get(i).value);
		}
		Collections.sort(valueList);
		if(valueList.size()>1) {
			longest= Math.max(longest, valueList.get(valueList.size()-1)+valueList.get(valueList.size()-2));
		} else {
			longest= Math.max(longest, valueList.get(0));
		}
		return valueList.get(valueList.size()-1);
	}
}
