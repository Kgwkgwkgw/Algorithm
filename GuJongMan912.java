import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GuJongMan912 {
	public static class State {
		public State () {
			for(int i=0;i<honoi.length;i++) {
				honoi[i]= new LinkedList<>();
			}
		}
		public State(LinkedList<Integer>[] honoi) {
			this.honoi= honoi;
		}
		LinkedList<Integer>[] honoi = new LinkedList[4];
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(honoi);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (!Arrays.equals(honoi, other.honoi))
				return false;
			return true;
		}
		public LinkedList<Integer>[] getCopy() {
			LinkedList<Integer>[] copy= new LinkedList[4];
			for(int i=0;i<4;i++) {
				copy[i]= new LinkedList<>();
			}
			for(int i=0;i<4;i++) {
				Iterator<Integer> iter = this.honoi[i].iterator();
				while(iter.hasNext()) {
					copy[i].add(iter.next());
				}
			}
			return copy;
		}
		public ArrayList<State> getAdjList() {
			ArrayList<State> stateList= new ArrayList<>();

			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(i==j) {
						continue;
					}
					if((!honoi[i].isEmpty() && honoi[j].isEmpty()) || ( !honoi[i].isEmpty() &&!honoi[j].isEmpty()&&honoi[i].peekLast() < honoi[j].peekLast())) {
						LinkedList<Integer>[] copy = this.getCopy();
						copy[j].addLast(copy[i].removeLast());
						stateList.add(new State(copy));
					}
				}
			}
			return stateList;
		}
		@Override
		public String toString() {
			return "State [honoi=" + Arrays.toString(honoi) + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		while(C-->0) {
			int n = sc.nextInt();
			State init = new State();
			for(int i=0;i<4;i++) {
				int count = sc.nextInt();
				for(int j=0;j<count;j++) {
					init.honoi[i].add(sc.nextInt());
				}
			}
			State finish = new State();
			for(int i=0;i<4;i++) {
				int count = sc.nextInt();
				for(int j=0;j<count;j++) {
					finish.honoi[i].add(sc.nextInt());
				}
			}
			
			Queue<State> queue = new LinkedList<>();
			HashMap<State, Integer> distance = new HashMap<>();
			distance.put(init, 0);
			queue.add(init);
			System.out.println(init.getAdjList());
			System.out.println(init);
			while(!queue.isEmpty()) {
				State poll = queue.poll();
				int d = distance.get(poll);
				if(poll.equals(finish)) {
					System.out.println(d);
					break;
				}
				ArrayList<State> stateList = poll.getAdjList();
//				System.out.println(stateList);
				
				for(int i=0;i<stateList.size();i++) {
					if(!distance.containsKey(stateList.get(i))) {
						queue.add(stateList.get(i));
						distance.put(stateList.get(i), d+1);
					}
				}
			}
//			System.out.println("IMPOSSIBLE");
		}
	}
}
