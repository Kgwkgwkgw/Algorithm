import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class B7785 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		TreeSet<String> treeSet = new TreeSet<>();
		for(int i=0;i<n;i++) {
			String inputs[] = sc.nextLine().split(" ");
			if("enter".equals(inputs[1])) {
				treeSet.add(inputs[0]);
			} else {
				if(treeSet.contains(inputs[0])) {
					treeSet.remove(inputs[0]);
				}
			}
		}
		Iterator<String> iter = treeSet.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
