import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class B2879 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] current = new int[N];
		int[] tobe= new int[N];
		int[] diff= new int[N];
		int count =0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			current[i]= sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			tobe[i]= sc.nextInt();
			diff[i]= tobe[i]-current[i];
		}
		boolean isPlus =false;
		for(int i=0;i<N;i++) {
//			System.out.println("stack의 상태가? : "+stack);
//			System.out.println("diff[i] : "+diff[i] );
			if(stack.isEmpty()) {
				if(diff[i]==0) {
					continue;
				}
				if(diff[i]>0) {
					isPlus=true;
				} else if(diff[i]<0) {
					isPlus=false;
				} 
				stack.add(diff[i]);
			} else {
				if(diff[i]==0) {
					count+= calcTabCount(stack);
					continue;
				}
				if(isPlus && diff[i]>0) {
					stack.push(diff[i]);
				} else if(isPlus && diff[i]<0) {
					count+= calcTabCount(stack);
					stack.push(diff[i]);
					isPlus=false;
				} else if(!isPlus && diff[i]<0) {
					stack.push(diff[i]);
				} else if(!isPlus && diff[i]>0) {
					count+= calcTabCount(stack);
					stack.push(diff[i]);
					isPlus=true;
				}
			}
		}
		if(!stack.isEmpty()) {
			count+= calcTabCount(stack);
		}
		System.out.println(count);
	}
	public static int calcTabCount(Stack<Integer> stack) {
		int agregate=Math.abs(stack.pop());
		int min = agregate;
		while(!stack.isEmpty()) {
			int pop = Math.abs(stack.pop());
			if(pop<min) {
				min=pop;
			} else if(pop>min) {
				agregate = agregate + (pop-min);
				min =pop;
			}
		}
		return agregate;
	}
}
