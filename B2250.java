import java.util.Scanner;

public class B2250 {
	public static class Node {
		int col;
		int left;
		int right;
		public Node() {
			
		}
		@Override
		public String toString() {
			return "Node [col=" + col + "]";
		}
		
	}
	public static class Pair {
		int min;
		int max;
		public Pair(int min, int max) {
			this.min=min;
			this.max=max;
		}
		@Override
		public String toString() {
			return "Pair [min=" + min + ", max=" + max + "]";
		}
		
	}
	public static int root=0;
	public static boolean[] visited;
	public static Node[] nodeList;
	//인덱스는 뎁스다.
	public static Pair[] pairList;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine().trim());
		nodeList = new Node[N+1];
		visited = new boolean[N+1];
		pairList= new Pair[N];
		for(int i=0;i<pairList.length;i++) {
			pairList[i]= new Pair(N+1,1-1);
		}
		
		for(int i=1;i<nodeList.length;i++) {
			nodeList[i]= new Node();
		}
		
		for(int i=0;i<N;i++) {
			String[] inputs = sc.nextLine().split(" ");
			int current = Integer.parseInt(inputs[0]);
			int left = Integer.parseInt(inputs[1]);
			int right = Integer.parseInt(inputs[2]);
			
			if(left!=-1) {
				nodeList[current].left = left;
			}
			if(right!=-1) {
				nodeList[current].right = right;
			}
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				findRoot(i);
			}
		}
		inOrder(root);
//		System.out.println(Arrays.toString(pairList));
		traverse(root, 0);
//		System.out.println(Arrays.toString(pairList));
		int maxIndex=1;
		int max=1;
		for(int i=0;i<pairList.length;i++) {
			if(max< pairList[i].max-pairList[i].min+1 ) {
				maxIndex=i+1;
				max=pairList[i].max-pairList[i].min+1;
			}
		}
		System.out.println(maxIndex+ " "+max);
	}
	public static void traverse(int root, int depth) {
		if(pairList[depth].min > nodeList[root].col) {
			pairList[depth].min = nodeList[root].col;
		}
		if(pairList[depth].max < nodeList[root].col) {
			pairList[depth].max = nodeList[root].col;
		}
		
		if(nodeList[root].left!=-1 && nodeList[root].left>0 ) {
			traverse(nodeList[root].left, depth+1);
		}
		if(nodeList[root].right!=-1 && nodeList[root].right>0 ) {
			traverse(nodeList[root].right, depth+1);
		}
	}
	public static int inOrderNumber =1;
	public static void inOrder(int root) {
		if(nodeList[root].left!=-1  && nodeList[root].left>0 ) {
			inOrder(nodeList[root].left);
		}
		nodeList[root].col = inOrderNumber++;
		if(nodeList[root].right!=-1 && nodeList[root].right>0) {
			inOrder(nodeList[root].right);
		}
	}
	public static void findRoot(int start) {

		visited[start]=true;
		if(!visited[nodeList[start].left] && nodeList[start].left>0) {
			findRoot(nodeList[start].left);
		}
		if(!visited[nodeList[start].right] && nodeList[start].right>0) {
			findRoot(nodeList[start].right);
		}
		root=start;
	}
}
