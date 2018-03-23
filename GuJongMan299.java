import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GuJongMan299 {
	public static int[] arr = { 2,1,4,3,6,5,8,7 };
	public static int n = 8;
	public static int k = 16;
	public static class A {
		int value =0;
	}
	public static void solve(int count, A a) {
		if(count==8) {
			return;
		}
		solve(count+1, a);
		a.value++;
		if(a.value==3) {
			System.out.println(count);
		}
	}
	public static void main(String[] args) {
		solve(0, new A());
		System.out.println("--");
		System.out.println(calcLongest(-1) - 1);
		
		System.out.println(countLongest(-1));
		System.out.println(Arrays.toString(cache));
		System.out.println(Arrays.toString(countCache));
		ArrayList<Integer> result = new ArrayList<>();
		getKth(-1, result, k - 1);
		System.out.println(result);
	}

	public static int[] cache = new int[arr.length + 1];
	public static int[] countCache = new int[arr.length + 1];
	static {
		Arrays.fill(cache, -1);
		Arrays.fill(countCache, -1);
	}

	public static int calcLongest(int index) {
		if (cache[index + 1] != -1) {
			return cache[index + 1];
		}
		int ret = 1;
		for (int i = index + 1; i < n; i++) {
			if (index == -1 || arr[index] < arr[i]) {
				ret = Math.max(ret, calcLongest(i) + 1);
			}
		}
		cache[index + 1] = ret;
		return ret;
	}

	public static int countLongest(int index) {
		if (calcLongest(index) == 1) {
			return 1;
		}
		if (countCache[index + 1] != -1) {
			return countCache[index + 1];
		}
		int ret = 0;
		for (int i = index + 1; i < n; i++) {
			if ((index == -1 || arr[index] < arr[i]) && calcLongest(index) == calcLongest(i) + 1) {
				ret = Math.max(ret, countLongest(i) + ret);
			}
		}
		countCache[index + 1] = ret;
		return ret;
	}

	public static class Pair implements Comparable<Pair> {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}

	public static void getKth(int index, ArrayList<Integer> result, int k) {
		if (index != -1) {
			result.add(arr[index]);
		}
		ArrayList<Pair> pairList = new ArrayList<>();
		for (int i = index + 1; i < arr.length; i++) {
			if ((index == -1 || arr[index] < arr[i]) && calcLongest(index) == calcLongest(i) + 1) {
				pairList.add(new Pair(arr[i], i));
			}
		}
		Collections.sort(pairList);
		for (int i = 0; i < pairList.size(); i++) {
			if (k >= countLongest(pairList.get(i).index)) {
				k -= countLongest(pairList.get(i).index);
			} else {
				getKth(pairList.get(i).index, result, k);
				return;
			}
		}
	}
}
