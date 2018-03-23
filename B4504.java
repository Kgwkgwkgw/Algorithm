import java.util.Scanner;

public class B4504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int input = 0;
		do {
			input = sc.nextInt();
			if(input==0) {
				break;
			}
			if(input%n==0) {
				System.out.println(input+ " is a multiple of "+ n+".");
			} else {
				System.out.println(input+ " is NOT a multiple of "+ n+".");
			}
		}while(input!=0);
	}
}
