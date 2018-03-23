package javaExam;

import java.util.Arrays;

public abstract class AbstractExample {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,2,3,3,1,5,5,5,5,5,5,4,4,4,4,3,2,1,6,7,8,9};
		int[] newArr= removeExists(arr);
		System.out.println(Arrays.toString(newArr));
	}
	
	public static int[] removeExists(int[] arr) {
		int[] newArr = new int[arr.length];
		int newArrIndex=0;
		boolean isExist;
		for(int i=0;i< arr.length;i++) {
			isExist = false;
			for(int j=0;j< newArr.length;j++) {
				if(arr[i] == newArr[j]) {
					isExist= true;
				}
			}
			if(!isExist) {
				newArr[newArrIndex++] = arr[i];  
			}
		}
		return newArr;
	}

}
