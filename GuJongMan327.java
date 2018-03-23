import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuJongMan327 {
	public static ArrayList<String> words;
	public static int allSize;
	public static int k;
	public static boolean isIncluded(String input) {
		for(int i=0;i<words.size();i++) {
			String word = words.get(i);
			int wordIndex=0;
			int inputIndex=0;
			while(wordIndex < word.length() && inputIndex < input.length()) {
				if(word.charAt(wordIndex)== input.charAt(inputIndex)) {
					inputIndex++;
					wordIndex++;
				} else {
					wordIndex++;
				}
			}
			if(wordIndex<=word.length() && inputIndex== input.length()) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) {
			k = Integer.parseInt(sc.nextLine());
			words = new ArrayList<>();
			
			
			allSize=0;
			for(int i=0;i<k;i++) {
				String input = sc.nextLine();
				if(isIncluded(input)) {
					k--;
				}else {
					words.add(input);
					allSize+=input.length();
				}
			}
			overlapCount = new int[k][k];
			cache= new int[k][1<<k];
			for(int i=0;i<cache.length;i++) {
				Arrays.fill(cache[i], -1);
			}
			overlap();
			int result=0;
			int max=0;
			for(int i=0;i<k;i++) {
				int ret = solve(i,1<<i);
				if(ret> result) {
					result =ret;
					max = i;
					if(i==1) {
						System.out.println(result);
					}
				}
			}
			for(int i=0;i<overlapCount.length;i++) {
				System.out.println(Arrays.toString(overlapCount[i]));
			}
			System.out.println(words.get(max) + reconstruct(max, 1<<max));
		}
	}
	public static String reconstruct(int current, int visited) {
		if(visited == (1<<k)-1) {
			return "";
		}
		for(int next =0; next<k;next++ ) {
			if((visited & (1<<next))>0) {
				continue;
			}
			int ifUsed = overlapCount[current][next]+ solve(next, visited | 1<<next);
			if( ifUsed == solve(current,visited)) {
				System.out.println(" words[next].substring(overlapCount[current][next]) : "+  words.get(next).substring(overlapCount[current][next]));
				System.out.println("next : " + next);
				return words.get(next).substring(overlapCount[current][next])+reconstruct(next, visited | 1<<next);
			}
		}
		return null;
	}
	public static int[][] cache;
	public static int solve(int current, int visited) {
		if(visited== (1<<k)-1) {
			return 0;
		}
		if(cache[current][visited]!=-1) {
			return cache[current][visited];
		}
		int ret = 0;
		for(int next = 0;next<k;next++) {
			if((visited & (1<<next))>0) {
				continue;
			}
			ret = Math.max(ret, overlapCount[current][next]+ solve(next, visited | 1 << next));
		}
		cache[current][visited]= ret;
		return ret;
	}
	public static int[][] overlapCount;
	// preCalc;
	public static int overlap() {
		for(int before=0;before<words.size();before++) {
			for(int after=0;after<words.size();after++) {
				if(before==after) {
					continue;
				}
				int beforeIndex= 0;
				int afterIndex= 0;
				int count =0;
				while(beforeIndex< words.get(before).length() && afterIndex < words.get(after).length()) {
					if(words.get(before).charAt(beforeIndex) == words.get(after).charAt(afterIndex)) {
						beforeIndex++;
						afterIndex++;
						count++;
					} else {
						beforeIndex++;
						count = 0;
						afterIndex=0;
					}
				}
				overlapCount[before][after] =count;
			}
		}
		return 0;
	}
}
