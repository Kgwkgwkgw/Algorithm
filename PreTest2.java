import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PreTest2 {
	public static void main(String[] args) {
		int money = 1_000_000;
		int[] units = { 1, 5, 10, 20, 50, 100};
		
		int N = 1_322;
		
		Map<Integer, Integer> unitCounts = new HashMap<>();
		for(int i = 0 ; i < units.length;i ++) {
			unitCounts.put(units[i], 0);
		}
		
		Queue<Integer> roundRobinQueue = new LinkedList<>();
		roundRobinQueue.add(20);
		roundRobinQueue.add(10);
		roundRobinQueue.add(5);
		roundRobinQueue.add(1);
		
		unitCounts.put(100, 4);
		money -= 100*4*N;
		unitCounts.put(50, 4);
		money -= 50*4*N;
		unitCounts.put(1, 20);
		money -= 1*20*N;
		
		while(roundRobinQueue.size()>0) {
			int unit = roundRobinQueue.poll();
			int size = unitCounts.get(unit);
			if(money-unit*N  < 0 ) {
				continue;
			}
			money -= unit*N;
			unitCounts.put(unit, size+1);
			
			if(money > 2000) {
				roundRobinQueue.add(unit);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<units.length;i++) {
			stringBuilder.append(units[i]+"N : "+unitCounts.get(units[i])+"장 ");
		}
		stringBuilder.append("잔돈 : "+ money+"원");
		System.out.println(stringBuilder.toString());
		
	}
}
