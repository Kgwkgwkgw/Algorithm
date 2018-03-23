import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	public static class Node {
		int value;
		char charValue;
		public Node(int value, char charValue) {
			this.value=value;
			this.charValue=charValue;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + charValue;
			result = prime * result + value;
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
			if (charValue != other.charValue)
				return false;
			if (value != other.value)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", charValue=" + charValue + "]";
		}
		
	}
	public static ArrayList<ArrayList<Node>> adj;
	public static void main(String[] args) {
		adj = new ArrayList<>();
		
		ArrayList<Node> aList = new ArrayList<>();
		aList.add(new Node(1, 'b'));
		aList.add(new Node(3, 'd'));
		aList.add(new Node(4, 'e'));
		aList.add(new Node(7, 'h'));
		
		ArrayList<Node> bList = new ArrayList<>();
		bList.add(new Node(0,'a'));
		bList.add(new Node(2,'c'));
		
		ArrayList<Node> cList = new ArrayList<>();
		cList.add(new Node(1,'b'));
		cList.add(new Node(5,'f'));
		cList.add(new Node(6,'g'));
		
		ArrayList<Node> dList = new ArrayList<>();
		dList.add(new Node(0, 'a'));
		dList.add(new Node(1, 'b'));
		dList.add(new Node(6, 'g'));
		
		ArrayList<Node> eList = new ArrayList<>();
		eList.add(new Node(0, 'a'));
		eList.add(new Node(5, 'f'));
		
		ArrayList<Node> fList = new ArrayList<>();
		fList.add(new Node(2,'c'));
		fList.add(new Node(4,'e'));
		
		ArrayList<Node> gList = new ArrayList<>();
		gList.add(new Node(2,'c'));
		gList.add(new Node(8,'i'));
		
		ArrayList<Node> hList = new ArrayList<>();
		hList.add(new Node(0,'a'));
		
		ArrayList<Node> iList = new ArrayList<>();
		iList .add(new Node(6,'g'));
		
		adj.add(aList);
		adj.add(bList);
		adj.add(cList);
		adj.add(dList);
		adj.add(eList);
		adj.add(fList);
		adj.add(gList);
		adj.add(hList);
		adj.add(iList);
		discovered = new boolean[adj.size()];
		
		bfs(0,'a');
		System.out.println(order);
	}
	public static Queue<Node> queue= new LinkedList<>();
	public static boolean[] discovered;
	public static LinkedList<Node> order = new LinkedList<>();
	public static void bfs(int start, char startChar) {
		Node startNode = new Node(start, startChar);
		queue.add(startNode);
		discovered[startNode.value] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			order.add(node);
			
			for(int i=0;i<adj.get(node.value).size();i++) {
				Node there = adj.get(node.value).get(i);
				if(!discovered[there.value]) {
					queue.add(there);
					discovered[there.value]=true;
				}
			}
		}
		
	}
}

