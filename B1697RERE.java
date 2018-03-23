import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1697RERE {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int subinPosition = sc.nextInt();
		int brotherPosition = sc.nextInt();
		
		Queue<Integer> subinPositionQueue = new LinkedList<>();
		boolean[] discovered= new boolean[100_001*2];
		int[] distance = new int[100_001*2];
		
		subinPositionQueue.add(subinPosition);
		discovered[subinPosition]=true;
		distance[subinPosition]=0;
		
		while(!subinPositionQueue.isEmpty()) {
			int poll = subinPositionQueue.poll();
			int d = distance[poll];
			if(poll == brotherPosition) {
				System.out.println(d);
				break;
			}
			
			if(poll*2 <=100_001*2-1&& !discovered[poll*2]) {
				subinPositionQueue.add(poll*2);
				discovered[poll*2]=true;
				distance[poll*2]= d+1;
			}
			if(poll+1 <=100_001*2-1&& !discovered[poll+1]) {
				subinPositionQueue.add(poll+1);
				discovered[poll+1]=true;
				distance[poll+1]= d+1;
			}
			if(poll-1 >=0 && !discovered[poll-1]) {
				subinPositionQueue.add(poll-1);
				discovered[poll-1]=true;
				distance[poll-1]= d+1;
			}
		}
		
	}
}
