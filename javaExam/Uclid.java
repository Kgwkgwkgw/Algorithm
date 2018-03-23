package javaExam;

public class Uclid {
	public static void main(String[] args) {
//		System.out.println(getGcd(0));
		System.out.println(getGcd(280,30));
		System.out.println(getGcd2(280, 30));
		System.out.println(getGcd2(11, 2));
	}
	public static int getGcd(int a, int b) {
		int temp;
		while(a>0) {
			if(a<b) {
				temp = a;
				a= b;
				b= temp;
			}
			a= a-b;
//			System.out.println("a :"+ a+"b : "+b);
		}
		return b;
	}
	public static int getGcd2(int a, int b) {
		int temp=0;
		while(b>0) {
			temp=a%b;
			a=b;
			b= temp;
			System.out.println("a :"+ a+" b : "+b);
		}
		return a;
	}
}
