package javaExam;
//
//import java.util.Scanner;
//
//class Main {
//
//    private int[][] graph;
//    private int N;
//    /*
//     * Description :
//     * Time complexity :
//     * Space complexity :
//     */
//    private boolean solve() {
//     // TODO implement your code to here.
//    		int[][] copy = new int[N][N];
//    		int colSum=0;
//    		int[] rowSum= new int[N];
//    		
//    		for(int i=0;i<N;i++) {
//    			System.arraycopy(graph[i], 0 ,copy[i] , 0, N);
//    		}
////    		for(int i =0;i<N;i++) {
////    			for(int j=0;j<N;j++) {
////    				System.out.println(copy[i][j]);
////    			}
////    		}
//    		for(int i=0;i<N;i++) {
//    			colSum =0;
//    			for(int j =0;j<N;j++) {
//    				colSum+=copy[j][i];
//    			}
//    			if(colSum==0) {
//    				return false;
//    			}
//    		}
//    		for(int i=0;i<N;i++) {
//    			for(int j =0;j<N;j++) {
//    				rowSum[i]+=copy[i][j];
//    			}
//    		}
//    		
//    		if(rowSum[0]==1) {
//    			
//    		} else {
//    			
//    		}
//    		
//    		
//    		return false;
//    }
//   
//    public static void main(String[] args) throws Exception {
//        Main main = new Main();
//        try (Scanner scan = new Scanner(System.in)) {
//            int T = scan.nextInt();
//            for (int t = 0; t < T; t++) {
//                int N = scan.nextInt();
//                main.N = N;
//                main.graph = new int[N][N];
//
//                int K = scan.nextInt();
//
//                for (int i = 0; i < K; i++) {
//                    int P = scan.nextInt();
//                    int S = scan.nextInt();
//                    main.graph[P][S] = 1;
//                }
//                System.out.println(main.solve() ? 'O' : 'X');
//            }
//        }
//    }
//}



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Please don't change class name 'Main'
import java.util.Scanner;

class Main {
	 public static void main(String[] args) {
			try(Scanner s = new Scanner(System.in))
			{
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int x2 = s.nextInt();
				int y2 = s.nextInt();
				int x3 = s.nextInt();
				int y3 = s.nextInt();
				int x4 = s.nextInt();
				int y4 = s.nextInt();
				int x5 = s.nextInt();
				int y5 = s.nextInt();
				int x6 = s.nextInt();
				int y6 = s.nextInt();
				
				//여기부터 작성해 주세요
				int width = x2-x1;
				int height = y2-y1;
				int result = width* height;
//				System.out.println(result);
				
				int result1 = solve(x1,y1,x2,y2,x3,y3,x4,y4);
				int result2 = solve(x1,y1,x2,y2,x5,y5,x6,y6);
				int result3 = solve(x3,y3,x4,y4,x5,y5,x6,y6);
				System.out.println(result-result1-result2+result3);
				
			}
	  }
	 public static int solve(int leftDownX1, int leftDownY1, int rightUpX1, int rightUpY1,
			 					int leftDownX2, int leftDownY2, int rightUpX2, int rightUpY2) {
		 if(leftDownX2<=leftDownX1&& rightUpX2>=leftDownX1 && leftDownY1<=leftDownY2 && rightUpY1<= rightUpY2) {
			return (rightUpX2-leftDownX1)* (rightUpY1-leftDownY2);
		 } else if (leftDownX2<=leftDownX1&& rightUpX2 >= leftDownX1 && leftDownY1>=leftDownY2 && rightUpY2 >=leftDownY1) {
			return (rightUpX2-leftDownX1)* (rightUpY2-leftDownY1);
		 } else if (leftDownX2>=leftDownX1 && rightUpX1 >= leftDownX2 && leftDownY1<= leftDownY2 && rightUpY1<= rightUpY2) {
			 return (rightUpX1-leftDownX2) * (rightUpY1-leftDownY2);
		 } else if (leftDownX2>=leftDownX1 && rightUpX1 >= leftDownX2 && leftDownY1>= leftDownY2 && leftDownY1<= rightUpY2) {
			 return (rightUpX1-leftDownX2) * (rightUpY2- leftDownY1);
		 }
		 else {
			 return 0;
		 }
	 }
	 
}
	