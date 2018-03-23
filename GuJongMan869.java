import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class GuJongMan869 {
	public static class ConferenceTime {
		int start;
		int end;
		public ConferenceTime(int start,int end) {
			this.start= start;
			this.end= end;
		}
	}
	public static ArrayList<Integer>[] adjList;
	public static ArrayList<ConferenceTime> confrenceTimeList;
	public static boolean isNotOverap(ConferenceTime o1, ConferenceTime o2) {
		return o1.end <=o2.start || o2.end<=o1.start;
	}
	public static void makeGraph()  {
		for(int i=0;i<adjList.length/2;i+=2) {
			int j = i+1;
			adjList[2*i+1].add(2*j);
			adjList[2*j+1].add(2*i);
		}
		
		for(int i=0;i<confrenceTimeList.size();i++) {
			for(int j=0;j<i;j++) {
				if(!isNotOverap(confrenceTimeList.get(i), confrenceTimeList.get(j))) {
					adjList[2*i].add(2*j+1);
					adjList[2*j].add(2*i+1);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			adjList = new ArrayList[2*2*n];
			for(int i=0;i<adjList.length;i++) {
				adjList[i]= new ArrayList<>();
			}
			confrenceTimeList= new ArrayList<>();
			for(int i=0;i<n;i++) {
				confrenceTimeList.add(new ConferenceTime(sc.nextInt(), sc.nextInt()));
				confrenceTimeList.add(new ConferenceTime(sc.nextInt(), sc.nextInt()));
			}
			makeGraph();
			tarjanSCC();
			for(int i=0;i<sccId.length;i+=2) {
				if(sccId[i]==sccId[i+1]) {
					System.out.println("IMPOSSIBLE");
					return;
				}
			}
			System.out.println("POSSIBLE");
			ArrayList<ResultSet> resultSetList = new ArrayList<>();
			for(int i=0;i< sccId.length;i++) {
				resultSetList.add(new ResultSet(sccId[i], i));
			}
			Collections.sort(resultSetList);
			System.out.println(resultSetList);
			
			int[] isOk= new int[resultSetList.size()/2];
			Arrays.fill(isOk, -1);
			
			for(int i=0;i<resultSetList.size();i++) {
				ResultSet resultSet = resultSetList.get(i);
				int vertex = resultSet.index/2;
				boolean isTrue = resultSet.index%2==0;
				if(isOk[vertex]!= -1) {
					continue;
				}
				isOk[vertex] = isTrue ? 0 : 1;
			}
			for(int i=0;i<isOk.length;i++) {
				if(isOk[i]==1) {
					System.out.println(confrenceTimeList.get(i).start + " "+confrenceTimeList.get(i).end);
				}
			}
		}
	}
	public static class ResultSet implements Comparable<ResultSet> {
		int sccid;
		int index;
		public ResultSet(int sccid, int index) {
			this.sccid=sccid;
			this.index=index;
		}
		@Override
		public int compareTo(ResultSet o) {
			// TODO Auto-generated method stub
			return o.sccid-this.sccid;
		}
		@Override
		public String toString() {
			return "ResultSet [sccid=" + sccid + ", index=" + index + "]";
		}
		
	}
	public static int[] discovered;
	public static int vertextCounter;
	public static int[] sccId;
	public static int sscIdCounter;
	public static Stack<Integer> stack= new Stack<>();
	public static int scc(int here) {
		discovered[here]= vertextCounter++;
		int ret = discovered[here];
		stack.add(here);
		
		for(int i=0;i<adjList[here].size();i++) {
			int there = adjList[here].get(i);
			if(discovered[there]==-1) {
				ret = Math.min(ret, scc(there));
			} else if(discovered[there]!=-1 && sccId[there]==-1) {
				ret = Math.min(ret,discovered[there]);
			}
		}
		if(ret == discovered[here]) {
			while(true) {
				int pop = stack.pop();
				sccId[pop]= sscIdCounter;
				if(pop==here) {
					break;
				}
			}
			sscIdCounter++;
		}
		return ret;
	}
	public static void tarjanSCC() {
		discovered= new int[adjList.length];
		sccId = new int[adjList.length];
		Arrays.fill(discovered, -1);
		Arrays.fill(sccId, -1);
		
		for(int i=discovered.length-1;i>0;i--) {
			if(discovered[i]==-1) {
				scc(i);
			}
		}
	}
}
