import java.util.Scanner;
import java.util.TreeSet;

public class G702 {
	//너드 
	//nerd
	//문제 
	public static class Node implements Comparable<Node>{
		int noodle;
		int problem;
		public Node(int problem, int noodle) {
			this.noodle = noodle;
			this.problem= problem;
		}
		@Override
		public int compareTo(Node o) {
			return this.noodle-o.noodle;
		}
		@Override
		public String toString() {
			return "Node [noodle=" + noodle + ", problem=" + problem + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeSet<Node> treeSet = new TreeSet<>();
		int result=0;
		for(int i=0;i<N;i++) {
			Node insert = new Node(sc.nextInt(), sc.nextInt());
			Node insertAfter = treeSet.higher(insert);
			if(insertAfter==null) {
				treeSet.add(insert);
			} else {
				if(insertAfter.problem<insert.problem) {
					treeSet.add(insert);
					Node insertBefore = treeSet.lower(insert);
					while(insertBefore!=null) {
						if(insertBefore.problem< insert.problem) {
							treeSet.remove(insertBefore);
							insertBefore= treeSet.lower(insert);
						} else {
							break;
						}
					}
				}
			}
			result+= treeSet.size();
		}
		System.out.println(result);
	}
}
