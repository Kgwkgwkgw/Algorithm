import java.util.Arrays;
import java.util.Scanner;

public class B7453 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[][] numberArr = new int[4][n];
		
		for(int i=0;i<n;i++) {
			String[] inputs = sc.nextLine().split(" ");
			for(int j=0;j<4;j++) {
				numberArr[j][i]=(Integer.parseInt(inputs[j])); 
			}
		}
		
		int [] oneTwoPlus= new int[n*n];
		int [] threeFourPlus = new int[n*n];
		int k =0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				oneTwoPlus[k]=(numberArr[0][i]+numberArr[1][j]);
				threeFourPlus[k++]=(numberArr[2][i]+numberArr[3][j]);
			}
		}
		Arrays.sort(oneTwoPlus);
		Arrays.sort(threeFourPlus);
		
		int min =0;
		int max =n*n-1;
		long ret=0;
		
		while(min<=n*n-1 && max>=0) {
//			System.out.println(min);
//			System.out.println(max);
			if(oneTwoPlus[min]+threeFourPlus[max]>0) {
				max--;
			} else if(oneTwoPlus[min]+threeFourPlus[max]<0) {
				min++;
			} else {
//				System.out.println("여기 안들어온다고?");
				int oneTwoTemp = oneTwoPlus[min];
				long oneTwoCount =0;
				
				int threeFourTemp = threeFourPlus[max];
				long threFourCount =0;
				 for(;min<=n*n-1;min++) {
					 if(oneTwoPlus[min]== oneTwoTemp) {
						 oneTwoCount++;
					 } else {
						 break;
					 }
				 }
				 for(;max>=0;max--) {
					 if(threeFourPlus[max]== threeFourTemp) {
						 threFourCount++;
					 } else {
						 break;
					 }
				 }
//				 System.out.println("oneTwoCount : "+ oneTwoCount);
//				 System.out.println("threFourCount : "+ threFourCount);
				 ret+= oneTwoCount*threFourCount;
			}
		}
		System.out.println(ret);
	}
}
