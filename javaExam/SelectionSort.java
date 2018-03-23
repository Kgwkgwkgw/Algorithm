package javaExam;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {
	public static void main(String[] args) {
		Integer[] arr= new Integer[] {10,2,3,2,4,3,2,6,8,9,9,10,11,1,4,5,6,11};
		try {
			selectionSort(null);
		} catch (NullPointerException e) {
			selectionSort(arr);
			print(arr);
		}
		selectionSort(arr);
		
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list);
		
	}
	public static void selectionSort(Integer[] arr) {
		if(arr==null) {
			throw new NullPointerException();
		}

		for(int i=0;i<arr.length-1;i++) {
			Integer min=arr[i];
			Integer minIndex=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<min) {
					minIndex=j;
					min=arr[j];
				}
			}
			arr[minIndex] = arr[i];
			arr[i]= min;
		}
	}
	public static void print(Integer[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
