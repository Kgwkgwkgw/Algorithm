import java.util.ArrayList;
import java.util.Arrays;

public class BreakPoint {
	public static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		adjList= new ArrayList[8];
		discovered= new int[8];
		Arrays.fill(discovered, -1);
		isBreakPoint= new boolean[8];
		for(int i=0;i<adjList.length;i++) {
			adjList[i]= new ArrayList<>();
		}
		adjList[0].add(1);
		
		adjList[1].add(0);
		adjList[1].add(2);
		adjList[1].add(3);
		
		adjList[2].add(3);
		adjList[2].add(1);
		adjList[2].add(5);
		
		adjList[3].add(1);
		adjList[3].add(2);
		adjList[3].add(4);
		adjList[3].add(5);
		
		adjList[4].add(3);
		
		adjList[5].add(3);
		adjList[5].add(2);
		adjList[5].add(6);
		adjList[5].add(7);
		
		adjList[6].add(5);
		
		adjList[7].add(5);
		findBreakPoint(3,true);
		System.out.println(Arrays.toString(isBreakPoint));
	}
	public static int[] discovered;
	public static int vertexCounter;
	public static boolean[] isBreakPoint;
	public static int findBreakPoint(int here, boolean isRoot) {
		discovered[here]= vertexCounter++;
		int ret = discovered[here];
		int children=0;
		
		for(int i=0;i<adjList[here].size();i++) {
			int there = adjList[here].get(i);
			if(discovered[there]==-1) {
				children++;
				int thereMinResult = findBreakPoint(there, false);
				if(!isRoot && thereMinResult >= discovered[here]) { 
					isBreakPoint[here]=true;
				}
				ret = Math.min(ret, thereMinResult);
			} else {
				ret = Math.min(ret, discovered[there]);
			}
		}
		if(isRoot) {
			isBreakPoint[here] = children>=2;
		}
		return ret;
	}
}
