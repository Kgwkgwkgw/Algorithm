import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class B10827 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inputs= sc.nextLine().split(" ");
//		String a= "1.1";
//		System.out.println(Arrays.toString(a.split("\\.")));
//		System.out.println(Arrays.toString(inputs[0].split("\\.")));
		String[] input= inputs[0].split("\\.");
		int jisu = Integer.parseInt(inputs[1]);
		int sosuLength=0;
		if(input.length==2) {
			input[0]= input[0]+input[1];
			sosuLength = input[1].length()*jisu;
			for(int i=0;i<input[1].length();i++) {
				if(input[1].charAt(i)-'0'==0) {
					sosuLength-= jisu*1;
				} else {
					break;
				}
			}
		}
		
		BigDecimal bigDecimal = new BigDecimal(input[0]);
		bigDecimal= bigDecimal.pow(jisu);
		
		String result = bigDecimal.toString();
//		System.out.println(result);
		if(sosuLength==0) {
			System.out.println(result);
			return;
		} else if(result.length()<sosuLength) {
			for(int i=1;i<sosuLength;i++) {
				result= "0"+result;
			}
			result= "0."+result;
		} else {
			result = result.substring(0, result.length()-sosuLength)+"."+result.substring(result.length()-sosuLength);
		}
		System.out.println(result);
		
	}
}
