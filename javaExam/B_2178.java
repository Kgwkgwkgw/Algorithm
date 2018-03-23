package javaExam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2178 {
	static int width;
	static int height;
	static int dx[]= {1, 0,0,-1};
	static int dy[]= {0, 1, -1, 0};
	static boolean visited[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		height= Integer.parseInt(inputs[0]);
		width= Integer.parseInt(inputs[1]);
		int[][] board = new int[height][width];
		visited= new boolean[height][width];
		for(int i=0;i<height;i++) {
			String[] mapInputs= sc.nextLine().split("");
			for(int j=0;j<width;j++) {
				board[i][j]= Integer.parseInt(mapInputs[j]);
			}
		}
		int[][] dist = new int[height][width];
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();
		dist[0][0]=1;
		visited[0][0]=true;
		
		queueX.add(0);
		queueY.add(0);
		while(!queueX.isEmpty()) {
			int x= queueX.poll();
			int y= queueY.poll();
			if(x== width-1 && y== height-1) {
				System.out.println(dist[y][x]);
			}
			for(int i=0;i<dx.length;i++) {
				if(x+dx[i]>=0 && x+dx[i]<=width-1 && y+dy[i]>=0 && y+dy[i]<=height-1) {
					if(!visited[y+dy[i]][x+dx[i]] && board[y+dy[i]][x+dx[i]]==1 ) {
						visited[y+dy[i]][x+dx[i]]= true;
						queueX.add(x+dx[i]);
						queueY.add(y+dy[i]);
						dist[y+dy[i]][x+dx[i]]= dist[y][x]+1;
					}
				}
			}
		}
		for(int i=0;i<height;i++) {
			System.out.println(Arrays.toString(dist[i]));
		}
	}
}
