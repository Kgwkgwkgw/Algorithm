import java.util.Arrays;

public class GuJongMan325 {
	public static String input  = "12738173912";
	public static String digits;
	public static int n =input.length();
	public static int m=7;
	public static int[][][] cache;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		char[] ch= input.toCharArray();
		Arrays.sort(ch);
		sb.append(ch);
		digits = sb.toString();
//		boolean[] selected = new boolean[3];
//		solve("", selected);
		cache= new int[1<<n][m][2];
		for(int i=0;i<cache.length;i++) {
			for(int j=0;j<m;j++) {
				Arrays.fill(cache[i][j], -1);
			} 
		}
		System.out.println(solve2(0,0,0,false));
	}
	public static int solve2(int index, int mod, int selected, boolean less) {
		if(index == n) {
			return less && mod==0 ? 1 : 0; 
		}
		if(cache[selected][mod][less ? 1 : 0]!=-1) {
			return cache[selected][mod][less ? 1 : 0];
		}
		int ret = 0;
		for(int i=0;i<n;i++) {
			// 선택한 숫자를 또 선택할 수 없다. 
			if((selected &(1<<i))> 0 ) {
				continue;
			}
			//큰 숫자는 안돼 
			if(!less && input.charAt(index) < digits.charAt(i)) {
				continue;
			}
			// 중복된 숫자를 선택하지 않는다 인데..
			if(i>0 && digits.charAt(i)== digits.charAt(i-1) && (selected & (1<<(i-1))) ==0 )  {
				continue;
			}
			
			int nextSelected = selected | 1<<i;
			int nextMod = (mod*10 + (digits.charAt(i)-'0'))%m;
			boolean nextLess  = less | (input.charAt(index) > digits.charAt(i)) ;
			
			ret += solve2(index+1, nextMod,nextSelected, nextLess);
			ret %= 1000000007;
		}
		cache[selected][mod][less ? 1 : 0]=ret;
		return ret;
	}
	public static void solve(String str, boolean[] selected) {
		if(str.length()==digits.length()) {
			System.out.println(str);
		}
		for(int i=0;i<digits.length();i++) {
			if( !selected[i] &&(i==0 || digits.charAt(i-1)!= digits.charAt(i) || selected[i-1]) ) {
				selected[i]= true;
				solve(str+digits.charAt(i), selected);
				selected[i]= false;
			}
		}
	}
}
