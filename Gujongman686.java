import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gujongman686 {
	public static int n;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		ArrayList<Integer> preOrderList = new ArrayList<>();
		ArrayList<Integer> inOrderList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			preOrderList.add(sc.nextInt());
		}
		for(int i=0;i<n;i++) {
			inOrderList.add(sc.nextInt());
		}
		solve(preOrderList, inOrderList);
//		solve2(preOrderList,inOrderList);
//		System.out.println(inOrderList);
//		postOrder(root);
	}
	public static void solve(List<Integer> preOrderList, List<Integer>  inOrderList) {
		if(preOrderList.isEmpty()) {
			return;
		}
		int root = preOrderList.get(0);
		int leftCount = inOrderList.indexOf(root);
		int rightCount = preOrderList.size()- leftCount-1;
		
		solve(preOrderList.subList(1, leftCount+1) , inOrderList.subList(0, leftCount));
		solve(preOrderList.subList(leftCount+1, preOrderList.size()) , inOrderList.subList(leftCount+1, inOrderList.size()));
		System.out.println(root);
	}
	public static void solve2(List<Integer> postOrderList, List<Integer>  inOrderList) {
		if(postOrderList.isEmpty()) {
			return;
		}
		int root = postOrderList.get(postOrderList.size()-1);
		int leftCount = inOrderList.indexOf(root);
		
		System.out.println(root);
		solve2(postOrderList.subList(0, leftCount) , inOrderList.subList(0, leftCount));
		solve2(postOrderList.subList(leftCount, postOrderList.size()-1) , inOrderList.subList(leftCount+1, inOrderList.size()));
	}
}
