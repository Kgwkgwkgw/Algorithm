package javaExam;

import java.util.Scanner;

public class Snail {
	public static int n;
	public static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		m = Integer.parseInt(sc.nextLine());
		double[][] cache= new double[m][3*n];
		
		int denominator=1;
		for(int i =0;i<m;i++) {
			denominator*=2;
		}
		System.out.println((double)climb(0, 0, cache)/denominator);
		
		for(int i=0;i<m;i++) {
			for(int j =0;j<n;j++) {
				System.out.print(cache[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static double climb(int days, int sum, double[][] cache) {
		if(m==days) {
			if(n<=sum) {
				return 1;
			}
			else
				return 0;
		}
		if(cache[days][sum]!=0) {
			return cache[days][sum];
		}
		double res1 = climb(days+1, sum+1, cache)* (0.75);
		double res2 = climb(days+1, sum+2, cache)* 0.25;
		cache[days][sum]= res1+res2;
		return res1+ res2;
	}
}
