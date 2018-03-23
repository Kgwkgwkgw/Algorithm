
public class Bino {
	public static void main(String[] args) {
		System.out.println(bino(4,2));
	}
	public static int bino(int n, int r) {
		if(n==r || r==0) {
			return 1;
		}
		return bino(n-1,r-1)+ bino(n-1,r);
		
	}
}
