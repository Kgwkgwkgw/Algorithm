import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class B2910 {
	public static class Node implements Comparable<Node> {
		int frequency;
		int order;
		public Node(int frequency, int order) {
			this.frequency=frequency;
			this.order=order;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + frequency;
			result = prime * result + order;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Node other = (Node) obj;
			if (frequency != other.frequency)
				return false;
			if (order != other.order)
				return false;
			return true;
		}

		@Override
		public int compareTo(Node o) {
			if(this.frequency != o.frequency) {
				return o.frequency-this.frequency;
			}
			return this.order-o.order;	

		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		HashMap<Integer, Integer> countHashMap = new HashMap<>();
		LinkedHashSet<Integer> linkedHashSet= new LinkedHashSet<>();
		
		for(int i=0;i<n;i++) {
			int next = sc.nextInt();
			linkedHashSet.add(next);
			if(countHashMap.containsKey(next)) {
				countHashMap.put(next, countHashMap.get(next)+1);
			} else {
				countHashMap.put(next, 1);
			}
		}
		
		//트리맵 만들기 
		TreeMap<Node, Integer> treeMap = new TreeMap();
		Iterator<Integer> iter =linkedHashSet.iterator();
		int order=0;
		while(iter.hasNext()) {
			int value = iter.next();
			int frequency= countHashMap.get(value);
			Node node = new Node(frequency, order++);
			try {
				treeMap.put(node, value);
			} catch (Exception e) {
				System.out.println(0);
				return;
			}
		}
		Set<Node> keySet = treeMap.keySet();
		Iterator<Node> treeKeyIter = keySet.iterator();
		while(treeKeyIter.hasNext()) {
			Node key = treeKeyIter.next();
			int value = treeMap.get(key);
			for(int i=0;i<key.frequency;i++) {
				System.out.print(value+ " ");
			}
		}
//		System.out.println();
	}
}
