import java.util.Scanner;

public class GuJongMan306 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 42;
		int p = 764853475;
		int l = 30;
		StringBuilder sb = new StringBuilder();
		preCalc();
		for(int index=0;index<l;index++) {
			sb.append(solve("FX", n, p+index-1));
		}
		System.out.println(sb);
	}
	// x 혹은 y를 index세대 만큼 진화시켰을 때의 결과 길이.
	public static int[] length= new int[50];
	public static void preCalc() {
		length[0]=1;
		for(int i=1;i<length.length;i++) {
			length[i]= Math.min(1_000_000_001,length[i-1]*2 + 2);
		}
	}
	public static String expandX = "X+YF";
	public static String expandY = "FX-Y";
	public static char solve(String str, int genertaion, int skip) {
		if(genertaion==0) {
			return str.charAt(skip);
		}
		for(int i = 0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='X' || ch == 'Y') {
				if(skip>= length[genertaion]) {
					skip -= length[genertaion];
				} else if(ch=='X') {
					return solve(expandX, genertaion-1, skip);
				} else {
					return solve(expandY, genertaion-1, skip);
				}
			} else if(skip>0) {
				skip--;
			} else {
				return ch;
			}
		}
		return '#';
	}
}
