import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GuJongMan304 {
	public static int n;
	public static int[] arr= {2,1,4,3,6,5,8,7};
	public static void main(String[] args) {
		Arrays.fill(cache, -1);
		Arrays.fill(countCache, -1);
		n = arr.length;
		System.out.println(lis(-1)-1);
		System.out.println(count(-1));
		ArrayList<Integer> result = new ArrayList<>();
		reconstruct(-1, 4-1, result);
		System.out.println(result);
	}
	public static class ResultSet implements Comparable<ResultSet>{
		int index;
		int value;
		public ResultSet(int value, int index) {
			this.value= value;
			this.index= index;
		}
		@Override
		public int compareTo(ResultSet o) {
			// TODO Auto-generated method stub
			return this.value -o.value;
		}
	}
	public static void reconstruct(int start, int skip, ArrayList<Integer> resultList) {
		if(start!=-1)
			resultList.add(arr[start]);
		
		ArrayList<ResultSet> resultSetList = new ArrayList<>();
		for(int next = start+1;next<n;next++) {
			if( (start==-1 || arr[start]< arr[next]) && lis(start)== lis(next)+1) {
				resultSetList.add(new ResultSet(arr[next], next));
			}
		}
		Collections.sort(resultSetList);
		for(int i=0;i< resultSetList.size();i++) {
			ResultSet resultSet = resultSetList.get(i);
			if(skip >= count(resultSet.index)) {
				skip -= count(resultSet.index);
			} else {
				reconstruct(resultSet.index, skip, resultList);
				break;
			}
		}
	}
	public static int[] cache= new int[500+1];
	public static int[] countCache= new int[500+1];
	// index부터 시작하는 lis의 개수
	public static int count(int index) {
		if(lis(index)==1) {
			return 1;
		}
		if(countCache[index+1]!=-1) {
			return countCache[index+1];
		}
		int ret = 0;
		for(int next= index+1;next<n;next++) {
			if((index==-1 || arr[index]< arr[next]) && lis(index) == lis(next)+1)  {
				ret += count(next); 
			}
		}
		countCache[index+1]= ret;
		return ret;
	}
	public static int lis(int index) {
		if(index==n) {
			return 0;
		}
		if(cache[index+1]!=-1) {
			return cache[index+1];
		}
		int ret =1;
		for(int next = index+1;next<n;next++) {
			if(index==-1 || arr[index]< arr[next]) {
				ret =  Math.max(ret, lis(next)+1);
			}
		}
		cache[index+1] = ret;
		return ret;
	}
}
