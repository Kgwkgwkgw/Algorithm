import java.util.Arrays;

public class GujongMan744 {
	public static class RangeResult {
		int maxFrequency;
		
		int leftNumber;
		int leftFrequency;
		int rightNumber;
		int rightFrequncy;
		@Override
		public String toString() {
			return "RangeResult [maxFrequency=" + maxFrequency + ", leftNumber=" + leftNumber + ", leftFrequency="
					+ leftFrequency + ", rightNumber=" + rightNumber + ", rightFrequncy=" + rightFrequncy + "]";
		}
		
	}
	public static class RangeTree{
		int n;
		RangeResult[] rangeResultList;
		public RangeTree (int[] input) {
			n=input.length;
			rangeResultList= new RangeResult[n*4];
			calcRangeFrequency(input,1, 0,n-1);
		}
		public RangeResult calcRangeFrequency(int[] input,int nodeNumber,int left, int right) {
			if(left==right) {
				RangeResult rangeResult = new RangeResult();
				rangeResult.leftNumber= input[left];
				rangeResult.leftFrequency++;
				rangeResult.rightNumber=input[right];
				rangeResult.rightFrequncy++;
				rangeResult.maxFrequency++;
				rangeResultList[nodeNumber]= rangeResult;
				return rangeResult;
			}
			int mid = (left+right)/2;
			RangeResult leftRangeResult = calcRangeFrequency(input,nodeNumber*2,left, mid);
			RangeResult rightRangeResult = calcRangeFrequency(input,nodeNumber*2+1,mid+1, right);
			RangeResult thisRangeResult = new RangeResult();
			
			thisRangeResult.leftNumber=leftRangeResult.leftNumber;
			thisRangeResult.leftFrequency=leftRangeResult.leftFrequency;
			
			thisRangeResult.rightNumber=rightRangeResult.rightNumber;
			thisRangeResult.rightFrequncy=rightRangeResult.rightFrequncy;
			
			thisRangeResult.maxFrequency= Math.max(leftRangeResult.maxFrequency, rightRangeResult.maxFrequency);
			
			if(leftRangeResult.rightNumber==rightRangeResult.leftNumber) {
				thisRangeResult.maxFrequency= Math.max(thisRangeResult.maxFrequency, leftRangeResult.rightFrequncy+rightRangeResult.leftFrequency);
				if(rightRangeResult.rightNumber==rightRangeResult.leftNumber)
					thisRangeResult.rightFrequncy=leftRangeResult.rightFrequncy+rightRangeResult.leftFrequency;
				if(leftRangeResult.rightNumber==leftRangeResult.leftNumber) {
					thisRangeResult.leftFrequency=leftRangeResult.rightFrequncy+rightRangeResult.leftFrequency;
				}
				
			}
			rangeResultList[nodeNumber]= thisRangeResult;
			return thisRangeResult;
		}
		public int query(int left, int right) {
			return query(left, right, 1, 0, n-1).maxFrequency;
		}
		private RangeResult query(int left, int right, int nodeNumber, int nodeLeft, int nodeRight) {
			if(left>nodeRight || right < nodeLeft) {
				return null;
			}
			if(left<= nodeLeft && right>=nodeRight) {
				return rangeResultList[nodeNumber];
			}
			int mid = (nodeLeft+nodeRight)/2;
			RangeResult queryLeft = query(left, right, nodeNumber*2, nodeLeft, mid);
			RangeResult queryRight = query(left, right, nodeNumber*2+1, mid+1, nodeRight);
			
			
			RangeResult thisRangeResult = new RangeResult();
			if(queryLeft!=null) {
				thisRangeResult.leftNumber=queryLeft.leftNumber;
				thisRangeResult.leftFrequency=queryLeft.leftFrequency;
			}
			if(queryRight!=null) {
				thisRangeResult.rightNumber=queryRight.rightNumber;
				thisRangeResult.rightFrequncy=queryRight.rightFrequncy;
			}
			if(queryLeft!=null && queryRight!=null) {
				thisRangeResult.maxFrequency= Math.max(queryLeft.maxFrequency, queryRight.maxFrequency);
				if(queryLeft.rightNumber==queryRight.leftNumber) {
					thisRangeResult.maxFrequency= Math.max(thisRangeResult.maxFrequency, queryLeft.rightFrequncy+queryRight.leftFrequency);
					if(queryRight.rightNumber==queryRight.leftNumber) {
						thisRangeResult.rightFrequncy=queryLeft.rightFrequncy+queryRight.leftFrequency;
					}
					if(queryLeft.rightNumber==queryRight.leftNumber) {
						thisRangeResult.leftFrequency=queryLeft.rightFrequncy+queryRight.leftFrequency;
					}
				}
			} else if(queryRight==null) {
				thisRangeResult.maxFrequency= queryLeft.maxFrequency;
			} else {
				thisRangeResult.maxFrequency= queryRight.maxFrequency;
			}
			return thisRangeResult;
		}
	}
	public static void main(String[] args) {
		int[] input = {0,1,1,1,1,1,1,2};
		RangeTree rangeTree= new RangeTree(input);
		for(int i=0;i<rangeTree.rangeResultList.length;i++) {
			System.out.println(rangeTree.rangeResultList[i]);
		}
		System.out.println(rangeTree.query(1,3));
		
	}
}
