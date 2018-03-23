import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Traversal {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node() {
			
		}
		public Node(int value, Node left, Node right) {
			this.value=value;
			this.left=left;
			this.right=right;
		}
		
	}
	public static class Tree {
		Node root;
		public Tree() {
			
		}
		public Tree(Node node) {
			this.root=node;
		}
		public void setRoot(Node node) {
			this.root = node;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 7;
		ArrayList<Integer> preorderList = new ArrayList<>();
		ArrayList<Integer> inorderList = new ArrayList<>();
		ArrayList<Integer> postorderList = new ArrayList<>();
//		for(int i=0;i<N;i++) {
//			int value = sc.nextInt();
//			preorderList.add(value);
//		}
		preorderList.add(27);
		preorderList.add(16);
		preorderList.add(9);
		preorderList.add(12);
		preorderList.add(54);
		preorderList.add(36);
		preorderList.add(72);
//		for(int i=0;i<N;i++) {
//			int value = sc.nextInt();
//			inorderList.add(value);
//		}
		inorderList.add(9);
		inorderList.add(12);
		inorderList.add(16);
		inorderList.add(27);
		inorderList.add(36);
		inorderList.add(54);
		inorderList.add(72);
		
		postorderList.add(12);
		postorderList.add(9);
		postorderList.add(16);
		postorderList.add(36);
		postorderList.add(72);
		postorderList.add(54);
		postorderList.add(27);
		
		solve(preorderList, inorderList);
		solve2(postorderList, inorderList);
	}
	public static void solve(List<Integer> preorderList, List<Integer> inorderList) {
//		System.out.println("preOrderList : " + preorderList);
//		System.out.println("inOrderList : " + inorderList);
		if(preorderList==null || preorderList.isEmpty()) {
			return;
		}
		int root = preorderList.get(0);
		int rootIndex = inorderList.indexOf(root);
		
		List<Integer> inOrderLeftTree;
		List<Integer> inOrderRightTree;
		List<Integer> preOrderLeftTree;
		List<Integer> preOrderRightTree;
		inOrderLeftTree = inorderList.subList(0, rootIndex);
	
	
		inOrderRightTree = inorderList.subList(rootIndex+1, inorderList.size());
	
		preOrderLeftTree = preorderList.subList(1, rootIndex+1);
	
		preOrderRightTree = preorderList.subList(rootIndex+1, preorderList.size());
	
		solve(preOrderLeftTree, inOrderLeftTree);
		solve(preOrderRightTree, inOrderRightTree);
		System.out.println(root);
	}
	public static void solve2(List<Integer> postOrderList, List<Integer> inOrderList) {
		if(postOrderList==null || postOrderList.isEmpty()) {
			return;
		}
		int root = postOrderList.get(postOrderList.size()-1);
		int rootIndexInOrder = inOrderList.indexOf(root);
		
		List<Integer> leftPostOrderList = postOrderList.subList(0, rootIndexInOrder);
		List<Integer> rightPostOrderList = postOrderList.subList(rootIndexInOrder, postOrderList.size()-1);
		
		List<Integer> leftInOrderList = inOrderList.subList(0, rootIndexInOrder); 
		List<Integer> rightInOrderList = inOrderList.subList(rootIndexInOrder+1, inOrderList.size());
		System.out.println(root);
		solve2(leftPostOrderList, leftInOrderList);
		solve2(rightPostOrderList, rightInOrderList);
	}
}
