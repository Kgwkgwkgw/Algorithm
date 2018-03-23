import java.util.Scanner;

public class WildCard {
	public static int counter;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String wildCardPattern = sc.nextLine();
		Integer fileCount = Integer.parseInt(sc.nextLine());
		String[] fileName = new String[fileCount];
		for(int i=0;i<fileCount;i++) {
			fileName[i] = sc.nextLine();
		}
		for(int i=0;i<fileCount;i++) {
			if(solve(wildCardPattern, fileName[i])) {
				System.out.println(fileName[i]);
				counter++;
			}
		}
		System.out.println(counter);
	}
	public static boolean solve(String wildCardPattern, String input) {
		System.out.println("wildCardPattern : " + wildCardPattern);
		System.out.println("input : " +input);
		int index =0;
		while(index < wildCardPattern.length() && index < input.length() && 
				(wildCardPattern.charAt(index)=='?'|| wildCardPattern.charAt(index) == input.charAt(index) )
			) {
			index++;
		}
		if(index == wildCardPattern.length()) {
			return index == input.length();
		}
		
		
		if(wildCardPattern.charAt(index)=='*') {
			if(index== wildCardPattern.length()-1) {
				return true;
			}
			if(solve(wildCardPattern.substring(index+1), input.substring(index)) || (index< input.length() &&  solve(wildCardPattern.substring(index), input.substring(index+1)))) {
				return true;
			}
//			for(int i=index;i<=input.length();i++) {
//				if(solve(wildCardPattern.substring(index+1), input.substring(i))) {
//					return true;
//				}
//			}
		}
		return false;
//		if(input.length()==0) {
//			return false;
//		}
//		if(wildCardPattern.length()==0) {
//			return false;
//		}
//		if(wildCardPattern.charAt(0)=='?') {
//			return solve(wildCardPattern.substring(1), input.substring(1));
//		}
//		if(wildCardPattern.charAt(0)=='*') {
//			if(wildCardPattern.length()==1) {
//				return true;
//			}
//			boolean flag = false;
//			for(int i=0;i<input.length();i++) {
//				if(solve(wildCardPattern.substring(1),input.substring(i))) {
//					flag = true;
//					break;
//				}
//			}
//			return flag;
//		}
//		if(wildCardPattern.charAt(0)==input.charAt(0)) {
//			if(input.length()==1)
//				return true;
//			return solve(wildCardPattern.substring(1), input.substring(1));
//		}
//		return false;
		
	}
}
