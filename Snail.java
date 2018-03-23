
public class Snail {
	public static int n =4;
	public static int m = 2;
	public static void main(String[] args) {
		System.out.println(solve(0,0));
		System.out.println(solve(0,0)/Math.pow(2, m));
	}
	public static double solve (int day, int climbedHeight) {
		if(day==m) {
			if(climbedHeight>=n) {
				return 1;
			}
			else
				return 0;
		}
		double counter=0;
		counter += solve(day+1, climbedHeight+1)*0.75;
		counter += solve(day+1, climbedHeight+2)*0.25;
		return counter;
	}
}
