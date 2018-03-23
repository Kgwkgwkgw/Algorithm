import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Gujongman732 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr= new long[n];
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res =0;
		PriorityQueue<Long> minHeap= new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				// TODO Auto-generated method stub
				return (int) (o1-o2);
			}
		});
		PriorityQueue<Long> maxHeap= new PriorityQueue<>(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				// TODO Auto-generated method stub
				return (int) (o2-o1);
			}
		});
		TreapNew.Treap treap = new TreapNew.Treap();
		long res2=0;
		for(int i=0;i<n;i++) {
			if(i==0) {
				arr[i]=1983;
			} else if(i>0) {
				arr[i]= (arr[i-1]*a+b)% 20090711;
			}
			treap.insert(new TreapNew.Node(arr[i]));
			if(minHeap.size()==maxHeap.size()) {
				maxHeap.add(arr[i]);
			} else {
				minHeap.add(arr[i]);
			}
			Long maxHeapPeek =maxHeap.peek();
			Long minHeapPeek =minHeap.peek();
			if(minHeapPeek!=null&& maxHeapPeek>minHeapPeek) {
				Long maxHeapPop = maxHeap.remove();
				Long minHeapPop = minHeap.remove();
				minHeap.add(maxHeapPop);
				maxHeap.add(minHeapPop);
			}
			res2+=maxHeap.peek();
			res2%=20090711;
			res+= treap.kth(i/2+1).value;
			res%=20090711;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(res);
		System.out.println(res2);
	}
}
