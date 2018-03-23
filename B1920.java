import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class B1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TreeSet set = new TreeSet<>();
		
		
		for(int i=0;i<N;i++) {
			set.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<M;i++) {
			list.add(sc.nextInt());
		}
		
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()) {
			int next = iter.next();
			if(set.contains(next)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
