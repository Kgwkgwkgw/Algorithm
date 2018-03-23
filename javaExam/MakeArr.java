package javaExam;

import java.util.Arrays;

public class MakeArr {
	static int count=0;
	public static void main(String[] args) {
		int[][] arr = new int[2][2];
		makeArr(arr,0 ,0);
		System.out.println(count);
	}
	public static boolean check(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void makeArr(int[][] arr, int x, int y) {
		boolean flag;
		for(int k=1;k<=2;k++) {
			arr[y][x]=k;
			flag= false;
			for(int j=0;j<2;j++) {
				for(int i=0;i<2;i++) {
					if(arr[j][i]==0) {
						makeArr(arr, i,j);
						flag= true;
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			if(check(arr)) {
				count++;
				for(int i=0;i<arr.length;i++) {
					System.out.println(Arrays.toString(arr[i]));
				}
				System.out.println();
			}
		}
		arr[y][x]=0;
	}
}
