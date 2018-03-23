import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GujongMan831 {
	public static LinkedList<Integer> resultList = new LinkedList<>();
	public static boolean[] visited = new boolean[26];
//	public static LinkedList<Integer> mustVisit = new LinkedList();
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] arr = new int[26][26];
		
		List<String> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String input =sc.nextLine();
			list.add(input);
		}
		
		boolean isvalid = true;
//		for(int i=0;i<max;i++) {
//			for(int j=0;j<n-1;j++) {
//				String current = list.get(j);
//				String next = list.get(j+1);
//				System.out.println(current);
//				System.out.println(next);
//				System.out.println("---");
//				if(i==0) {
//					if(current.length()>i && next.length()>i && current.charAt(i) !=next.charAt(i)  ) {
//						arr[current.charAt(i)-'a'][next.charAt(i)-'a']=1;
//						mustVisit.add(current.charAt(i)-'a');
//						if(arr[next.charAt(i)-'a'][current.charAt(i)-'a'] !=0) {
//							isvalid=false;
//						}
//					}
//				} else {
//					if(current.length()>i && next.length()>i && current.charAt(i) !=next.charAt(i)  &&  current.charAt(i-1) ==next.charAt(i-1)) {
//						arr[current.charAt(i)-'a'][next.charAt(i)-'a']=1;
//						mustVisit.add(current.charAt(i)-'a');
//						if(arr[next.charAt(i)-'a'][current.charAt(i)-'a'] !=0) {
//							isvalid=false;
//						}
//					}
//				}
//				
//			}
//		}
		for(int i=0;i<n-1;i++) {
			String current = list.get(i);
			String next = list.get(i+1);
			for(int j=0;j<current.length();j++) {
				if(next.length()>j) {
					System.out.println("current[charAt] : " +current.charAt(j));
					System.out.println("next[charAt] : " +next.charAt(j));
					if(current.charAt(j) !=next.charAt(j) ) {
						arr[current.charAt(j)-'a'][next.charAt(j)-'a']=1;
						if(arr[next.charAt(j)-'a'][current.charAt(j)-'a'] !=0) {
							isvalid=false;
						}
						break;
					} 
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(!isvalid) {
			System.out.println("INVALID HYPOTHESIS");
		} else {
			dfsAll(arr);
			System.out.println(resultList);
			Iterator<Integer> iter = resultList.descendingIterator();
			while(iter.hasNext()) {
				int next = iter.next();
//				System.out.println(next);
				sb.append((char)('a'+next));
			}
			for(int i=0;i<26;i++) {
				if(!visited[i]) {
					sb.append((char)('a'+i));
				}
			}
			System.out.println(sb.toString());
		}
	}
	public static void dfsAll(int[][] arr) {
//		for(int i=0;i<mustVisit.size();i++) {
//			if(!visited[mustVisit.get(i)])
//				dfs(mustVisit.get(i),arr);
//		}
		
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				dfs(i,arr);
			}
//			for(int j=0;j<arr[i].length;j++) {
//				if(arr[i][j]>0 && !visited[i]) {
//					dfs(i,arr);
//				}
//			} 
		}
	}
	public static void dfs(int i, int[][]arr) {
		visited[i]=true;
		for(int j=0;j<26;j++) {
			if(arr[i][j]>0 && !visited[j]) {
				dfs(j,arr);
			}
		}
		resultList.add(i);
	}
}
