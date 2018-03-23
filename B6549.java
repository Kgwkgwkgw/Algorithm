import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B6549 {
	// 히스그램에서 가장 큰 직사각형 찾기 
	// 스택을 이용해서 구현 시도
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while(true) {
			n = sc.nextInt();
			if(n==0) {
				break;
			}
			long[] arr = new long[n];
			// 증가하는 높이 값들 저장 
			Stack<Long> stack = new Stack<>();
			// 키는 높이이고, 값은 해당 높이로 사각형 만들 떄 쓸 인덱스값 
			HashMap<Long, Integer> map = new HashMap<>();
			// 결과값 
			long ret =0;
			for(int i=0;i<n;i++) {
				arr[i]= sc.nextLong();
				if(stack.isEmpty()) {
					stack.add(arr[i]);
					map.put(arr[i], i);
				} else {
					if(stack.peek()<arr[i]) {
						stack.add(arr[i]);
						map.put(arr[i], i);
					} else if(stack.peek() > arr[i]) {
						long pop=-1;
						while(!stack.isEmpty() && stack.peek()> arr[i]) {
							pop = stack.pop();
//							System.out.println("pop : "+pop);
//							System.out.println("i :  "+ i );
//							System.out.println("map.get(pop) : "+ map.get(pop));
//							System.out.println();
							ret = Math.max(ret, pop*(long)(i-map.get(pop)));
						}
						if(stack.isEmpty() || stack.peek()<arr[i]) {
							map.put(arr[i], map.get(pop));
							stack.add(arr[i]);
						} 
					}
				}
			}
			
			while(!stack.isEmpty()) {
				long pop = stack.pop();
//				System.out.println("pop : "+pop);
//				System.out.println("map.get(pop) : "+ map.get(pop));
//				System.out.println();
				ret = Math.max(ret, pop*(long)(n-map.get(pop)));
			}
			System.out.println(ret);
		}
	}
}
