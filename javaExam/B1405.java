package javaExam;

import java.util.Arrays;
import java.util.Scanner;

public class B1405 {
	static boolean[][] visited = new boolean[35][35];
    static double[] p = new double[4]; // 각 방향으로 이동할 확률
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		int count = Integer.parseInt(inputs[0]);
		for(int i=0;i<p.length;i++) {
			p[i]=Double.parseDouble(inputs[i+1])/100;
		}
		System.out.println(solve(count,15,15));
//		System.out.printf("%.2f",solve(count, 15,15));;
	}
	public static double solve(int count, int x, int y) {
		if(visited[y][x]) {
			return 0.0;
		}
		if(count==0) {
			return 1.0;
		}
		visited[y][x]= true;
		double ret=0.0;
		for(int i=0;i<4;i++) {
			ret += p[i]*solve(count-1, x+ dx[i], y+dy[i]);
		}
		visited[y][x]= false;
		return ret;
	}
	
}
