import java.util.ArrayList;
import java.util.Arrays;

import javax.print.attribute.standard.Finishings;

public class GuJongMan856 {
	//절단점 찾기
	public static int[][] adj = {
			{0,1,0,0,0,0,0,0},
			{1,0,1,1,0,0,0,0},
			{0,1,0,1,0,1,0,0},
			{0,1,1,0,1,1,0,0},
			{0,0,0,1,0,0,0,0},
			{0,0,1,1,0,0,1,1},
			{0,0,0,0,0,1,0,0},
			{0,0,0,0,0,1,0,0}
	};
	public static void main(String[] args) {
		System.out.println(findCutVertex());
		System.out.println(Arrays.toString(isCutvertex));
	}
	public static ArrayList<Integer> findCutVertex() {
		ArrayList<Integer> resultList = new ArrayList<>();
		finished= new boolean[adj.length];
		discovered= new int[adj.length];
		Arrays.fill(discovered, -1);
		dfs(0, resultList,true);
		return resultList;
	}
	public static boolean[] isCutvertex= new boolean[adj.length];
	public static boolean[] finished;
	public static int[] discovered;
	public static int counter =0;
	public static int dfs(int here, ArrayList<Integer> resultList, boolean isRoot) {
//		System.out.println("here : "+here);
		discovered[here]= counter++;
		int ret =discovered[here];
		int children =0;
		for(int i=0;i<adj[here].length;i++) {
			if(adj[here][i]> 0) {
				if(discovered[i]==-1) {
					children++;
					int result = dfs(i,resultList, false);
					if(!isRoot&& result>=discovered[here]) {
						isCutvertex[here]=true;
					}
					ret = Math.min(ret, result);
				} else {
					ret = Math.min(ret, discovered[i]);
				}
			}
		}
		if(isRoot) {
			isCutvertex[here]= (children>=2);
		}
		return ret;
	}
}
