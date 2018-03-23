package javaExam;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		byte[] inputBytes = input.getBytes();
		int result = 0;
		int radix = 10;
		
		for(int i=0;i<inputBytes.length;i++) {
			result = result * 10 + (inputBytes[i] - '0');
		}
		System.out.println(result);
//		byte temp;
//		for(int i=0;i<input.length()/2;i++) {
//			temp = inputBytes[i];
//			inputBytes[i] = inputBytes[input.length()-1-i];
//			inputBytes[input.length()-1-i]= temp;
//		}
//		System.out.println(new String(inputBytes));
	}
}
