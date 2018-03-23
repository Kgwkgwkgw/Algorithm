import java.util.Arrays;
import java.util.Scanner;

public class B11403_Another {
	public static int[][] adj;
	public static int[][] res;
	public static int N;
	public static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		adj = new int[N][N];
		res= new int[N][N];
		visited = new int[N];
		for(int i=0;i<N;i++) {
			String inputs[] = sc.nextLine().split(" ");
			for(int j=0;j<inputs.length;j++) {
				adj[i][j]= Integer.parseInt(inputs[j]);
			}
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(adj[i][k]==1 && adj[k][j]==1) {
						adj[i][j]=1;
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(adj[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
}