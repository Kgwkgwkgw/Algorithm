import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GuJongMan912Hanoi {
	static int MAX_DISC = 12;
	public static int get(int hanoi, int index) {
		return ((hanoi >> (index<<1)) &3 ); 
	}
	// 인덳스는 원반 번호 , value는 탑번호 
	public static int set(int hanoi, int index, int value) {
		hanoi&= ~(3<<(index<<1));
		hanoi|= (value<<(index<<1));
		return hanoi;
	}
	public static int[] distance = new int[1 << (MAX_DISC*2)];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int hanoi = 0;
		for(int i=0;i<4;i++) {
			int count = sc.nextInt();
			for(int j=0;j<count;j++) {
				int disNumber = sc.nextInt();
				hanoi = set(hanoi, disNumber-1, i);
			}
		}
		int finish =0;
		
		for(int i=0;i<4;i++) {
			int count = sc.nextInt();
			for(int j=0;j<count;j++) {
				int disNumber = sc.nextInt();
				finish = set(finish, disNumber-1, i);
			}
		}
		
		Arrays.fill(distance, 0);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(hanoi);
		queue.add(finish);
		distance[hanoi]=1;
		distance[finish]=-1;
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			int d = distance[poll];
			
			int[] top= {-1,-1,-1,-1};
			for(int i=n-1;i>=0;i--) {
				top[get(poll,i)] =i;
			}
			
			for(int i=0;i<4;i++) {
				if(top[i]!=-1) {
					for(int j=0;j<4;j++) {
						if(i!=j && (top[j]==-1 || top[i]<top[j])) {
							int newTop = set(poll, top[i], j);
							if(distance[newTop]==0) {
								queue.add(newTop);
								distance[newTop]= addValue(d);
							}
							else if(getSign(d)!= getSign(distance[newTop])) {
								System.out.println(Math.abs(d)+ Math.abs(distance[newTop]) -1 );
								return;
							}
						}
					}
				}
			}
		}
	}
	public static int getSign(int value) {
		return value >0 ? 1 : -1;
	}
	public static int addValue(int value) {
		if(value<0) {
			return value-1;
		}
		return value+1;
	}
}
