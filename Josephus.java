import java.util.Iterator;
import java.util.LinkedList;

public class Josephus {
	public static int n =40;
	public static int k =3;
	public static LinkedList<Integer>  list;
	static {
		list = new LinkedList<>();
		for(int i=0;i<n;i++) {
			if(i<k) {
				list.add(n-k+i+1);
			}
			else {
				list.add(i-k+1);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(list);
		solve();
		System.out.println(list);
	}
	public static void solve() {
		Iterator<Integer> it = list.iterator();
		
		for(int i=0;i<=k;i++) {
			it.next();
		}
		
		it.remove();
		
		while(list.size()>2) {
			int count=k;
			while(count >0) {
				if(it.hasNext()) {
					it.next();
					count--;
				} else {
					it = list.iterator();
				}
			}
			it.remove();
			
		}
		
	}
}
