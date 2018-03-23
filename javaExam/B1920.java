package javaExam;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B1920 {
	public static void main(String[] args) {
		int count[] = new int[100001];
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		
		String[] inputs = sc.nextLine().split(" ");
		for(int i=0;i<N;i++) {
			count[Integer.parseInt(inputs[i])]++;
		}
		int M = Integer.parseInt(sc.nextLine());
		String[] inputs2 = sc.nextLine().split(" ");
		for(int i=0;i<M;i++) {
			if(count[Integer.parseInt(inputs2[i])]>0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
