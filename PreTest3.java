import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PreTest3 {
	public static void main(String[] args) {
		char[] card = {'S','D', 'H', 'C'};
		int max = 13;
		int player = 4;
		int countCardSelect = 7;
		boolean isOver;
		int minCardSum = 0;
		
		Set<String>[] playerCard = new HashSet[player];
		LinkedList<Integer> linked = new LinkedList<>();
		HashSet<Integer> hashSet  = new HashSet<>();
		
		int[] playerCardSum = new int[player];
		
		for(int i=0;i<playerCard.length;i++) {
			playerCard[i] = new HashSet<>();
		}
		
		
		Map<Integer, String> map = new HashMap<>();
		for(int i=0;i<card.length;i++) {
			for(int j =1;j<=max;j++) {
				map.put(max*i +j, ""+card[i]+j);
			}
		}

		do {
			isOver = true;
			minCardSum = 1;
			for(int i=0;i<7;i++) {
				minCardSum += max-i;
			}
			
			Map<Integer, String> inGameMap = new HashMap<>(map);
			Random random = new Random();
			
			for(int i=0;i<playerCard.length;i++) {
				playerCard[i].clear();
			}
			
			for(int i=0;i<player;i++) {
				while(playerCard[i].size()<countCardSelect) {
					String value = inGameMap.remove(random.nextInt(map.size()+1));
					if(value!=null) { 
						playerCard[i].add(value);
					}
				}
			}
			for(int i=0;i<player;i++) {
				int sum = 0;
				
				System.out.print("Player"+i+":" + String.join(", ", playerCard[i]));
				
				for(String playerHasCard : playerCard[i]) {
					sum +=Integer.parseInt(playerHasCard.substring(1));
				}
				
				playerCardSum[i]=sum;
				System.out.println(": sum = "+ sum);
			}
			
			for(int i=0;i<player;i++) {
				if(playerCardSum[i] < minCardSum) {
					minCardSum = playerCardSum[i];
				} else if(playerCardSum[i] == minCardSum){
					isOver = false;
				}
			}
			
		}while(!isOver);
		
	}
}
