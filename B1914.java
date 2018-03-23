import java.math.BigInteger;
import java.util.Scanner;

public class B1914 {
	public static BigInteger count = new BigInteger("1");
	public static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			for(int i=0;i<N;i++) {
				count =count.multiply(BigInteger.valueOf(2));
			}
			count =count.subtract(BigInteger.valueOf(1));
			System.out.println(count);
			if(N<=20) {
				hanoi(N, 1, 2, 3);
				System.out.println(sb.toString());
			}
	}
	public static void hanoi(int N, int from, int by, int to) {
		if(N==1) {
			sb.append(from + " " +to+"\n");
			return;
		}
		
		hanoi(N-1, from, to, by);
		
		sb.append(from + " " + to+"\n");
		
		hanoi(N-1, by, from , to);
	}
}
