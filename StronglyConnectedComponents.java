import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnectedComponents {
	public static ArrayList<Integer>[] adjList;
	public static int[] sccId;
	public static int[] discovered;
	public static int sscIdSerial;
	public static int vertexSerial;
	public static void main(String[] args) {
		int n= 4; 
		adjList= new ArrayList[n];
		sccId= new int[n];
		discovered= new int[n];
		Arrays.fill(discovered, -1);
		Arrays.fill(sccId, -1);
		
		for(int i=0;i<n;i++) {
			adjList[i]= new ArrayList<>();
		}
		adjList[0].add(1);
		
		adjList[1].add(2);
		adjList[1].add(3);
		
		adjList[3].add(0);
		calcStronglyConnectedComponents(0);
		System.out.println(Arrays.toString(sccId));
	}
	public static Stack<Integer> stack= new Stack<>();
	public static int calcStronglyConnectedComponents(int here) {
		discovered[here] = vertexSerial++;
		int ret= discovered[here];
		stack.add(here);
		
		for(int i=0;i<adjList[here].size();i++) {
			int there = adjList[here].get(i);
			if(discovered[there]==-1) {
				ret = Math.min(ret, calcStronglyConnectedComponents(there));
			} else if(discovered[there]!=-1 && sccId[there]==-1) {
				ret = Math.min(ret, discovered[there]);
			}
		}
		if(ret == discovered[here]) {
			while(true) {
				int pop = stack.pop();
				sccId[pop]=sscIdSerial;
				if(pop== here) {
					break;
				}
			}
			sscIdSerial++;
		}
		return ret;
	}
}
