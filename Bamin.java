import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Bamin {
	public static int n = 6;
	public static int direction=1;
	public static int k =1;
	public static int j =1;
	public static LinkedList<Integer> list = new LinkedList<>();
	static {
		for(int i=1;i<=n;i++) {
			list.add(i);
		}
	}
	public static void main(String[] args) { 
		solve(1);
		System.out.println(list);
	}
	public static void solve(int direction) {
		
		if(direction==1) {
//			Iterator<Integer> it = list.iterator();
//			
//			for(int i=0;i<=k;i++) {
//				it.next();
//			}
//			it.remove();
//			k=k+j;
//			
//			while(list.size()>1) {
//				int count=k;
//				while(count >0) {
//					if(it.hasNext()) {
//						it.next();
//						count--;
//					} else {
//						it = list.iterator();
//					}
//				}
//				it.remove();
//				k=k+j;
//			}
			//Queue써도돼..
			Queue<Integer> queue = list;
			int repeatCount =k;
			for(int i=0;i<repeatCount;i++) {
				queue.add(queue.poll());
			}
			repeatCount+=j;
			queue.poll();
			
			while(queue.size()>1) {
				for(int i=0;i<repeatCount-1;i++) {
					queue.add(queue.poll());
				}
				repeatCount += j;
			}
			
		} else {
			Iterator<Integer> it = list.descendingIterator();
			
			for(int i=0;i<k;i++) {
				it.next();
			}
			
			it.remove();
			k=k+j;
			while(list.size()>1) {
				int count=k;
				while(count >0) {
					if(it.hasNext()) {
						System.out.println(it.next());
						count--;
					} else {
						it = list.descendingIterator();
					}
				}
				System.out.println("바루 위새기 죽ㅇ");
				it.remove();
				k=k+j;
			}
		}
	}
}
