
public class FanMeeting {
//	public static char[] member = {'F', 'F', 'F', 'M', 'M', 'M'};
//	public static char[] fan = {'M', 'M', 'M', 'F', 'F', 'F'};
//	public static char[] member = {'F', 'F', 'F', 'F', 'F'};
//	public static char[] fan = {'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F'};
	public static char[] member = {'F', 'F', 'F', 'F', 'M'};
	public static char[] fan = {'F', 'F', 'F', 'F', 'F', 'M', 'M', 'M', 'M', 'F'};
	
	public static int counter;
	public static void main(String[] args) {
		solve();
		System.out.println(counter);
	}
	public static void solve() {
		for(int i= member.length-1;i<fan.length;i++) {
			boolean isAllDiffrent = true;
			int index = member.length-1;
			for(int j= i; index>=0; j--) {
				if(fan[j]=='M' && member[index]=='M' ) {
					isAllDiffrent = false;
				}
				index--;
			}
			if(isAllDiffrent) {
				counter++;
			}
		}
	}
}
