import java.util.LinkedList;
import java.util.Scanner;

public class GuJongMan870 {
	public static class Node{
		int start; 
		int end;
		Node nonOverNext;
		public Node(int start, int end) {
			this.start=start;
			this.end=end;
		}
		public boolean isNotOverWrap(Node other) {
			if(end <= other.start) {
				return true;
			}
			if(start >= other.end) {
				return true;
			}
			return false;
		}
		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + "]";
		}
		public void add(Node nonOverNext) {
			if(this.nonOverNext==null) {
				this.nonOverNext=nonOverNext;
				return;
			}
			if(this.nonOverNext.isNotOverWrap(nonOverNext)) 
				this.nonOverNext.add(nonOverNext);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LinkedList<Node> weekList = new LinkedList<>();
		LinkedList<Node> monthList = new LinkedList<>();
		for(int i=0;i<n;i++) {
			String[] inputs = sc.nextLine().split(" ");
			Node week = new Node(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
			Node month = new Node(Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));
			
			boolean isWeekInsetred= false;
			boolean isMonthInserted= false;
			if(i==0) {
				weekList.add(week);
				monthList.add(month);
			}
			else {
				
				for(int j=0;j<weekList.size();j++) {
					if(weekList.get(j).isNotOverWrap(week) && !isMonthInserted) {
						weekList.get(j).add(week);
						isWeekInsetred=true;
					}
					else if(weekList.get(j).isNotOverWrap(month) && !isWeekInsetred) {
						weekList.get(j).add(month);
						isMonthInserted=true;
					}
				}
				
				if(isWeekInsetred) {
					for(int j=0;j<monthList.size();j++) {
						if(weekList.get(j).isNotOverWrap(month)) {
							monthList.get(j).add(month);
							isMonthInserted=true;
						}
					}
				} else {
					for(int j=0;j<monthList.size();j++) {
						if(weekList.get(j).isNotOverWrap(week)) {
							monthList.get(j).add(week);
							isWeekInsetred=true;
						}
					}
				}
			}
		}
		boolean isPossible= false;
		for(int i=0;i<weekList.size();i++) {
			resultList.clear();
			dfsAll(weekList.get(i));
			if(resultList.size()>=n) {
				System.out.println(resultList);
				isPossible=true;
				break;
			}
		}
		if(!isPossible)
			System.out.println("IMPOSSIBLE");
	}
	public static LinkedList<Node> resultList= new LinkedList<>();
	public static int dfsAll(Node node) {
		if(node==null) {
			return 0;
		}
		resultList.add(node);
		int ret=0;
		ret+= dfsAll(node.nonOverNext)+1;
		return ret;
	}
}
