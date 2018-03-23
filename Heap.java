import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Heap {
	private List<Integer> list;
	private int size;
	public Heap(List<Integer> list) {
		this.list=list;
		this.size=list.size();
		this.sort();
	}
	public void sort() {
		int idx= (this.size-1-1)/2;
		System.out.println("idx"+ idx);
		for(int i=idx;i>=0;i--) {
			downHeap(i);
		}
		int size = this.size;
		for(int i=0;i<size;i++) {
			popHeap();
		}
		this.size=list.size();
	}
	private Integer popHeap() {
		Collections.swap(this.list, 0, this.size-1);
		int pop = this.list.get(0);
		this.size--;
		downHeap(0);
		return pop;
	}
	private void downHeap(int i) {
		int left = i*2+1;
		int tobeRoot =i;
		int right = i*2+2;
		System.out.println("i:" + i);
		System.out.println("left : "+left);
		System.out.println("right : "+right);
		System.out.println(list.get(tobeRoot));
		if(left<=this.size-1) {
			System.out.println("list.get(left)"+list.get(left));
			if(list.get(left)>list.get(tobeRoot)) {
				tobeRoot=left;
			}
		}
		if(right<=this.size-1) {
			System.out.println("list.get(right) "+list.get(right));
			if(list.get(right)>list.get(tobeRoot)) {
				tobeRoot=right;
			}
		}
		System.out.println("----------");
//		System.out.println("tobeRoot:" + tobeRoot);
		Collections.swap(list, i, tobeRoot);
		if( i != tobeRoot)
			downHeap(tobeRoot);
	}
	public void print() {
		System.out.println(this.list);
	}
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(7);
		list.add(1);
		list.add(9);
		list.add(3);
		list.add(0);
		list.add(11);
		list.add(-1);
		Heap heap = new Heap(list);
		heap.print();
		
	}
}
