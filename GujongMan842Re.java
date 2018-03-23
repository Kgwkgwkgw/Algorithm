import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GujongMan842Re {
	public static ArrayList<String> inputStgringList[][];
	public static int [][] adjList;
	public static int[] outDegree;
	public static int[] inDegree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = Integer.parseInt(sc.nextLine());
		while(C-->0) {
			int t = Integer.parseInt(sc.nextLine());
			inputStgringList= new ArrayList[26][26];
			adjList= new int[26][26];
			outDegree= new int[26];
			inDegree= new int[26];
			for(int i=0;i<t;i++) {
				String input = sc.nextLine();
				int first = input.charAt(0)-'a';
				int last = input.charAt(input.length()-1)-'a';
				
				if(inputStgringList[first][last]==null) {
					inputStgringList[first][last]= new ArrayList<>();
				}
				inputStgringList[first][last].add(input);
				adjList[first][last]++;
				outDegree[first]++;
				inDegree[last]++;
			}
			ArrayList<Integer> resultList = dfsAll();
			if(resultList==null) {
				System.out.println("Impossible");
			} else {
				if(resultList.size() == t+1) {
					Collections.reverse(resultList);
					System.out.println(resultList);
					StringBuilder sb = new StringBuilder();
					for(int i=0;i<resultList.size()-1;i++) {
						sb.append(inputStgringList[resultList.get(i)][resultList.get(i+1)].remove(0));
						sb.append(" ");
					}
					System.out.println(sb.toString());
				} else {
					System.out.println("Impossible");
				}
			}
		}
		
	}
	public static boolean isEueror() {
		int outDegreeOneMoreCount =0;
		int inDegreeOneMoreCount=0;
		for(int i=0;i<26;i++) {
			int diff = outDegree[i]-inDegree[i];
			if(diff>1 || diff <-1) {
				return false;
			} else if (diff==-1) {
				inDegreeOneMoreCount++;
			} else if(diff==1) {
				outDegreeOneMoreCount++;
			}
		}
		return (inDegreeOneMoreCount==1 && outDegreeOneMoreCount==1) || (inDegreeOneMoreCount==0 && outDegreeOneMoreCount==0);
	}
	public static ArrayList<Integer> dfsAll() {
		if(!isEueror()) {
			return null;
		}
		ArrayList<Integer> resultList= new ArrayList<>();
		for(int i=0;i<26;i++) {
			if(outDegree[i]== inDegree[i]+1) {
				dfs(i, resultList);
				return resultList;
			}
		}
		for(int i=0;i<26;i++) {
			if(outDegree[i]>0) {
				dfs(i, resultList);
				return resultList;
			}
		}
		return resultList;
	}
	public static void dfs(int i, ArrayList<Integer> resultList) {
		for(int j=0;j<26;j++) {
			while(adjList[i][j]>0) {
				adjList[i][j]--;
				dfs(j,resultList);
			}
		}
		resultList.add(i);
	}
}
