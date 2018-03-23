import java.util.Arrays;

public class SquareMatrix {
	public static void main(String[] args) {
		int[][] arr = {
				{1,2},
				{3,4}
		};
		int[][] result = new int[2][2];
		for(int i=0;i< arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				int tmp =0;
				for(int k=0;k< arr[i].length;k++) {
					System.out.println("i :"+i );
					System.out.println("k :"+k );
					System.out.println("j :"+j );
					System.out.println("------");
					tmp += arr[i][k]* arr[k][j];
				}
				result[i][j]=tmp;
			}
		}
		for(int i=0; i< arr.length;i++) {
			System.out.println(Arrays.toString(result[i]));
		}
//		solve();
	}
//	public static int[][] identity(int size) {
//		int arr[][]= new int[size][size];
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0; j<arr[i].length;j++) {
//				if(i==j) {
//					arr[i][j]=1;
//				}
//			}
//		}
//		return arr;
//	}
//	public static int[][] solve(int[][] arr, int m) {
//		if(m==0) {
//			return identity(arr.length);
//		}
//		return solve(arr, m/2) * solve(arr, m/2);
//	}
}
