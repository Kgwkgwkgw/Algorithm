import java.util.Arrays;

public class ClockSync {
	public static int[][] switchSync = {
			{0,1,2},
			{3,7,9,11},
			{4,10,14,15},
			{0,4,5,6,7},
			{6,7,8,10,12},
			{0,2,14,15},
			{3,14,15},
			{4,5,7,14,15},
			{1,2,3,4,5},
			{3,4,5,9,13}
	};
//	public static int[][] clock = {
//			{3, 12, 6, 12},
//			{12, 9, 3, 12},
//			{3, 12, 6, 3},
//			{12, 3, 12, 6}
//	};
//	public static int[][] clock = {
//			{12, 6, 6, 6},
//			{6, 6, 12, 12},
//			{12, 12, 12, 12},
//			{12, 12, 12, 12}
//	};
	public static int[][] clock = {
			{12, 9, 3, 12},
			{6, 6, 9, 3},
			{12, 9, 12, 9},
			{12, 12, 6, 6}
	};
	public static int max = 48+1;
	public static void main(String[] args) {
		System.out.println(solve(0, 0));
	}
	public static int solve(int switchNumber, int count) {
		if(switchNumber==10) {
			if(isAll12()) {
				return count;
			} else {
				return max;
			}
		}
		if(isAll12()) {
			return count;
		}
		int min =max;
		int result =0;
		for(int i=0;i<4;i++) {
			if(i==0) {
				result = solve(switchNumber+1, count);
			} else {
				for(int j=0;j<i;j++) {
					press(switchNumber);
				}
				result = solve(switchNumber+1, count+i);
				for(int j=0;j<i;j++) {
					unPress(switchNumber);
				}
			}
			if(result<min ) {
				min = result;
			}
		}
		return min;
	}
	public static void press(int switchNumber) {
		if(switchNumber>=switchSync.length) {
			return;
		}
		for(int i=0; i<switchSync[switchNumber].length;i++ ) {
			clock[switchSync[switchNumber][i]/4][switchSync[switchNumber][i]%4]+=3;
			if(clock[switchSync[switchNumber][i]/4][switchSync[switchNumber][i]%4] ==15) {
				clock[switchSync[switchNumber][i]/4][switchSync[switchNumber][i]%4]-=12;
			}
		}
	}
	public static void unPress(int switchNumber) {
		if(switchNumber>=switchSync.length) {
			return;
		}
		for(int i=0; i<switchSync[switchNumber].length;i++ ) {
			clock[switchSync[switchNumber][i]/4][switchSync[switchNumber][i]%4]-=3;
			if(clock[switchSync[switchNumber][i]/4][switchSync[switchNumber][i]%4] == 0) {
				clock[switchSync[switchNumber][i]/4][switchSync[switchNumber][i]%4]+=12;
			}
		}
	}
	public static boolean isAll12() {
		boolean isAll12= true;
		for(int i=0; i<clock.length;i++) {
			for(int j=0; j<clock[i].length;j++) {
				if(clock[i][j]!=12) 
					isAll12=false;
			}
		}
		return isAll12;
	}
}
