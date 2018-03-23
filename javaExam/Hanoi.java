package javaExam;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {
	public static void main(String[] args) {
		hanoi(3,1,2,3);
		System.out.println("--------");
		hanoi(4,1,2,3);
		System.out.println("--------");
		hanoi(5,1,2,3);
		System.out.println("--------");
		hanoi(6,1,2,3);
		System.out.println("--------");
	}
	public static void hanoi(int n, int from, int by, int to) {
		if(n==1) {
			move(from, to);
			return;
		}
		hanoi(n-1, from, to, by);
		move(from,to);
		hanoi(n-1, by, from, to);
	}
	public static void move(int from, int to) {
		System.out.println("move from "+from+" to "+ to);
	}
}
