import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GujongMan842_2 {
	public static int[][] adj = new int[26][26];
	public static int[] inDegree = new int[26];
	public static int[] outDegree = new int[26];
	public static Queue<String>[][] edge = new LinkedList[26][26];
	static {
		for(int i=0;i<26;i++) {
			for(int j=0;j<26;j++) {
				edge[i][j]= new LinkedList<String>();
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		LinkedList<String> stringList= new LinkedList<>(); 
		for(int i=0;i<n;i++) {
			stringList.add(sc.nextLine());
		}
		System.out.println(solve(stringList));
		
	}
	public static String solve(LinkedList<String> stringList) {
		makeGraph(stringList);
		if(!isEulr()) {
			return "IMPOSSIBLE";
			
		}
		ArrayList<Integer> list = getCircuitOrTrail();
		if(list.size()!= stringList.size()+1) {
			return "IMPOSSIBLE";
		}
		StringBuilder sb = new StringBuilder();
		for(int i=list.size()-1;i>0;i--) {
			int from = list.get(i);
			int to = list.get(i-1);
			sb.append(edge[from][to].poll()+ " ");
		}
		return sb.toString();
	}
	public static ArrayList<Integer> getCircuitOrTrail() {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<26;i++) {
			if(outDegree[i]== inDegree[i]+1) {
				return getEulr(i, list);
			}
		}
		for(int i=0;i<26;i++) {
			if(outDegree[i]>0) {
				return getEulr(i, list);
			}
		}
		return list;
	}
	public static ArrayList<Integer> getEulr(int start, ArrayList<Integer> list) {
		for(int next=0;next<adj[start].length;next++) {
			if(adj[start][next]>0) {
				adj[start][next]--;
				getEulr(next, list);
			}
		}
		list.add(start);
		return list;
	}
	public static boolean isEulr() {
		int minus = 0;
		int plus = 0;
		for(int i=0;i<26;i++) {
			int d = outDegree[i]-inDegree[i];
			if(d>1|| d<-1)
				return false;
			if(d == -1) 
				minus++;
			if(d == 1) 
				plus++;
		}
		return (minus==1 && plus== 1) || (minus==0 && plus==0);
	}
	public static void makeGraph(LinkedList<String> stringList) {
		for(int i=0;i<stringList.size();i++) {
			String st = stringList.get(i);
			int from = st.charAt(0)-'a';
			int to = st.charAt(st.length()-1)-'a';
			adj[from][to]++;
			inDegree[to]++;
			outDegree[from]++;
			edge[from][to].add(st);
		}
	}
}
