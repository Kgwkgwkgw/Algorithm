package javaExam;
public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr= new int[] {6,7,3,4,5,6,7,8,9};
		
//		quickSort(arr,0, arr.length-1);
		sort(arr,0, arr.length-1);
		print(arr);
	}
	public static void sort(int[] data, int l, int r){
	        int left = l;
	        int right = r;
	        int pivot= data[(l+r)/2];
	        
	        while (left <= right){
	            while(data[left] < pivot) left++;
	            while(data[right] > pivot) right--;
	            if(left <= right){    
	                int temp = data[left];
	                data[left] = data[right];
	                data[right] = temp;
	                left++;
	                right--;
	            } 

	        }
	        print(data);
	        if(l < right) sort(data, l, right);
	        if(r > left) sort(data, left, r);
    }



	public static void quickSort(int[] arr,int begin, int end) {
		int i;
		int size= end-begin+1;
		if(size >1) {
			i= partition(arr,begin, end);
			quickSort(arr, begin , i-1);
			quickSort(arr, i+1, end);
		}
	}
	public static int partition(int[] arr,int begin, int end) {
		int pivot = arr[end];
		int left = begin;
		int right = end;
		do {		
			while(left<end&& arr[left]<=pivot) {
				left++;
			}
			while(right>0&& arr[right]>=pivot) {
				right--;
			}
            if(left < right){    
	            	int tmp;
	    			tmp= arr[left];
	    			arr[left]= arr[right];
	    			arr[right]= tmp;
	            left++;
	            right--;
            }
		}while(left<right);
		int tmp;
		tmp =arr[left];
		arr[left]= arr[end];
		arr[end]=tmp;
		return left;
	}
//	public static int partition(int[] arr,int begin, int end) {
//		int pivot = arr[end];
//		int left = begin;
//		int right = end;
//		while(true) {		
//			while(left<right && arr[left]<=pivot) {
//				left++;
//			}
//			while(left<right && arr[right]>=pivot) {
//				right--;
//			}
//			if(left>=right) {
//				break;
//			}
//			int tmp;
//			tmp= arr[left];
//			arr[left]= arr[right];
//			arr[right]= tmp;
//		}
//		arr[end]=arr[left];
//		arr[left]= pivot;
//		return left;
//	}
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
}
