import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B3653Re {
	public static class FenwickTree {
		int n;
		int[] accumulate;
		int[] movieNumber2AccumulateIndex;
		int[] input;
		int m;
		public FenwickTree(int m, int n) {
			this.m=m;
			this.n=n;
			input = new int[m+n];
			Arrays.fill(input, m, m+n, 1);
			
			accumulate =new int[input.length+1];
			
			movieNumber2AccumulateIndex= new int[n+1];
			for(int i=1;i<movieNumber2AccumulateIndex.length;i++) {
				movieNumber2AccumulateIndex[i]= m+i-1;
			}
			for(int i=0;i<input.length;i++) {
				update(i, input[i]);
			}
//			System.out.println("accumulate : " + Arrays.toString(accumulate));
//			System.out.println("movieNumber2AccumulateIndex : " + Arrays.toString(movieNumber2AccumulateIndex));
//			System.out.println("input : "+ Arrays.toString(input));
		}
		public void change(int movieNumber) {
			movieNumber2AccumulateIndex[movieNumber]=--m;
		}
		public int sum(int movieNumber) {
			int index = movieNumber2AccumulateIndex[movieNumber];
			index++;
			int ret=0;
			while(index>0) {
				ret+=accumulate[index];
				index &= index-1;
			}
			return ret;
		}
		public void updateByMovieNumber(int movieNumber, int value) {
			int index = movieNumber2AccumulateIndex[movieNumber];
			update(index, value);
		}
		private void update(int index, int value) {
			index++;
			while(index<accumulate.length) {
				accumulate[index]+=value;
				index += (index&-index);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			FenwickTree fenwickTree = new FenwickTree(m,n);
			for(int i=0;i<m;i++) {
				int movie = sc.nextInt();
				System.out.print(fenwickTree.sum(movie)-1+ " ");
//				System.out.println("update 전, accumulate : " + Arrays.toString(fenwickTree.accumulate));
//				System.out.println("update 전, movieNumber2AccumulateIndex : " + Arrays.toString(fenwickTree.movieNumber2AccumulateIndex));
				fenwickTree.updateByMovieNumber(movie, -1);
//				System.out.println("update 후, accumulate : " + Arrays.toString(fenwickTree.accumulate));
//				System.out.println("update 후, movieNumber2AccumulateIndex : " + Arrays.toString(fenwickTree.movieNumber2AccumulateIndex));
//				System.out.println();
//				System.out.println("change 전, accumulate : " + Arrays.toString(fenwickTree.accumulate));
//				System.out.println("change 전, movieNumber2AccumulateIndex : " + Arrays.toString(fenwickTree.movieNumber2AccumulateIndex));
				fenwickTree.change(movie);
//				System.out.println("change 후, accumulate : " + Arrays.toString(fenwickTree.accumulate));
//				System.out.println("change 후, movieNumber2AccumulateIndex : " + Arrays.toString(fenwickTree.movieNumber2AccumulateIndex));
//				System.out.println();
				fenwickTree.updateByMovieNumber(movie, 1);
//				System.out.println("update 최종 후, accumulate : " + Arrays.toString(fenwickTree.accumulate));
//				System.out.println("update 최종 후, movieNumber2AccumulateIndex : " + Arrays.toString(fenwickTree.movieNumber2AccumulateIndex));
//				System.out.println();
//				fenwickTree.accumulate[movie]=0;
			}
			
		}
	}
}
