import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuJongMan281Re {
	public static int N; 
	public static int W;
	public static String[] name;
	public static int[] weight;
	public static int[] want;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int c = Integer.parseInt(sc.nextLine());
		while(c-->0) {
			String[] inputs = sc.nextLine().split(" ");
			N = Integer.parseInt(inputs[0]);
			W = Integer.parseInt(inputs[1]);
			
			weight = new int[N];
			want = new int[N];
			name = new String[N];
			
			for(int i=0;i<N;i++) {
				String[] itemInfo = sc.nextLine().split(" ");
				name[i]= itemInfo[0];
				weight[i]= Integer.parseInt(itemInfo[1]);
				want[i]= Integer.parseInt(itemInfo[2]);
			}
			cache= new int[N][1000];
			choices= new int[N];

			Arrays.fill(choices, -1);
			for(int i=0;i<cache.length;i++) {
				Arrays.fill(cache[i], -1);
			}
			System.out.println(solve(0,W));
			ArrayList<String> result = new ArrayList<>();
			reconstruct(0, W, result);
			System.out.println(result);
//			ArrayList<String> arrayList = new ArrayList<>();
//			reconstruct(-1, arrayList);
//			System.out.println(arrayList);
//			System.out.println();
		}
	}
	public static int[][] cache;
	public static int[] choices;
	public static int solve(int here, int currentWeight) {
		if(here == N) {
			return 0; 
		}
		if(cache[here][currentWeight]!=-1) {
			return cache[here][currentWeight];
		}
		
		int ret =0;
		ret = Math.max(ret, solve(here+1, currentWeight));
		if(currentWeight>= weight[here]) {
			ret = Math.max(ret, want[here]+ solve(here+1, currentWeight- weight[here]));
		}
		return ret;
	}
	public static void reconstruct(int index, int currentWeight,  ArrayList<String> arrayList) {
		if(index==N) {
			return;
		}
		if(solve(index,currentWeight)== solve(index+1, currentWeight)) {
			reconstruct(index+1, currentWeight, arrayList);
		} else {
			arrayList.add(name[index]);
			reconstruct(index+1, currentWeight- weight[index], arrayList);
		}
	}
}
