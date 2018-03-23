import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class GuJongMan861 {
	public static ArrayList<Integer>[] adjList= new ArrayList[6];
	public static void main(String[] args) {
		for(int i=0;i<adjList.length;i++) {
			adjList[i]= new ArrayList<>();
		}
		adjList[0].add(1);
		adjList[0].add(4);
//		adjList[1].add(0);
		adjList[1].add(2);
		adjList[2].add(3);
		adjList[3].add(1);
		adjList[4].add(5);
		adjList[5].add(4);
		adjList[5].add(3);
		Arrays.fill(discovered, -1);
		Arrays.fill(vertexToSCID, -1);
		calcStrongCompoentSeparation(0);
		System.out.println(Arrays.toString(vertexToSCID));
	}
	public static int[] discovered= new int[adjList.length];
	public static int vertextCounter =0;
	public static int[] vertexToSCID = new int[adjList.length];
	public static int scidCounter=0;
	public static Stack<Integer> vertexStack = new Stack<>();
	public static int calcStrongCompoentSeparation(int here) {
		discovered[here]=vertextCounter++;
		int ret= discovered[here];
		vertexStack.add(here);
		for(int i=0;i<adjList[here].size();i++) {
			int there = adjList[here].get(i);
			if(discovered[there]==-1) {
				int result = calcStrongCompoentSeparation(there);
				ret= Math.min(ret, result);
			} else if(vertexToSCID[there] == -1 && discovered[there]!=-1) {
				ret= Math.min(ret, discovered[there]);
			}
		}
		if(ret >= discovered[here]) {
			while(true) {
				int pop = vertexStack.pop();
				vertexToSCID[pop]= scidCounter; 
				if(pop==here) {
					break;
				}
			}
			scidCounter++;
		}
		return ret;
	}
}
