package javaExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Mugari {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ddd");
		String k = list.get(0);
		k= "fff";
		System.out.println(k);
		System.out.println(list);
		int[] arr= new int[1];
		arrHi(arr);
		System.out.println(arr[0]);
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		Set<Character> set = new LinkedHashSet<>();
//		for(int i=0;i<input.length();i++) {
//			set.add(input.charAt(i));
//		}
//		System.out.println(set);
	}
	public static void arrHi(int[] arr) {
		arr[0]=10000;
	}
	public static void aa(List<String> list) {
		list.add("ddd");
	}
	public static void bb(String bb) {
		System.out.println(bb);
		bb= "ff";
	}
}
