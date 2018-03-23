import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class B2644 {
//	public static Queue<Integer> queue = new LinkedList<>();
//	public static LinkedList<Integer> list= new LinkedList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int peopleCount = sc.nextInt();
		int toCalcPerson1 = sc.nextInt();
		int toCalcPerson2 = sc.nextInt();
		int edgeCount = sc.nextInt();
		int adj[] = new int[peopleCount+1];
		
		for(int i=0;i<edgeCount;i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			// 자식에서 부모로가는 방향 그래프를 그린다.
			adj[child]=parent;
		}
		Map<Integer, Integer> map1 = new LinkedHashMap<>();
		int distance =0;
		while(true) {
			// 자식과 그 거리 
			map1.put(toCalcPerson1, distance++);
			if(adj[toCalcPerson1]==0) {
				break;
			}
			toCalcPerson1= adj[toCalcPerson1];
			
		}
		distance =0;
		Map<Integer, Integer> map2 = new LinkedHashMap<>();
		while(true) {
			// 자식과 그 거리 
			map2.put(toCalcPerson2, distance++);
			if(adj[toCalcPerson2]==0) {
				break;
			}
			toCalcPerson2= adj[toCalcPerson2];
		}
		Iterator<Integer> keySet = map1.keySet().iterator();
		while(keySet.hasNext()) {
			int key = keySet.next();
			if(map2.containsKey(key)) {
				System.out.println(map2.get(key) + map1.get(key));
				return;
			}
		}
		System.out.println(-1);
//		makeQueue(1, peopleCount, 2);
//		System.out.println(queue);
		
	}
//	public static void findAncestor() {
//		while(!queue.isEmpty()) {
//			int toCalcPersonParent = queue.poll();
//			int toCalcPersonParent = queue.poll();
//		}
//	}
//	public static void makeQueue(int start, int n, int r) {
//		if(r==0) {
//			Iterator<Integer> iter =list.iterator();
//			while(iter.hasNext()) {
//				queue.add(iter.next());
//			}
//			return;
//		}
//		for(int i=start;i<=n;i++) {
//			list.add(i);
//			makeQueue(i+1, n, r-1);
//			list.removeLast();
//		}
//	}
	
}
