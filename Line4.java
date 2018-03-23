import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Line4 {
	public static class Node {
		ArrayList<Integer> adjList = new ArrayList<>();
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		people = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		arr= new Node[people];
		seated= new boolean[people];
		for(int i=0;i<arr.length;i++) {
			arr[i]= new Node();
		}
		for(int i=0;i<k;i++) {
			String[] input = sc.nextLine().split(" ");
			arr[Integer.parseInt(input[0])].adjList.add(Integer.parseInt(input[1]));
		}
		solve(0);
		if(isOk) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
	}
	public static boolean isOk =false;
	public static int people;
	public static Node[] arr;
	public static boolean[] seated;
	public static void solve(int nodeNumber) {
		if(isOk) {
			return;
		}
		if(nodeNumber==people) {
			boolean isAllOk=true;
			System.out.println(Arrays.toString(seated));
			for(int i=0;i<people;i++) {
				if(!seated[i]) {
					isAllOk=false;
					break;
				}
			}
			if(isAllOk) {
				isOk=true;
			} else {
				isOk=false;
			}
			return;
		}
		for(int i=0;i<arr[nodeNumber].adjList.size();i++) {
			int seat = arr[nodeNumber].adjList.get(i);
			seated[seat]=true;
			solve(nodeNumber+1);
			seated[seat]=false;
		}
	}
}
