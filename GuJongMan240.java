import java.util.Arrays;
import java.util.Scanner;

public class GuJongMan240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while(t-->0) { 
			String input = sc.nextLine();
			cache= new int[input.length()];
			Arrays.fill(cache, -1);
			System.out.println(sovle(0,input));
			System.out.println(Arrays.toString(cache));
		}
		
	}
	public static int[] cache;
	public static int sovle(int index, String input) {
		if(index>=input.length()) {
			return 0;
		}
		if(cache[index]!=-1) {
			return cache[index];
		}
		int ret =100000;
		for(int i=3;i<6;i++) {
			if(index+i-1 <input.length()) {
				int level = getNanido(index, index+i-1, input);
				ret= Math.min(ret,sovle(index+i,input)+level);
			}
		}
		cache[index]=ret;
		return cache[index];
	}
	public static int getNanido(int start, int end, String input) {
//		if(start==3) {
//			System.out.println("ㄸㄸ");
//		}
		boolean isAllSame= true;
		for(int i=start;i<end;i++) {
			if(input.charAt(i)!=input.charAt(i+1)) {
				isAllSame=false;
				break;
			}
		}
		if(isAllSame) {
			return 1;
		}
		boolean isOneIncrementOrDecremnet= true;
		int d = (input.charAt(start+1)-'0')-(input.charAt(start)-'0');
		if(start==0&& end==3) {
			System.out.println("d : "+d);
		}
		for(int i=start;i<end;i++) {
			if(i== start) {
				if( d!= 1 && d!= -1) {
					isOneIncrementOrDecremnet=false;
					break;
				}
			}
			if((input.charAt(i+1)-'0')-(input.charAt(i)-'0') != d ) {
				isOneIncrementOrDecremnet =false;
			}
		}
		if(isOneIncrementOrDecremnet) {
			return 2;
		}
		
		boolean isAlternate = true;
		int[] num = new int[2];
		if(start%2==1) {
			num[start%2] = input.charAt(start)- '0';
			num[(start)%2-1]=input.charAt(start+1)-'0';
		} else {
			num[start%2] = input.charAt(start)- '0';
			num[(start)%2+1]=input.charAt(start+1)-'0';
		}
		int num2 = input.charAt(start+1)-'0';
		for(int i=start;i<=end;i++) {
			int value = input.charAt(i)-'0';
			if(start%2==1) {
				if(i%2==1) {
					if(value!=num[start%2]) {
						isAlternate=false;
						break;
					} 
				} else {
					if(value!=num[(start)%2-1]) {
						isAlternate=false;
						break;
					}
				}
			} else {
				if(i%2==0) {
					if(value!=num[start%2]) {
						isAlternate=false;
						break;
					} 
				} else {
					if(value!=num[(start)%2+1]) {
						isAlternate=false;
						break;
					}
				}
			}
		}
		if(isAlternate) {
			return 4;
		}
		boolean isDuencah =true;
		for(int i=start;i<end;i++) {
			if( (input.charAt(i+1)-'0')-(input.charAt(i)-'0') != d) {
				isDuencah=false;
				break;
			}
		}
		if(isDuencah) {
			return 5;
		}
		return 10;
	}
}
