import java.util.LinkedList;
import java.util.List;

public class TravelingSaleMan {
	public static int n =4;
	public static int max =99999;
//	public static int[][] dist = {
//			{
//				0,1,2,3,4
//			},
//			{
//				1,0,2,3,4
//			},
//			{
//				2,2,0,2,1
//			},
//			{
//				3,3,2,0,1
//			},
//			{
//				4,4,1,1,0
//			}
//	};
//	public static int[][] dist = {
//			{
//				0,10,20
//			}
//			,
//			{
//				10,0,19
//			},
//			{
//				20,19,0
//			}
//	};
	public static int[][] dist = {
			{
				0,1,2,3
			},
			{
				1,0,4,6
			},
			{
				2,4,0,5
			},
			{
				3,6,5,0
			}
	};
	
	public static boolean[] visited = new boolean[n];
	public static void main(String[] args) {
		LinkedList list = new LinkedList<Integer>();
		list.add(0);
		visited[0]=true;
		System.out.println(solve(list, 0 ));
	}
	public static int solve(LinkedList<Integer> list, int sum) {
		System.out.println("list " + list);
		System.out.println("sum "  + sum);
		if(list.size()==n) {
			return sum + dist[list.peek()][list.peekLast()];
		}
		int min = max;
		for(int i=0; i< n; i ++ ) {
			if(!visited[i]) {
				visited[i]= true;
				int value = dist[list.peekLast()][i];
				list.add(i);
				int ret = solve(list, sum+ value);
				if(ret < min) {
					min = ret;
				}
				visited[i]= false;
				list.removeLast();
			}
 		}
		return min; 
	}
}
