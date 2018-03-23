package javaExam;

import java.util.Arrays;
import java.util.Scanner;

public class Kakao1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		char[][] encrypted= new char[size][size];
		
		for(int i =0;i<encrypted.length;i++) {
			Arrays.fill(encrypted[i], ' ');
		}
		
		String[] stringArr1= sc.nextLine().split(" ");
		int[] intArr1= makeIntegerArray(stringArr1, size);
		
		String[] stringArr2= sc.nextLine().split(" ");
		int[] intArr2= makeIntegerArray(stringArr2, size);
		
		for(int i =0;i<size;i++) {
			String string= Integer.toBinaryString(intArr1[i]|intArr2[i]);
			if(string.length()<size) {
				while(string.length()!=size) {
					string = "0"+string;
				}
			}
			
			char[] chArr = string.toCharArray();
			
			System.out.println(chArr);
			
			for(int j = 0; j<size;j++) {
				if(chArr[j]=='1') {
					encrypted[i][j]='#';
				}
			}
		}
		
		for(int i =0;i<size;i++) {
			System.out.print("\"");
			System.out.print(encrypted[i]);
			System.out.print("\"");
			if(i!=(size-1)) {
				System.out.print(", ");
			}
		}
	}
	public static int[] makeIntegerArray(String[] stArr, int size) {
		int[] intArr = new int[size];
		for(int i =0;i<stArr.length;i++) {
			intArr[i]= Integer.parseInt(stArr[i]);
		}
		return intArr;
	}
}
// 아...이건 먼저 비트연산을 해야했어..
