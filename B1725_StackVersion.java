import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B1725_StackVersion {
	//히스토그램
	public static int[] histogram;
	public static int max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		histogram = new int[N];
		//히스토그램의 높이가 키값이고, 시작 위치가 밸유 
		HashMap<Integer, Integer> hashMap= new HashMap<>();
		// Stack은 항상 커버가능한 숫자만 들어가있는다.
		Stack<Integer> stack = new Stack<>();
		int ret= 0; 
		for(int i=0;i<N;i++) {
			histogram[i]=sc.nextInt();
			if(stack.isEmpty()) {
				stack.add(histogram[i]);
				hashMap.put(histogram[i], i);
			} else {
				int peek = stack.peek();
				if(peek < histogram[i]) {
					stack.add(histogram[i]);
					hashMap.put(histogram[i], i);
				} else if(peek> histogram[i]) {
					int pop =peek;
					while(!stack.isEmpty() && stack.peek()>histogram[i]) {
						pop = stack.pop();
						ret = Math.max(ret, pop*(i-hashMap.get(pop)));
					}
					if(!stack.isEmpty() && stack.peek()==histogram[i]) {
						continue;
					}
					stack.push(histogram[i]);
					hashMap.put(histogram[i], hashMap.get(pop));
				}
			}
		}
		while(!stack.isEmpty()) {
			int pop = stack.pop();
			ret= Math.max(ret, (N-hashMap.get(pop))*pop);
		}
		System.out.println(ret);
	}
	
}
