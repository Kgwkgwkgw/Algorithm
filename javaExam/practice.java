package javaExam;

import java.util.Arrays;

public class practice {
	public static void main(String[] args) {
		// 버블버블
		int[] arr = { 21, 7, 6, 3, 26, 3, 2, 1, 25, 26 };
		quickSort(arr, 0, arr.length - 1);
//		mergeSort(arr);
		// for(int i=0;i<arr.length-1;i++) {
		// for(int j=0;j<arr.length-i-1;j++) {
		// if(arr[j]>arr[j+1]) {
		// int temp = arr[j];
		// arr[j]= arr[j+1];
		// arr[j+1]= temp;
		// }
		// }
		// }
		// System.out.println(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
	public static void quickSort(int[] arr, int start, int end) {
		if(end-start<=0) {
			return;
		}
		int pivot= arr[end];
		int left = start;
		int right = end;
		int tmp;
		while(true) {
			while(arr[left]<pivot) {
					left++;
			}
			while(right>0 && arr[right]>=pivot) {
				right--;
			}
			if(left>=right)
				break;
			tmp=arr[left];
			arr[left]=arr[right];
			arr[right]=tmp;		
		}

		arr[end]=arr[left];
		arr[left]=pivot;
		quickSort(arr, start, left-1);
		quickSort(arr, left+1, end);
	}
//	 public static void quickSort(int[] arr, int left, int right) {
//		 if (left < right) {
//			 int start = left;
//			 int end = right;
//			 int pivot = arr[start];
//			 while (left < right) {
//				 while (arr[right] > pivot)
//				 right--;
//				 while (left < right && arr[left] <= pivot)
//				 left++;
//				
//				 int temp = arr[right];
//				 arr[right] = arr[left];
//				 arr[left] = temp;
//			 }
//			 arr[start] = arr[left];
//			 arr[left] = pivot;
//			
//			 quickSort(arr, start, left - 1);
//			 quickSort(arr, left + 1, end);
//		 }
//		
//	}
//	public static void mergeSort(int[] arr) {
//		int size = arr.length;
//		if(size==1) {
//			return;
//		}
//		int[] arrLeft = new int[size/2];
//		int[] arrRight = new int[size-size/2];
//		
//		for(int i =0;i<arrLeft.length;i++) {
//			arrLeft[i]= arr[i];
//		}
//		for(int j =0;j<arrRight.length;j++) {
//			arrRight[j]= arr[j+size/2];
//		}
//		mergeSort(arrLeft);
//		mergeSort(arrRight);
//		merge(arrLeft,arrRight,arr);
//	}
//	public static void merge(int[] left, int[] right, int[] arr) {
//		int iL =0;
//		int iR =0;
//		int iA = 0;
//		
//		while(iL<left.length) {
//			if(iR< right.length) {
//				if(left[iL]<right[iR]) {
//					arr[iA]= left[iL];
//					iL++;
//				} else {
//					arr[iA]= right[iR];
//					iR++;
//				}
//				iA++;
//			} else {
//				arr[iA]=left[iL];
//				iL++;
//				iA++;
//			}
//		}
//		while(iR<right.length) {
//			arr[iA]= right[iR];
//			iR++;
//			iA++;
//		}
//	}
}
