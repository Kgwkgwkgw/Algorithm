import java.util.Scanner;

public class Boj10972 {
//다음 순열 풀이
	public static int[] input;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		input = new int[n];
		for(int i=0;i<n;i++) {
			input[i]= sc.nextInt();
		}
		boolean isSuccess= solve(input);
		if(isSuccess) {
			for(int i=0;i<input.length;i++) {
				System.out.print(input[i]+ " ");
			}
		} else {
			System.out.println(-1);
		}
	}
	public static boolean solve(int[] origin) {
		int k = -1;
		for(int i=0;i<origin.length-1;i++) {
			if(origin[i] < origin[i+1]) {
				k=i;
			}
		}
		if(k==-1) {
			return false;
		}
		int l=-1;
		for(int i=k+1;i<origin.length;i++) {
			if(origin[k] < origin[i]) {
				l= i;
			}
		}
		if( l==-1) {
			return false;
		}
		origin[k] ^= origin[l];
		origin[l] ^= origin[k];
		origin[k] ^= origin[l];
		
		for(int i=0;i<(origin.length-k-1)/2;i++) {
			origin[i+k+1] ^= origin[origin.length-1-i];
			origin[origin.length-1-i] ^=origin[i+k+1];
			origin[i+k+1] ^= origin[origin.length-1-i];
		}
		return true;
	}
}

