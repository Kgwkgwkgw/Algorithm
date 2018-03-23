import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class B2170 {
	public static class Edge implements Comparable<Edge> {
		int prevX;
		@Override
		public String toString() {
			return "Edge [prevX=" + prevX + ", postX=" + postX + "]";
		}
		int postX;
		public Edge(int prevX, int postX) {
			if(prevX>postX) {
				this.prevX=postX;
				this.postX=prevX;
			} else {
				this.prevX=prevX;
				this.postX=postX;
			}
		}
		public Edge(Edge edge) {
			this.postX= edge.postX;
			this.prevX= edge.prevX;
		}
		@Override
		public int compareTo(Edge o) {
			return this.prevX - o.prevX;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + postX;
			result = prime * result + prevX;
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
			Edge other = (Edge) obj;
			if (postX != other.postX)
				return false;
			if (prevX != other.prevX)
				return false;
			return true;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeSet<Edge> treeSet = new TreeSet<>();
		for(int i=0;i<N;i++) {
			treeSet.add(new Edge(sc.nextInt(),sc.nextInt()));
		}
		Iterator<Edge> iter  = treeSet.iterator();
		int length=0;
		Edge toPaste=null;
		while(iter.hasNext()) {
			if(toPaste==null) {
				toPaste = new Edge(iter.next());
//				System.out.println(toPaste);
			} else {
				Edge next = iter.next();
//				System.out.println("toPaste :" +toPaste);
//				System.out.println("next :" +next);
				if(toPaste.postX < next.prevX ) {
					length+= (toPaste.postX-toPaste.prevX);
					toPaste= new Edge(next);
				} else {
					if(toPaste.postX < next.postX)
						toPaste.postX=next.postX;
				}
			}
		}
		length+= (toPaste.postX-toPaste.prevX);
		System.out.println(length);
	}
}
