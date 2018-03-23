import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
public class B2583 {
	public static int whiteRectCount;
	public static ArrayList<Integer> list = new ArrayList();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String inputs[] = sc.nextLine().split(" ");
		//세로
		int M = Integer.parseInt(inputs[0]);
		//괄호
		int N = Integer.parseInt(inputs[1]);
		//직사각형 개수
		int K = Integer.parseInt(inputs[2]);
		
		int[][] board = new int[M][N];
		for(int i=0;i<K;i++) {
			String[] paintInputs = sc.nextLine().split(" ");
			int leftBottomX = Integer.parseInt(paintInputs[0]); 
			int leftBottomY = M-Integer.parseInt(paintInputs[1]);
			int rightUpX = Integer.parseInt(paintInputs[2]); 
			int rightUpY = M-Integer.parseInt(paintInputs[3]);
//			System.out.println("leftBottomX : "+leftBottomX );
//			System.out.println("leftBottomY : "+leftBottomY );
//			System.out.println("rightUpX : "+rightUpX);
//			System.out.println("rightUpY : "+rightUpY);
			for(int j=leftBottomX; rightUpX-j>0 ;j++) {
				for(int k =rightUpY; leftBottomY-k>0;k++) {
					board[k][j]=1;
				}
			}
		}
		for(int i=0;i<M;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		dfsAll(board);
		System.out.println(whiteRectCount);
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+ " ");
		}
		
		
	}
	public static void dfsAll(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==0) {
					list.add(dfs(board, i, j));
					whiteRectCount++;
				}
			}
		}
	}
	public static int dfs(int[][] board, int y, int x) {
		if(y<0|| y> board.length-1 || x<0 || x>board[y].length-1) {
			return 0;
		}
		if(board[y][x]!=0) {
			return 0;
		}
		board[y][x]=-1;
		int ret = 1;
		ret+= dfs(board, y+1, x);
		ret+= dfs(board, y-1, x);
		ret+= dfs(board, y, x+1);
		ret+= dfs(board, y, x-1);
		
		return ret;
	}
}
