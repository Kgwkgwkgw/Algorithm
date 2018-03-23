import java.util.Scanner;

public class B1987 {
	//알파벳
	//세로 R칸, 가로 C칸으로 된 표 모양의 보드가 있다. 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 칸 (1행 1열) 에는 말이 놓여 있다.
	//말은 상하좌우로 인접한 네 칸 중의 한 칸으로 이동할 수 있는데, 새로 이동한 칸에 적혀 있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다. 즉, 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
	//좌측 상단에서 시작해서, 말이 최대한 몇 칸을 지날 수 있는지를 구하는 프로그램을 작성하시오. 말이 지나는 칸은 좌측 상단의 칸도 포함된다.
	public static boolean[] visited;
	public static char[][] board; 
	public static int R;
	public static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs= sc.nextLine().split(" ");
		//세로 
		R = Integer.parseInt(inputs[0]);
		//가로
		C = Integer.parseInt(inputs[1]);
		board = new char[R][C];
		visited = new boolean[26];
		for(int i=0;i<R;i++) {
			String input= sc.nextLine();
			for(int j=0;j<C;j++) {
				board[i][j]= input.charAt(j);
			}
		}
		System.out.println(dfs(0,0,0));
	}
	public static int dfs(int y, int x, int count) {
		if(y>R-1|| y<0 || x< 0|| x>C-1) {
			return count;
		}
		if(visited[board[y][x]-'A']) {
			return count;
		}
		int ret =1;
		visited[board[y][x]-'A']=true;
		ret= Math.max(ret, dfs(y-1, x, count+1));
		ret= Math.max(ret, dfs(y+1, x, count+1));
		ret= Math.max(ret, dfs(y, x+1, count+1));
		ret= Math.max(ret, dfs(y, x-1, count+1));
		visited[board[y][x]-'A']=false;
		return ret;
	}
}
