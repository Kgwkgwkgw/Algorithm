import java.util.HashMap;
import java.util.Scanner;

public class B1620 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		// 포켓몬 수
		int N = Integer.parseInt(inputs[0]);
		// 내가 맞춰야하는 문제의 개수
		int M = Integer.parseInt(inputs[1]);
		HashMap<String, Integer> hashMap= new HashMap<>();
		String[] stringArr = new String[N+1];
		for(int i=1;i<=N;i++) {
			String input = sc.nextLine();
			stringArr[i]= input;
			hashMap.put(input, i);
		}
		for(int i=0;i<M;i++) {
			String input = sc.nextLine();
			// 헐 이거는 hash의 컨테인즈 쓰면돼네;
			try {
				int number = Integer.parseInt(input);
				System.out.println(stringArr[number]);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println(hashMap.get(input));
			}
		}
	}
}
