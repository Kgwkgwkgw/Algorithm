package javaExam;

public class Calculator {
	public int sum(int i, int j ) {
		return i+j;
	}
	public static void main(String[] args) {
		String[] strArr = {"d","f","g","h","i"};
		for(String str : strArr) {
			System.out.println(str);
		}
		Integer a = 3;
		Integer b = a;
		b++;
		
		System.out.println(a);
		System.out.println(b);
	}
}
