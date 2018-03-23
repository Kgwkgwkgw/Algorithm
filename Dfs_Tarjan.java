import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Dfs_Tarjan {
	public static ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
	public static int[] discovered;
	public static int vertexCount;
	public static int sccCount;
	public static int[] sccNumber;
	public static Stack<Integer> sccListStack;
	public static ArrayList<LinkedList<Integer>> sccList = new ArrayList<>();
	public static int dfs(int here) {
		int ret=discovered[here]= ++vertexCount;
		sccListStack.push(here);
		for(int i=0;i<adj.get(here).size();i++) {
			int there = adj.get(here).get(i);
			if(discovered[there]==-1) {
				int subTreeBackEdge = dfs(there);
				ret = Math.min(ret, subTreeBackEdge);
			} else if(sccNumber[there]==-1) {
				ret =Math.min(ret, discovered[there]);
			}
		}
		if(ret==discovered[here]) {
			LinkedList<Integer> newSccList = new LinkedList<>();
			while(!sccListStack.isEmpty()) {
				int vertex = sccListStack.pop();
				sccNumber[vertex]= sccCount;
				newSccList.add(vertex);
				if(vertex==here) {
					break;
				}
			}
			sccList.add(newSccList);
			sccCount++;
		}
		discovered[here] =ret;
		return ret;
	}
	public static void tarjan() {
		for(int i=0;i<discovered.length;i++) {
			if(discovered[i]==-1) {
				dfs(i);
			}
		}
		System.out.println(sccList);
	}
	public static void initailize() {
		ArrayList<Integer> vertex0 = new ArrayList<>();
		//vertex1.add(0);
		vertex0.add(1);
		vertex0.add(4);
		ArrayList<Integer> vertex1 = new ArrayList<>();
//		vertex1.add(0);
		vertex1.add(2);
//		vertex2.add(4);
		ArrayList<Integer> vertex2 = new ArrayList<>();
		vertex2.add(3);
//		vertex3.add(0);
		ArrayList<Integer> vertex3= new ArrayList<>();
		vertex3.add(1);
//		vertex3.add(2);
//		vertex3.add(4);
//		vertex3.add(5);
//		vertex4.add(0);
		ArrayList<Integer> vertex4= new ArrayList<>();
		vertex4.add(5);
//		vertex5.add(0);
		ArrayList<Integer> vertex5= new ArrayList<>();
		vertex5.add(4);
		vertex5.add(3);
//		vertex5.add(6);
//		vertex5.add(7);
//		ArrayList<Integer> vertex6= new ArrayList<>();
//		vertex6.add(5);
//		ArrayList<Integer> vertex7= new ArrayList<>();
//		vertex6.add(5);
		adj.add(vertex0);
		adj.add(vertex1);
		adj.add(vertex2);
		adj.add(vertex3);
		adj.add(vertex4);
		adj.add(vertex5);
//		adj.add(vertex6);
//		adj.add(vertex7);
		discovered= new int[adj.size()];
		Arrays.fill(discovered, -1);
		sccNumber= new int[adj.size()];
		Arrays.fill(sccNumber, -1);
		sccListStack= new Stack<>();
	}
	public static void main(String[] args) {
		initailize();
		tarjan();
	}
}
