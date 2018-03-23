import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GuJongMan886_Re {
	public static ArrayList<Integer> input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while (C-- > 0) {
			int n = sc.nextInt();
			input = new ArrayList<>();
			for(int i=0;i<n;i++) {
				input.add(sc.nextInt());
			}
			bfs();
		}

	}
	public static boolean isSorted(ArrayList<Integer> poll) {
		for(int i=0;i<poll.size()-1;i++) {
			if(poll.get(i)>poll.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	public static void bfs() {
		Queue<ArrayList<Integer>> queue= new LinkedList<>();
		HashMap<ArrayList<Integer>, Integer> distance = new HashMap<>();
		queue.add(input);
		distance.put(input, 0);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> poll = queue.poll();
			int d = distance.get(poll);
			if(isSorted(poll)) {
				System.out.println(poll);
				System.out.println(d);
				return;
			}
			for(int i=0;i<input.size()-1;i++) {
				for(int j=i+1;j<input.size();j++) {
					ArrayList<Integer> copy = new ArrayList(poll);
					for(int k=0;k<=(j-i)/2;k++) {
						int tmp = copy.get(k+i);
						copy.set(k+i, copy.get(j-k));
						copy.set(j-k, tmp);
					}
					if(!distance.containsKey(copy)) {
						queue.add(copy);
						distance.put(copy, d+1);
					}
					
//					System.out.println(copy);
//					System.out.println(distance.get(copy));
				}
			}
		}
		
	}
}
