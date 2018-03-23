import java.util.Scanner;

public class B1074 {
	public static int targetX;
	public static int targetY;
	public static int count =0;
	public static int[] dx= {0,1,0,1};
	public static int[] dy= {0,0,1,1};
	public static boolean isFind = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		targetY= sc.nextInt();
		targetX= sc.nextInt();
		recursiveCall(0,0, (int) Math.pow(2, N));
		System.out.println(count);
	}
	public static void recursiveCall(int y, int x, int size) {
		if(size>2) {
			if(!isFind)
				recursiveCall(y, x, size/2);
			if(!isFind)
				recursiveCall(y, x+size/2, size/2);
			if(!isFind)
				recursiveCall(y+size/2, x, size/2);
			if(!isFind)
				recursiveCall(y+size/2, x+size/2, size/2);
			return;
		}
		for(int i=0;i<4;i++) {
			if(y+dy[i]==targetY && x+dx[i]== targetX) {
				isFind=true;
				return;
			} else {
				count++;
			}
		}
	}
}
