package javaExam;

import java.util.Scanner;

public class B8_12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = Integer.parseInt(sc.nextLine());
//		System.out.println(solve(2));
//		System.out.println(solve(4));
		System.out.println(solve(92));
	} 
	public static int solve(int width) {
		if(width%2==1) {
			return tiling(width)- tiling(width/2);
		} else {
			return tiling(width)- tiling(width/2)- tiling((width/2)-1);
		}
	}
	public static int tiling(int width) {
		if(width==0) {
			return 1;
		}
		if(width==1) {
			return 1;
		}
		if(width==2) {
			return 2;
		}
		return tiling(width-1)+ tiling(width-2);
	}
}
