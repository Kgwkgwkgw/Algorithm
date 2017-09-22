package javaExam;

import java.util.Scanner;

public class B_2839 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int toMove = Integer.parseInt(sc.nextLine());
		
		System.out.println(calcCount(toMove));
	}
	public static int calcCount(int toMove) {
		int count = 0;
		if(toMove%5==0) {
			count =toMove/5; 
		}
		else if (toMove%3==0) {
			count = toMove/3;
		}
		for(int i=0; i< toMove/3;i++) {
			toMove-=3;
			if(toMove%5==0) {
				count = minNotZero(count, i+1+toMove/5);
			}
		}
		return count>0 ? count: -1;
	}
	public static int minNotZero(int number1, int number2) {
		if(number1==0) {
			return number2;
		}
		if(number2==0) {
			return number1;
		}
		if(number1==0&& number2==0) 
			throw new RuntimeException("둘 다 0일 순 없음.");
		return number1> number2 ? number2 : number1;
	}
}
