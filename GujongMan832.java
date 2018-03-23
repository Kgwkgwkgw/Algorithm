import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GujongMan832 {
	public static int[][] adj;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.nextLine());
		while(C-->0) {
			adj = new int[26][26];
			int n = Integer.parseInt(sc.nextLine());
			String[] stringList = new String[n];
			for(int i=0;i<n;i++) {
				stringList[i]= sc.nextLine();
			}
			
			for(int i=0;i<n-1;i++) {
				String current = stringList[i];
				String next = stringList[i+1];
				int minLength = Math.min(current.length(), next.length());
				
				for(int j=0;j<minLength;j++) {
					if(current.charAt(j)!=next.charAt(j)) {
						adj[current.charAt(j)-'a'][next.charAt(j)-'a']=1;
						break;
					}
				}
			}
			for(int i=0;i<26;i++) {
				System.out.println(Arrays.toString(adj[i]));
			}
			dfsAll();
			if(isCycle) {
				System.out.println("Invalid Hypothesis");
			} else {
				Collections.reverse(resultList);
				System.out.println(resultList);
			}
			
		}
	}
	public static int[] visited;
	public static boolean isCycle;
	public static void dfsAll() {
		visited= new int[26];
		resultList = new ArrayList<>();
		isCycle=false;
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==0) {
				dfs(i);
			}
		}
	}
	public static ArrayList<Character> resultList;
	//0은 안방문, -1은 진행중, 1은 완료
	public static void dfs(int i) {
		visited[i]=-1;
		for(int j=0;j<adj[i].length;j++) {
			if(adj[i][j]==1 && visited[j]==0) {
				dfs(j);
			} else if(adj[i][j]==1 && visited[j]==-1) {
//				System.out.println("i : "+ i );
//				System.out.println("i to char : "+ (char)(i+'a'));
//				System.out.println("j : "+ j);
//				System.out.println("j to char : "+ (char)(j+'a'));
				isCycle=true;
			}
		}
		visited[i]=1;
		resultList.add((char)('a'+i));
	}
}
