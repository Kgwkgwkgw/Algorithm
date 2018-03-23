package javaExam;

public class Prime {
	public static void main(String[] args) {
		int[] array= {1,2,3,4,5};
		
		System.out.println(isPrime(10));
		System.out.println(isPrime(11));
		System.out.println(isPrime(12));
		System.out.println(isPrime(13));
		System.out.println(isPrime(9));
		System.out.println("----------");
		System.out.println(isPrime2(10));
		System.out.println(isPrime2(11));
		System.out.println(isPrime2(12));
		System.out.println(isPrime2(13));
		System.out.println(isPrime2(9));
	}
	public static boolean isPrime(int a) {
		for(int i=2;i<a;i++) {
			if(a%i==0) {
				return false;
			}
		}
		return true;
	}
	// 약수들은 대칭형태로 되어있기 때문에, 제곱근까지만 구해보면 됍니다.
	public static boolean isPrime2(int a) {
//		int sqrtA = (int) Math.ceil(Math.sqrt((double)a));
		for(int i=2;i*i<=a;i++) {
			if(a%i==0) {
				return false;
			}
		}
		return true;
	}
}
