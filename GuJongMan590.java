import java.util.Arrays;
import java.util.Scanner;

public class GuJongMan590 {
	public static short[] befores;
	public static short[] classes;
	public static int K;
	public static int L;
	public static int M;
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		while(c-->0) {
			// 전공 수
			N = sc.nextInt();
			// 들어야할 전공 수 
			K = sc.nextInt();
			// 학기의 수 
			M = sc.nextInt();
			// 학기에 최대로 들을 수 있는 수
			L = sc.nextInt();
			
			classes= new short[M];
			cache= new int[M+1][1<<N];
			for(int i=0;i<cache.length;i++)  {
				Arrays.fill(cache[i], -1);
			}
			// 전공마다 선수 과목들이 있다. 
			befores = new short[N];
			
			for(int i=0;i<N;i++) {
				int count = sc.nextInt();
				for(int j=0;j<count;j++) {
					int before = sc.nextInt();
					befores[i] |= (short) (1<< before);
				}
			}
			for(int i=0;i<M;i++) {
				int count = sc.nextInt();
				for(int j=0;j<count;j++) {
					int subject= sc.nextInt();
					classes[i] |= (short) ( 1 << subject);
				}
			}
			int result = graduate(0, (short) 0);
			if(result==MAX) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
		}
	}
	public static int[][] cache;
	public static int MAX =999;
	public static int graduate(int semester, short taken) {
		if(Integer.bitCount(taken)>=K) {
			return 0;
		}
		if(semester >= M ) {
			return MAX;
		}
		if(cache[semester][taken] != -1) {
			return cache[semester][taken];
		}
		int ret = MAX;
		short canListen= (short) (classes[semester]&~(taken));
		
		
		//들은 거나, 선수과목 안들은거 빼기.
		for(int i=0;i<befores.length;i++) {
			if((canListen & (1<<i)) > 0) {
				// 선수과목 다 안들은거 ..
				if((befores[i]&taken) != befores[i]) {
					canListen &= ~(1<<i);
				}
			}
		}
		for(int i= canListen; i>0; i=((i-1) & canListen)) {
			int toListenCount = Integer.bitCount(i);
			if(toListenCount<=L) {
				ret = Math.min(ret, graduate(semester+1, (short) (taken|i))+1);
			}
		}
		ret = Math.min(ret,  graduate(semester+1, taken));
		cache[semester][taken]=ret;
		return ret;
	}
}
