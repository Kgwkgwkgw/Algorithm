import java.util.Stack;

public class Bracket {
//	public static String input ="({[}])";
	public static String input ="({}[(){}])";
	public static String opening = "({[";
	public static String closing= ")}]";
	public static void main(String[] args) {
		if(solve()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	public static boolean solve() {
		Stack<Integer> stack= new Stack<>();
		char[] chArr = input.toCharArray();
		for(int i=0;i<chArr.length;i++) {
			if(opening.indexOf(chArr[i]) !=-1) {
				stack.add(opening.indexOf(chArr[i]));
			}
			else {
				if(stack.isEmpty()) {
					return false;
				}
				if(closing.indexOf(chArr[i]) != stack.pop()) {
					return false;
				}
			}
//			if(chArr[i]=='(' || chArr[i] =='{' || chArr[i] =='[') {
//				stack.add(chArr[i]);
//			} else {
//				if(stack.isEmpty()) {
//					return false;
//				}
//				if(chArr[i]==')') {
//					if(stack.pop()!='(') {
//						return false;
//					}
//				} else if(chArr[i]=='}') {
//					if(stack.pop()!='{') {
//						return false;
//					}
//				} else if(chArr[i]==']') {
//					if(stack.pop()!='[') {
//						return false;
//					}
//				} 
//			}
		}
		return stack.isEmpty();
	}
}
