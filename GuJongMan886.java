import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GuJongMan886 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
//		int count =0;
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
//		ArrayList<Integer> distance= new ArrayList<>();
		int order= 0;
		Queue<ArrayList<Integer>> queue = new LinkedList<>();
		queue.add(list);
		HashMap<ArrayList, Integer> distance = new HashMap<>();
		distance.put(list, 0);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> numberList = queue.poll();
			int d = distance.get(numberList);
			boolean isSort=true;
			
			for(int i=1;i<numberList.size();i++) {
				if(numberList.get(i-1)>numberList.get(i)) {
					isSort=false;
				}
			}
			if(isSort) {
				System.out.println(d);
				break;
			}
			else {
				ArrayList<Integer> copy=null;
				for(int i=0;i<numberList.size()-1;i++) {
					for(int j=i+1;j<numberList.size();j++) {
						copy = new ArrayList<>(numberList);
						int begin = i;
						int end = j;
						while(begin<end) {
							int beginValue = copy.get(begin);
							int endValue = copy.get(end);
							copy.set(begin, endValue);
							copy.set(end, beginValue);
							begin++;
							end--;
						}
						if(!distance.containsKey(copy)) {
							queue.add(copy);
							distance.put(copy, d+1);
						}
					}
				}
			}
		}
	}
}
