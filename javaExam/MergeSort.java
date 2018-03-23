package javaExam;

import java.util.Arrays;

public class MergeSort {
	private static int[] sort = new int[30];
	public static void mergeSort(int[] arr, int begin , int end) {
//		System.out.println("begin "+ begin+" end : "+end);
		if(begin<end) {
			int mid = (begin+ end)/2;
			mergeSort(arr, begin, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, begin,mid, end);
		}
//		return;
	}
	public static void merge(int[] arr, int begin, int mid, int end) {
		int iA = begin;
		int iB = mid+1;
		int iS = begin;
		while(iA<=mid && iB<=end) {
			if(arr[iA]<=arr[iB]) {
				sort[iS]= arr[iA];
				iA++;
				iS++;
			} else {
				sort[iS]= arr[iB];
				iB++;
				iS++;
			}
		}
		while(iA<=mid) {
			sort[iS]= arr[iA];
			iA++;
			iS++;
		}
		while(iB<=end) {
			sort[iS]= arr[iB];
			iB++;
			iS++;
		}
		for(int i=begin;i<=end;i++) {
			arr[i]= sort[i];
		}
		
		return;
	}
	public static void main(String[] args) {
        int[] arr = new int[]{27, 2, 46, 4, 19, 50};
//        System.out.println(arr[6]);
        MergeSort.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(MergeSort.sort));
	}
}
