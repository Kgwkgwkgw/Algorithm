import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			//가지고있는 영화의 수 
			int n = sc.nextInt();
			
			LinkedList<Integer> movieList = new LinkedList<>(); 
			for(int i=0;i<n;i++) {
				movieList.add(i+1);
			}
			//보려고하는 영화의 수 
			int m = sc.nextInt();
			for(int i=0;i<m;i++) {
				int number = sc.nextInt();
				int index = movieList.indexOf(number);
				sb.append(index+ " ");
				movieList.remove(index);
				movieList.addFirst(number);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
