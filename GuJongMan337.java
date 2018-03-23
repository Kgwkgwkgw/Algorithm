
public class GuJongMan337 {
	// 0은 아무것도 없..
	// 1은 player1
	// 2는 player2
	public static int boardToInt(int arr) {
		int ret =0;
		int temp=0;
		for(int i=0;i<9;i++) {
			if(((arr>>i)%3)==0) {
				continue;
			} else {
				if(temp==0) {
					temp =((arr>>i))%3;
				} else {
					temp *=temp;
				}
			}
		}
		return temp;
	}
	//틱택토
	public static void main(String[] args) {
		System.out.println(boardToInt(2));
	}
}
