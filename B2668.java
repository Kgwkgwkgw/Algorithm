import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class B2668 {
//	세로 두 줄, 가로로 N개의 칸으로 이루어진 표가 있다. 첫째 줄의 각 칸에는 정수 1, 2, …, N이 차례대로 들어 있고 둘째 줄의 각 칸에는 1이상 N이하인 정수가 들어 있다. 첫째 줄에서 숫자를 적절히 뽑으면, 그 뽑힌 정수들이 이루는 집합과, 뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치한다. 이러한 조건을 만족시키도록 정수들을 뽑되, 최대로 많이 뽑는 방법을 찾는 프로그램을 작성하시오. 예를 들어, N=7인 경우 아래와 같이 표가 주어졌다고 하자.
//	이 경우에는 첫째 줄에서 1, 3, 5를 뽑는 것이 답이다. 첫째 줄의 1, 3, 5밑에는 각각 3, 1, 5가 있으며 두 집합은 일치한다. 이 때 집합의 크기는 3이다. 만약 첫째 줄에서 1과 3을 뽑으면, 이들 바로 밑에는 정수 3과 1이 있으므로 두 집합이 일치한다. 그러나, 이 경우에 뽑힌 정수의 개수는 최대가 아니므로 답이 될수 없다.
	public static int n;
	public static boolean[] visited;
	public static int[][] adj;
	public static boolean isCycle;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		adj = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=1;i<=n;i++) {
			adj[i][sc.nextInt()] = 1;
		}
		dfsAll();
	}
//	public static LinkedList<Integer> initialize() {
//		LinkedList<Integer> result = new LinkedList<>();
//		for(int i=1;i<=n;i++) {
//			if(adj[i][i]>0) {
//				result.add(i);
//				visited[i]=true;
//			}
//		}
//		return result;
//	}
	public static void dfsAll() {
		//난 이렇게 풀었는데, 
		// 머리좋게 푼사람은 visited 를 int로 두고 visited[i]가 2가 되는 걸 출력함.
		// visited 초기화할때도 2는 안초기화하고.
		TreeSet<Integer> dfsResult= new TreeSet<>();
		for(int i=1;i<=n;i++) {
			LinkedList<Integer> temp = new LinkedList<>();
			dfs(i, temp);
			if(temp.pollLast()== i) {
				dfsResult.addAll(temp);
			}
			Arrays.fill(visited, false);
		}
		System.out.println(dfsResult.size());
		Iterator<Integer> iter = dfsResult.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	public static void dfs(int here, LinkedList<Integer> dfsResult) {
		dfsResult.add(here);
		visited[here]=true;
		for(int there=1;there<=n;there++) {
			if(adj[here][there]>0&&!visited[there] ) {
				dfs(there,dfsResult);
			} else if(adj[here][there]>0 && visited[there]) {
				dfsResult.add(there);
			}
		}
	}
}
