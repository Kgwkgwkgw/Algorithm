package javaExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class B_2623 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		int singerNumber = Integer.valueOf(inputs[0]);
		int pdNumber = Integer.valueOf(inputs[1]);
		List<Integer>[] Singer = new ArrayList[singerNumber+1];
		int[] edgeCount = new int[singerNumber+1];
		
		List<Integer> singerOrderForMainPd = new ArrayList<>();

		for(int i=0;i<Singer.length;i++) {
			Singer[i]= new ArrayList<>();
		}
		
		for(int i=0; i<pdNumber; i++) {
			String[] orders = sc.nextLine().split(" ");
			
			
			for(int j=1; j< orders.length-1;j++) {
				
				Singer[Integer.valueOf(orders[j])].add(Integer.valueOf(orders[j+1]));
				edgeCount[Integer.valueOf(orders[j+1])]++;
			}
		}
		
		Queue resultQ =toPologicalSort(Singer, edgeCount);

		if(resultQ.size()==singerNumber) {
			while(!resultQ.isEmpty()) {
				System.out.println(resultQ.poll());
			}
		}
		else
			System.out.println(0);
		
	}
	public static Queue toPologicalSort(List<Integer>[] Singer, int[] edgeCount) {
		Queue<Integer> searchQ = new LinkedList<>();
		Queue<Integer> resultQ = new LinkedList<>();
		
		for(int i=1;i<edgeCount.length;i++) {
			if(edgeCount[i]==0) {
				searchQ.add(i);
			}
		}
		while(!searchQ.isEmpty()) {
			int toResult = searchQ.poll();
			resultQ.add(toResult);
			for(int j =0; j< Singer[toResult].size();j++) {
				edgeCount[Singer[toResult].get(j)]--;
				if(edgeCount[Singer[toResult].get(j)] ==0) {
					searchQ.add(Singer[toResult].get(j));
				}
			}
		}
		return resultQ;
	}
}
