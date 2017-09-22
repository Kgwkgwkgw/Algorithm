package javaExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2667 {
	static boolean[][] rectVisted;
	static Integer rectSize;
	static Integer[][] rect;
	static List<Integer> danji = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		rectSize = Integer.parseInt(sc.nextLine());
		
		rect = new Integer[rectSize][rectSize];
		rectVisted = new boolean[rectSize][rectSize];
		
		// 사각형 만들기 
		for(int i=0;i<rectSize;i++) {
			String line = sc.nextLine();
			for(int j=0;j<line.length();j++) {
				rect[i][j]= line.charAt(j)-'0';
			}
		}
		// 방문 안한 상태 만들기
		for(int i =0;i<rectSize;i++) {
			for(int j=0; j<rectSize;j++) {
				rectVisted[i][j]= false;
			}
		}		
		// 사각형 풀기 
		for(int i=0;i<rectSize;i++) {
			for(int j=0;j<rectSize;j++) {
				int danjiCount = solve(i,j);
				if(danjiCount >0 ) {
//					System.out.println("danjiCount: "+danjiCount);
//					System.out.println("i, j : " +i+ " "+j);
					danji.add(danjiCount);
				}
			}
		}
		Collections.sort(danji);
		System.out.println(danji.size());
		for(int i =0;i<danji.size();i++) {
			System.out.println(danji.get(i));
		}
	}
	public static int solve(Integer i, Integer j) {
		if(i < 0 || j <0 || j > rectSize-1 || i>rectSize-1) {
			return 0;
		}
		if(rectVisted[i][j] || rect[i][j]==0)
			return 0;
		rectVisted[i][j] = true;
		return 1 + solve(i+1, j)+ solve(i-1, j)+ solve(i, j+1)+ solve(i,j-1);
		
	}
}
