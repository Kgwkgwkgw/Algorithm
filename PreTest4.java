import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PreTest4 {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			int count = sc.nextInt();
			Random random = new Random();
			
			Map<String, Integer> idScore = new HashMap<>();

			while (idScore.size() < count) {
				int number = random.nextInt(100000);
				String id = String.format("NT%05d", number);
				if (!idScore.containsKey(id)) {
					idScore.put(id, random.nextInt(100));
				}
			}

			for(Map.Entry<String, Integer> entry : idScore.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
			
			for(Map.Entry<String, Integer> entry : idScore.entrySet()) {
				
			}
			
			List<Integer> list = new ArrayList<>();
			list.add(5);
			list.add(6);
			list.iterator().remove();;
		}
	}
}
