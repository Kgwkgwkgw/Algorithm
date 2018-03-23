import java.util.ArrayList;
import java.util.Arrays;

public class Lis_Re {
	public static int[] arr= { 5,4,3,2,1};
	public static void main(String[] args) {
		Arrays.fill(cache, -1);
		Arrays.fill(choices, -1);
		System.out.println(lis(-1)-1);
		ArrayList<Integer> resultList = new ArrayList<>();
		reconstruct(-1, resultList);
		System.out.println(resultList);
	}
	public static int[] cache = new int[arr.length+1];
	public static int[] choices = new int[arr.length+1];
	public static int lis(int index) {
		if(cache[index+1]!=-1) {
			return cache[index+1];
		}
		if(index==arr.length-1) {
			return 1;
		}
		int ret =1;
		int choice = -1;
		for(int i=index+1;i<arr.length;i++) {
			if(index==-1 || arr[index]< arr[i]) {
				int result = lis(i)+1;
				if(ret < result ) {
					ret = result;
					choice= i;
				}

			}
		}
		cache[index+1]= ret;
		choices[index+1]= choice;
		return ret;
	}
	public static void reconstruct(int index, ArrayList<Integer> resultList) {
		int choice = choices[index+1];
		if(choice==-1) {
			return;
		} else {
			resultList.add(arr[choice]);
			reconstruct(choice, resultList);
		}
	}
}
