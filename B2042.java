import java.util.Scanner;
// 구간 합 구하기 
// 펜윅트리, 세그먼트 트리 
//어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다. 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.
public class B2042 {
	public static class FenwickTree {
		int size;
		long[] arr;
		public FenwickTree(int size) {
			this.size= size;
			this.arr= new long[size+1];
		}
		// 0~position까지의 합;
		public long sum(int position) {
			position++;
			long ret = 0;
//			System.out.println("초기 position : "+ position);
			while(position>0) {
//				System.out.println("while position : "+ position);
				ret += arr[position];
				position &= (position-1); 
			}
//			System.out.println();
			return ret;
		}
		// position의 값을 value만큼 증가시켜준다.
		public void update(int position, long value) {
			position++;
			while(position<arr.length) {
				arr[position]+= value;
				position += position&(-position);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs = sc.nextLine().split(" ");
		// N개의 수
		int N= Integer.parseInt(inputs[0]);
		FenwickTree fenwickTree = new FenwickTree(N);
		//변경 횟수
		int M = Integer.parseInt(inputs[1]);
		//구간의합 구하는 수 
		int K = Integer.parseInt(inputs[2]);
		long[] input = new long[N];
		for(int i=0;i<N;i++) {
			input[i]= Long.parseLong(sc.nextLine());
			fenwickTree.update(i, input[i]);
		}
		
		for(int i=0;i<M+K;i++) {
			String[] inputForPrint = sc.nextLine().split(" ");
			int a = Integer.parseInt(inputForPrint[0]);
			int b = Integer.parseInt(inputForPrint[1]);
			long c= Long.parseLong(inputForPrint[2]);
			// 변경 
			if(a==1) {
				long diff = c-input[b-1];
				fenwickTree.update(b-1, diff);
				input[b-1]=c;
			// 출력 
			} else if (a==2) {
				System.out.println( fenwickTree.sum((int)c-1)-fenwickTree.sum(b-2) );
			}
		}
	}
}
