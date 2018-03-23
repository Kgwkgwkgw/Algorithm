import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class B1135 {
	public static class Node {
		ArrayList<Node> childList= new ArrayList<>();
	}
	public static Node[] nodeList;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int person = sc.nextInt();
		Node[] nodeList = new Node[person];
		for(int i=0;i<nodeList.length;i++) {
			nodeList[i]= new Node();
		}
		for(int i=0;i<person;i++) {
			int parentIndex= sc.nextInt();
			if(i==0)
				continue;
			nodeList[parentIndex].childList.add(nodeList[i]);
		}
		System.out.println(solve(nodeList[0]));
	}
	public static int solve(Node node) {
		int[] time = new int[node.childList.size()];
		for(int i=0;i<node.childList.size();i++) {
			time[i]= 1+ solve(node.childList.get(i));
		}
		Arrays.sort(time);
		int ret =0;
		for(int i=0;i<node.childList.size();i++) {
			time[i] += node.childList.size()-i-1;
			ret= Math.max(ret, time[i]);
		}
		return ret;
	}
	
}
