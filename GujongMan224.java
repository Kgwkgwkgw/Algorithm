import java.util.Scanner;

//wildcard
//와일드카드 문제
public class GujongMan224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String pattern = sc.nextLine();
		for(int i=0;i<n;i++) {
			cache= new int[101][101];
			String input = sc.nextLine();
			if(solve(pattern, input , 0, 0)==1) {
				System.out.println(input);
			}
		}
	}
	public static int cache[][]= new int[101][101];
	public static int solve(String pattern, String input, int patternIndex, int inputIndex) {
		if(cache[patternIndex][inputIndex]!=0) {
			return cache[patternIndex][inputIndex];
		}
		System.out.println("inputIndex : "+inputIndex);
		System.out.println("input.lnegt() " +input.length());
		while(patternIndex<pattern.length() && inputIndex< input.length() &&
				(pattern.charAt(patternIndex)=='?'|| pattern.charAt(patternIndex)== input.charAt(inputIndex))) {
					patternIndex++;
					inputIndex++;
				}
		if(patternIndex==pattern.length()) {
			if(inputIndex==input.length()) {
				cache[patternIndex][inputIndex]=1;
			} else {
				cache[patternIndex][inputIndex]=-1;
			}
			return cache[patternIndex][inputIndex];
		}
		if(pattern.charAt(patternIndex)=='*') {
			cache[patternIndex][inputIndex]=-1;
			
			for(int i=0;i<input.length();i++) {
				int ret = solve(pattern, input, patternIndex+1, inputIndex+i);
				if(ret==1) {
					cache[patternIndex][inputIndex]=1;
					break;
				}
			}
			return cache[patternIndex][inputIndex];
//			int ret1=solve(pattern, input, patternIndex+1, inputIndex);
//			int ret2=0;
//			if(inputIndex<input.length())
//				ret2= solve(pattern, input, patternIndex, inputIndex+1);
//			if(ret1==1 || ret2==1) {
//				cache[patternIndex][inputIndex]=1;
//			} else {
//				cache[patternIndex][inputIndex]=-1;
//			}
//			return cache[patternIndex][inputIndex];
		}
		
		cache[patternIndex][inputIndex]=-1;
		return cache[patternIndex][inputIndex];
	}
}
