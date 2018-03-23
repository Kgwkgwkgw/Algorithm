import java.util.ArrayList;
import java.util.Scanner;

public class GujongMan747 {
	public static class RangeTree {
		int n;
		int[] arr;
		public RangeTree(ArrayList<Integer> arrayList) {
			this.n= arrayList.size();
			arr = new int[n*4];
			makeRangeTree(arrayList,1, 0, n-1);
		}
		public int makeRangeTree(ArrayList<Integer> arrayList, int nodeNumber, int left, int right) {
			if(left==right) {
				arr[nodeNumber]=arrayList.get(left);
				return arr[nodeNumber];
			}
			int mid = (left+right)/2;
			int leftMin = makeRangeTree(arrayList, nodeNumber*2, left, mid);
			int rightMin = makeRangeTree(arrayList, nodeNumber*2+1, mid+1, right);
			arr[nodeNumber]= Math.min(leftMin, rightMin);
			return arr[nodeNumber];
		}
		public int query(int left, int right) {
			return query(1, left, right, 0, n-1);
		}
		private int query(int serialNumber, int left, int right, int nodeLeft, int nodeRight) {
			if(left>nodeRight || right<nodeLeft ) {
				return 100_000;
			}
			if(left<=nodeLeft&& nodeRight<= right) {
				return arr[serialNumber];
			}
			int mid = (nodeLeft+nodeRight)/2;
			int queryLeft = query(serialNumber*2, left, right, nodeLeft, mid);
			int queryright = query(serialNumber*2+1, left, right, mid+1, nodeRight);
			return Math.min(queryright, queryLeft);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		ArrayList<Integer>[] adjList = new ArrayList[N];
		for(int i=0;i<adjList.length;i++) {
			adjList[i]= new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			adjList[sc.nextInt()].add(i);
		}
		KinshipCalculator kinshipCalculator = new KinshipCalculator(adjList);
		for(int i=0;i<Q;i++) {
			System.out.println(kinshipCalculator .getDistance(sc.nextInt(), sc.nextInt()));
		}
	}
	
	public static class KinshipCalculator {
		public static int nextSerialNumber=0;
		public static int[] serial2OriginNumber;
		public static int[] origin2SerialNumber;
		public static int[] depthArr;
		public static int[] firstFindIndex;
		RangeTree rangeTree;
		
		public KinshipCalculator(ArrayList<Integer>[] adjList) {
			serial2OriginNumber = new int[adjList.length];
			origin2SerialNumber = new int[adjList.length];
			depthArr = new int[adjList.length];
			firstFindIndex  = new int[adjList.length];
			
			ArrayList<Integer> preOrderListBySerialNumber = preProcessing(adjList);
			rangeTree= new RangeTree(preOrderListBySerialNumber);
			
		}
		public ArrayList<Integer> preProcessing(ArrayList<Integer>[] adjList) {
			nextSerialNumber = 0;
			
			ArrayList<Integer> preOrderListBySerialNumber = new ArrayList<>();
			preOrder(0, adjList, preOrderListBySerialNumber, 0 );
			return preOrderListBySerialNumber;
		}
		public int getDistance(int originI, int originJ) {
			int serialI = firstFindIndex[originI];
			int serialJ = firstFindIndex[originJ];
			
			if(serialI>serialJ) {
				serialI^=serialJ;
				serialJ^=serialI;
				serialI^=serialJ;
			}
			int lcaDepth = depthArr[serial2OriginNumber[rangeTree.query(serialI, serialJ)]];
			return depthArr[origin2SerialNumber[originI]]+depthArr[origin2SerialNumber[originJ]]-2*lcaDepth;
		}
		public void preOrder(int originNumber, ArrayList<Integer>[] adjList, ArrayList<Integer> preOrderListBySerialNumber, int depth) {
			origin2SerialNumber[originNumber]=nextSerialNumber;
			serial2OriginNumber[nextSerialNumber]=originNumber;
			firstFindIndex[originNumber]=preOrderListBySerialNumber.size();
			
			depthArr[originNumber]= depth;
			preOrderListBySerialNumber.add(nextSerialNumber);
			
			nextSerialNumber++;
			
			for(int i=0;i<adjList[originNumber].size();i++) {
				preOrder(adjList[originNumber].get(i), adjList, preOrderListBySerialNumber, depth+1);
				preOrderListBySerialNumber.add(originNumber);
			}
		}
	}
}
