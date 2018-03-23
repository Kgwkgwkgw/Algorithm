import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class GuJongMan245 {
	public static int[] input;
	public static int[] psum;
	public static int[] pSqsum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			input = new int[n];
			int parts = sc.nextInt();
			for(int i=0;i<input.length;i++) {
				input[i]= sc.nextInt();
			}
			Arrays.sort(input);
			psum = new int[n];
			pSqsum = new int[n];
			psum[0]=  input[0];
			pSqsum[0] = input[0]* input[0];
			for(int i=1;i<n;i++) { 
				psum[i]=psum[i-1]+input[i];
				pSqsum[i]= pSqsum[i-1]+ input[i]*input[i];
			}
			cache= new int[n][parts+1];
			for(int i=0;i<cache.length;i++) {
				Arrays.fill(cache[i], -1);
			}
			System.out.println(solve(0,parts));
		}
	}
	public static int cache[][];
	public static int solve(int from, int parts) {
		if(from == input.length ) {
			return 0;
		} 
		if(parts==0) {
			return 10000;
		}
		if(cache[from][parts]!=-1) {
			return cache[from][parts];
		}
		int ret=10000;
		for(int i=1;i+from<=input.length;i++) {
			ret= Math.min(ret, getError(from, from+i-1) + solve(from+i, parts-1) );
		}
		cache[from][parts]=ret;
		return ret;
	}
	public static int getError(int from, int to) {
		int toValue = input[to];
		int fromValue =input[from];
		int ret=10000;
		for(int i=fromValue;i<=toValue;i++) {
			int tmp =0;
			for(int j=from;j<=to;j++) {
				tmp += (i-input[j])*(i-input[j]);
			}
			ret= Math.min(ret, tmp);
		}
//		int sum = psum[to]-(from ==0? 0 : psum[from-1]);
//		int sqSum = pSqsum[to]-(from==0? 0 : pSqsum[from -1 ]);
//		int m = (int)(0.5+(double)sum/(to-from+1));
//		int ret = sqSum - 2*m*sum+m*m*(to-from+1);
		return ret; 
	}
}
