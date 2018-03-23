package javaExam;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr= new int[] {10,2,3,2,4,3,2,6,8,9,9,10,11,1,4,5,6,11};
		insertSort(arr);
		print(arr);

	}
	public static void insertSort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			int j= i+1;
			int tmp = arr[j];
			while(j>0 && arr[j-1]>tmp) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j]=tmp;
		}
	}
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
