package javaExam;

import java.beans.Visibility;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class B4963 {
	public static final int LAND =1;
	public static final int SEA = 0;
	public static boolean[][] vistited;
	public static int[] dx = {1, -1, 0, 0,1,-1,-1,1};
	public static int[] dy = {0, 0, 1, -1,1,1,-1,-1};
	public static int count=0;
	public static int width;
	public static int height;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String[] inputs=sc.nextLine().split(" ");
			width = Integer.parseInt(inputs[0]);
			height = Integer.parseInt(inputs[1]);
			count =0;
			if(width == 0|| height==0) {
				break;
			}
			int[][] board= new int[height][width];
			vistited= new boolean[height][width];
			
			for(int i=0;i<height;i++) {
				String[] mapInputs = sc.nextLine().split(" ");
				for(int j=0;j<width;j++) {
					board[i][j]=Integer.parseInt(mapInputs[j]);
				}
			}
//			for(int i=0;i<board.length;i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
			for(int i=0;i<width;i++) {
				for(int j=0;j<height;j++) {
					if(board[j][i]==LAND) {
						int result= solve(board, i, j);
						if(result>0) {
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
		
	}
	public static int solve(int[][]board, int x, int y) {
		if(x<0 || x>width-1|| y<0 || y> height-1) {
			return 0;
		}
		if(vistited[y][x]) {
			return 0;
		}
		vistited[y][x]= true;
		if(board[y][x]==SEA) {
			return 0;
		}
		int result=1;
		for(int i=0;i<8;i++) {
			result+= solve(board, x+dx[i], y+dy[i]);
		}
		return result;
	}
}
