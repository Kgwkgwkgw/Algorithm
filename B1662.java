import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class B1662 {
	public static char[] input;
	// key는 여는 괄호 인덱스, 값은,닫는 괄호 인덱스
	public static HashMap<Integer, Integer> hashMap = new HashMap<>();
	public static ArrayList<Integer> closingInedxList= new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().toCharArray();
		Stack<Integer> openingIndexStack =new Stack<>();
		for(int i=0;i<input.length;i++) {
			if(input[i]=='(') {
				openingIndexStack.push(i);
			} else if(input[i]==')') {
				hashMap.put(openingIndexStack.pop(), i);
			}
			
		}
		System.out.println(solve(0, input.length-1));
	}
	// startIndex는 항상 숫자다. 
	public static int solve(int startIndex, int endIndex) {
		if(startIndex==endIndex) {
			return 1;
		}
		if(startIndex>endIndex) {
			return 0;
		}
		int index= startIndex;
		int ret= 0;
		
		if(input[index+1]>='0' && input[index+1]<='9') {
			ret+= (1+solve(index+1, endIndex));
			return ret;
		} else {
			int thatStartIndex = index+2;
			int thatEndIndex = hashMap.get(index+1)-1;
			ret+= (input[index]-'0') * solve(thatStartIndex, thatEndIndex);
			ret+= solve(hashMap.get(index+1)+1, endIndex);
		}
		return ret;
	}
}