
public class FastSumDivideAndQunquar {
	public static void main(String[] args) {
		System.out.println(divdeAndQonquar(2));
		System.out.println(divdeAndQonquar(3));
		System.out.println(divdeAndQonquar(4));
		System.out.println(divdeAndQonquar(8));
	}
	public static int divdeAndQonquar(int n) {
		if(n==1) {
			return 1;
		}
		if(n%2==0)
			return 2*divdeAndQonquar(n/2)+ n*n/4;
		else 
			return divdeAndQonquar(n+1)- (n+1);
	}
}
