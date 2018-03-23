package javaExam;

import java.util.*;

public class test1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			treeSet.add(sc.nextInt());
		}
		Iterator<Integer> iter = treeSet.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
