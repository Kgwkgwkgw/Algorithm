package javaExam;

import java.util.Scanner;

public class B10827 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		double a = Double.parseDouble(inputs[0]);
		int b= Integer.parseInt(inputs[1]);
		System.out.println(solve(a, b, 1));
	}
	public static double solve(double a, int b, double calc) {
		if(b==0) {
			return calc;
		}
		return solve(a , b-1, calc*a );
	}
}
