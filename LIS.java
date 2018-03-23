import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LIS {
	public static int[] arr = {4,7,6,9,8,10};
	public static void main(String[] args) {
		Arrays.fill(cache, -1);
		Arrays.fill(cacheCount, -1);
		System.out.println(solve(-1)-1);
//		System.out.println(ret);
		System.out.println(Arrays.toString(next));
		ArrayList<Integer>list = new ArrayList<>();
		
		makeList(-1, list);
		System.out.println(list);
		System.out.println(count(-1));
		System.out.println(Arrays.toString(cacheCount));
		ArrayList<Integer>  kthList = new ArrayList<>();
		getKth(-1, 3, kthList);
		System.out.println(kthList);
	}
	public static int[] cache= new int[100];
	public static int[] next= new int[100];
	public static int solve(int index) {
		if(index>=arr.length) {
			return 0;
		}
		if(cache[index+1]!=-1) {
			return cache[index+1];
		}
		int ret =0;
		int nextIndex = -1;
		for(int i= index+1;i<arr.length;i++) {
			if(index==-1 || arr[index]< arr[i]) {
				int nextLongestLength = solve(i);
				if(ret < nextLongestLength) {
					ret = nextLongestLength;
					nextIndex = i;
				}
			}
		}
		ret++;
		cache[index+1]=ret;
		next[index+1]= nextIndex;
		return ret;
	}
	public static int[] cacheCount=new int[100];
	public static int count(int index) {
		if(solve(index)==1) {
			return 1; 
		}
		if(cacheCount[index+1]!=-1) {
			return cacheCount[index+1];
		}
		int ret =0;
		for(int i=index+1;i<arr.length;i++) {
			if( (index==-1 || arr[index]<arr[i]) && solve(index) == solve(i)+1) {
				ret += count(i);
			}
		}
		cacheCount[index+1]= ret;
		return ret;
	}
	public static class Pair implements Comparable<Pair>{ 
		int value;
		int index;
		public Pair(int value, int index) {
			this.value = value;
			this.index= index;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.value- o.value;
		}
		
	}
	public static void getKth(int index, int k, ArrayList<Integer> kthList) {
		if(index!=-1) {
			kthList.add(arr[index]);
		}
		
		ArrayList<Pair> arrayList= new ArrayList<>();
		for(int i = index+1;i<arr.length;i++) {
			if((index==-1 || arr[index]<arr[i]) && solve(index) == solve(i)+1) {
				arrayList.add(new Pair(arr[i], i));
			}
		}
		Collections.sort(arrayList);
		for(int i=0;i<arrayList.size();i++) {
			Pair pair = arrayList.get(i);
			if(count(pair.index)<=k) {
				k-=count(pair.index);
			} else {
				getKth(pair.index, k, kthList);
				break;
			}
		}
	}
	public static void makeList(int index, ArrayList<Integer>list ) {
		if(index!=-1) {
			list.add(arr[index]);
		}
		int nextIndex = next[index+1];
		if(nextIndex!=-1) {
			makeList(nextIndex, list);
		}
	}
}
