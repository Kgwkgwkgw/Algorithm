import java.util.Scanner;

public class B1019 {
	public static int N;
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		arr = new int[10];
		
		N = sc .nextInt();
		solve(N,1);
		
		
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");
		}
	}
	public static void solve(int value, int jarisu) {
		while(value/10>0 && value%10 !=9) {
			calc(value, jarisu);
			value--;
		}
		if(value>=10) {
			value= value/10;
			for(int i=0;i<arr.length;i++) {
				arr[i]+=(value+1) * Math.pow(10, jarisu-1);
			}
			arr[0]-=Math.pow(10, jarisu-1);
			solve(value, jarisu+1);
		} else {
			for(int i=1;i<=value;i++) {
				arr[i]+=Math.pow(10, jarisu-1);;
			}
		}
	}
	public static void calc(int temp,int jarisu) {
			while(temp>0) {
				arr[temp%10]+=Math.pow(10, jarisu-1);
				temp /= 10;
			}
	}
}
