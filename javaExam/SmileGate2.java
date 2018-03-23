package javaExam;

import java.util.Calendar;
import java.util.Scanner;

public class SmileGate2 {
	public static void main(String[] args) {
		final double rate = 1.11;
		final double myMoney = 1000000;
		
		Scanner sc = new Scanner(System.in);
		int needYear= solve(myMoney, Double.parseDouble(sc.nextLine()), rate, 0);
		print(Calendar.getInstance().get(Calendar.YEAR)+needYear);
		
	}
	public static int solve(double myMoney, double target, double rate, int count) {
		if(myMoney>= target) {
			return count;
		}
		myMoney*= rate;
		count++;
		return solve(myMoney, target, rate, count);
	}
	public static void print(int year) {
		System.out.println("the achieve your of target amount is "+year);
	}
}
