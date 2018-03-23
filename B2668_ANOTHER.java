import java.util.Scanner;

public class B2668_ANOTHER {
	public static int n;
	public static int[] visited;
	public static int[] adj;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		adj = new int[n+1];
		visited = new int[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = sc.nextInt();
		}
		dfsAll();
	}
	public static void init() {
		for(int i=0;i<visited.length;i++) {
			if(visited[i]<2) {
				visited[i]=0;
			}
		}
	}
	public static void dfsAll() {
		//난 이렇게 풀었는데, 
		// 머리좋게 푼사람은 visited 를 int로 두고 visited[i]가 2가 되는 걸 출력함.
		// visited 초기화할때도 2는 안초기화하고.
		for(int i=1;i<=n;i++) {
			dfs(i);
			init();
		}
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=1;i<=n;i++) {
			if(visited[i]==2) {
				sb.append(i+"\n");
				count++;
			}
		}
		sb.insert(0, count+"\n");
		System.out.println(sb.toString());
	}
	public static void dfs(int here) {	
		if(visited[here]==2) {
			return;
		}
		visited[here]++;
		dfs(adj[here]);
	}
}
