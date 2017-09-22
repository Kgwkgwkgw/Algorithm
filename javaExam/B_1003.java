package javaExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class B_1003 {
	
	public static void main(String[] args) {
		class ZeroAndOne {
			public Integer zero;
			public Integer one;
			public ZeroAndOne(Integer zero, Integer one) {
				this.zero = zero;
				this.one = one;
			}
		}
		Scanner sc = new Scanner(System.in);
		Integer testCaseCount = Integer.parseInt(sc.nextLine());
		List<Integer> problemList = new ArrayList<>(testCaseCount);
		for(int i=0;i<testCaseCount;i++) {
			problemList.add(Integer.parseInt(sc.nextLine()));
		}
		ZeroAndOne[] zeroAndOne = new ZeroAndOne[50];
		zeroAndOne[0]= new ZeroAndOne(1, 0);
		zeroAndOne[1]= new ZeroAndOne(0, 1);
		for(int i=2; i<zeroAndOne.length; i++) {
			zeroAndOne[i]= new ZeroAndOne(zeroAndOne[i-1].zero+ zeroAndOne[i-2].zero, zeroAndOne[i-1].one+ zeroAndOne[i-2].one);
		}
		for(int i=0;i<testCaseCount;i++) {
			System.out.println(zeroAndOne[problemList.get(i)].zero+" "+zeroAndOne[problemList.get(i)].one);
		}
	}
}
