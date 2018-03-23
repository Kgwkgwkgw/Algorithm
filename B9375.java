import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class B9375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		while(t-->0) {
			int n = Integer.parseInt(sc.nextLine());
			// key는 종류, value는 해당 종류의 리스트 
			HashMap<String, Integer> item= new HashMap<>();
			for(int i=0;i<n;i++) {
				String[] inputs = sc.nextLine().split(" ");
				if(item.containsKey(inputs[1])) {
					item.put(inputs[1], item.get(inputs[1]) +1 );
				}else {
					item.put(inputs[1], 1);
				}
			}
			
			Iterator<String> iter = item.keySet().iterator();
			int keySetSize = item.keySet().size();
			int k=1;
			while(iter.hasNext()) {
				k*=(item.get(iter.next())+1);
			}
			System.out.println(k-1);
		}
	}
}
