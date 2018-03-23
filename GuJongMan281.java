import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuJongMan281 {
	public static int maxWeight;
	public static int N;
	public static class Item {
		String name;
		int w;
		int hope;
		public Item (String name, int w, int hope) {
			this.name= name;
			this.hope=hope;
			this.w=w;
		}
	}
	public static Item[] itemList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		while(t-->0) {
			String[] inputs = sc.nextLine().split(" ");
			N =Integer.parseInt(inputs[0]);
			maxWeight = Integer.parseInt(inputs[1]);
			itemList = new Item[N];
			choices = new int[N+1];
			Arrays.fill(choices, -1);
			cache= new int[N+1][maxWeight+1];
			for(int i=0;i<cache.length;i++)  {
				Arrays.fill(cache[i], -1);
			}
			for(int i=0;i<N;i++) {
				String[] input = sc.nextLine().split(" ");
				itemList[i]= new Item(input[0], Integer.parseInt(input[1]),Integer.parseInt(input[2]));
			}
			int maxHoep = solve(0, maxWeight);
//			ArrayList<String> nameList = new ArrayList<>();
//			System.out.println(Arrays.toString(choices));
//			makeList(-1, nameList, itemList,0);
//			System.out.println(maxHoep+ " " +nameList.size());
//			for(int i=0;i<nameList.size();i++) {
//				System.out.println(nameList.get(i));
//			}
			System.out.println(maxHoep);
			ArrayList<String> nameList = new ArrayList<>();
			restruct(nameList, 0, maxWeight);
			System.out.println(maxHoep+ " "+ nameList.size());
			System.out.println(nameList);
		}
	}
	public static int[][] cache;
	public static int[] choices;
	public static int solve(int index, int remainWeight) {
		if(index==N) {
			return 0; 
		}
		if(cache[index][remainWeight]!=-1) {
			return cache[index][remainWeight];
		}
		int ret =solve(index+1, remainWeight);
		System.out.println("index : "+ index);
		System.out.println("N : "+N);
		if(remainWeight>= itemList[index].w) {
			ret = Math.max(ret, solve(index+1, remainWeight-itemList[index].w) + itemList[index].hope);
		}
		cache[index][remainWeight]= ret;
		return ret;
	}
	public static void restruct(ArrayList<String>nameList, int index, int remainWeight) {
		if(index==N) {
			return;
		}
		if(solve(index, remainWeight) == solve(index+1, remainWeight)) {
			restruct(nameList, index+1, remainWeight);
		} else {
			nameList.add(itemList[index].name);
			restruct(nameList, index+1, remainWeight-itemList[index].w);
		}
	}
//	public static int solve(int index, int remainWeight, int sum ,Item[] itemList) {
//		int currentWeight = index==-1? 0 : itemList[index].w;
//		int currentHope = index==-1? 0 : itemList[index].hope;
//		remainWeight= remainWeight-currentWeight;
//		
//		if(cache[index+1][remainWeight]!=-1) {
//			System.out.println("herere");
//			System.out.println("index : "+ (index+1));
//			System.out.println("remainWeight : "+ remainWeight);
//			return cache[index+1][remainWeight];
//		}
//		int ret = currentHope;
//		int temp =0;
//		for(int next= index+1;next<itemList.length;next++) {
//			if(index==-1 || remainWeight >= itemList[next].w ) {
//				int maxHopeByNext = solve(next,remainWeight, sum+currentHope, itemList);
//				if(temp< maxHopeByNext) {
//					temp = maxHopeByNext;
//					choices[index+1]=next; 
//				}
//			}
//		}
//		ret += temp;
//		cache[index+1][remainWeight]=ret;
//		return ret;
//	}
	public static void makeList(int index, ArrayList<String> arrayList, Item[] itemList, int sum) {
		
		if(index!=-1) {
			if(sum + itemList[index].w<=maxWeight) {
				arrayList.add(itemList[index].name);
				sum += itemList[index].w;
			} else {
				return;
			}
		}
		System.out.println("index : "+index);
		int nextIndex = choices[index+1];
		if(nextIndex!=-1) {
			makeList(nextIndex, arrayList, itemList, sum);
		}
	}
}
