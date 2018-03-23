import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.mysql.jdbc.CacheAdapter;

public class GujongMan294 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//장조 
		int m = sc.nextInt();
		//단조
		int n = sc.nextInt();
		cache= new int[m+1][n+1];
		
		solve(m,n);
		System.out.println();
		System.out.println();
		System.out.println(arrayList.get(1));
	}
	public static LinkedList<String> linkedList = new LinkedList<>();
	public static ArrayList<String> arrayList = new ArrayList<>();
	public static int[][] cache;
	public static void solve(int m, int n) {
		if(m>0) {
			linkedList.add("-");
			solve(m-1,n);
			linkedList.removeLast();
		}
		if(n>0) {
			linkedList.add("o");
			solve(m,n-1);
			linkedList.removeLast();
		}
		if(m==0&&n==0) {
			arrayList.add(linkedList.toString());
//			cache[m][n]= 
			System.out.println(linkedList);
		}
	}
}
