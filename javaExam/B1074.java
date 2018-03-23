package javaExam;

import java.util.Arrays;
import java.util.Scanner;

public class B1074 {
	public static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs= sc.nextLine().split(" ");
		int size = (int) Math.pow(2, Integer.parseInt(inputs[0]));
		int y = Integer.parseInt(inputs[1]);
		int x = Integer.parseInt(inputs[2]);
		int[][] board = new int[size][size];
		solve(board, 0, size-1, 0, size-1);
		for(int i=0;i<size;i++) {
			System.out.println(Arrays.toString(board[i]));
		}

	}
	public static void solve(int[][] board, int verticalStart, int verticalEnd, int horizontalStart, int horizontalEnd) {
		for(int i=0;i<board.length;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("--------");
		if(verticalEnd-verticalStart>1) {
			int mid = (verticalEnd- verticalStart)/2;
			
			solve(board, verticalStart, mid, horizontalStart, horizontalEnd);
			solve(board, mid+1, verticalEnd, horizontalStart, horizontalEnd);
			return;
		}
		if(horizontalEnd-horizontalStart>1) {
			int mid = (horizontalEnd-horizontalStart)/2;
			solve(board, verticalStart, verticalEnd, horizontalStart, mid);
			solve(board, verticalStart, verticalEnd, mid+1, horizontalEnd);
			return;
		}
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					if(board[verticalStart+i][horizontalStart+j]==0) {
						board[verticalStart+i][horizontalStart+j]=count++;
					}
				}
			}
			
		
	}
}
