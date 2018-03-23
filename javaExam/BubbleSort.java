package javaExam;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr= new int[] {10,2,3,2,4,3,2,6,8,9,9,10,11,1,4,5,6,1};
		bubbleSort(arr);
		print(arr);
	}
	public static void bubbleSort(int[] arr) {
		int tmp;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					tmp=arr[j];
					arr[j]= arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
