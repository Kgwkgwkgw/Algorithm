import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B1102 {
	public static int n;
	public static int[] cache;
	public static int[][] adj;
	public static int p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		cache= new int[1<<n];
		adj = new int[n][n];
		for(int i=0;i<n;i++) {
			String inputs[] = sc.nextLine().split(" ");
			for(int j=0;j<n;j++) {
				adj[i][j]= Integer.parseInt(inputs[j]);
			}
		}
		String onAndOff = sc.nextLine();
		int status = 0;
		ArrayList<Integer> yList = new ArrayList<>();
		for(int i=0;i<onAndOff.length();i++) {
			char ch = onAndOff.charAt(i);
			if(ch=='Y') {
				yList.add(i);
				status |= (1<<i);
			}
		}
		Arrays.fill(cache, -1);
//		for(int i=0;i<cache.length;i++) {
//			Arrays.fill(cache[i], -1);
//		}
		p= Integer.parseInt(sc.nextLine());
		int result =MAX;
		
//		for(int i=0;i<yList.size();i++) {
//			int ret = solve(yList.get(i),status, yList.get(i));
//			result = Math.min(result, ret);
////			System.out.println(ret);
//		}
		
//		System.out.println("status : " + status);
		if(yList.size()==0&& p>0) {
			System.out.println(-1);
		}else {
			System.out.println(solve(status));
		}
		
	}
	public static int MAX = 50 * 15+1;
	public static int solve(int status) {
		if(Integer.bitCount(status)>=p) {
			return 0; 
		}
		if(cache[status]!=-1) {
			return cache[status];
		}
		
		int ret = MAX;
		for(int from=0;from<n;from++) {
			if( (status & (1<<from)) > 0 ) {
				for(int to=0;to<n;to++) {
					if(from==to) {
						continue;
					}
					if((status & (1<< to))== 0 ) {
						ret = Math.min(ret, solve(status | (1<<to )) + adj[from][to]);
					}
				}
			}
		}
		cache[status]= ret;
		return ret;
	}
}