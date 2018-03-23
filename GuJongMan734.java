import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GuJongMan734 {
	public static int solve(List<Integer> list) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		PriorityQueue<Integer> minHeap= new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		int ret=0;
		for(int i=0;i<list.size();i++) {
			if(maxHeap.size()==minHeap.size()) {
				maxHeap.add(list.get(i));
			} else {
				minHeap.add(list.get(i));
			}
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
				int maxHeapPoll = maxHeap.poll();
				int minHeapPoll = minHeap.poll();
				minHeap.add(maxHeapPoll);
				maxHeap.add(minHeapPoll);
			}
			System.out.println(minHeap);
			System.out.println(maxHeap);
			System.out.println("peek : "+maxHeap.peek());
			System.out.println("------");
			ret+= maxHeap.peek();
		}
		return ret;
	}
	public static void main(String[] args) {
		List<Integer> queue = new LinkedList();
		queue.add(3);
		queue.add(1);
		queue.add(5);
		queue.add(4);
		queue.add(2);
		System.out.println(solve(queue));
		
	}
}
