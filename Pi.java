
public class Pi {
//	public static String input = "12341234";
//	public static String input = "11111222";
	public static String input = "12122222";
//	public static String input = "22222222";
//	public static String input = "12673939";
	public static char[] inputArr = input.toCharArray();
	public static int VERY_BIG = 999999999;
	public static void main(String[] args) {
		System.out.println(solve(0));
		
	}

	public static int solve(int index) {
		if(index==inputArr.length) {
			return 0;
		}
		
		int min = VERY_BIG;
		for (int i = 3; i < 6; i++) {
			if(index+i-1<inputArr.length) {
				min= Math.min(min, solve(index+i)+getLevel(index, i));
			}
		}
		return min;
	}
	public static int getLevel(int index, int size) {
		boolean isSame =true;
		for(int i=0; i<size-1;i++) {
			if(inputArr[index+i]!=inputArr[index+i+1]) {
				isSame=false;
				break;
			}
		}
		if(isSame) {
			return 1;
		}
		
//		boolean isDanjo= true;
//		int diff=-2;
		boolean isDeungcha= true;
		for(int i=0; i<size-1;i++) {
				if(inputArr[index+i+1]-inputArr[index+i] != inputArr[index+1]-inputArr[index]) {
					isDeungcha=false;
				}
//				if(i==0) {
//					d= inputArr[index+i+1]- inputArr[index+i]; 
//				} else {
//					if(inputArr[index+i+1]- inputArr[index+i]!=d) {
//						isDeungcha=false;
//						break;
//					}
//				}
		}
//			if(i==0) {
//				diff= inputArr[index+1]- inputArr[index];
//				if(diff!=1 && diff !=-1) {
//					isDanjo=false;
//					break;
//				}
//			} else {
//				if(diff!= inputArr[index+i+1]- inputArr[index+i]) {
//					isDanjo=false;
//					break;
//				}
//			}
		if(isDeungcha&& Math.abs(inputArr[index+1]-inputArr[index]) ==1) {
			return 2;
		}
//		if(isDanjo) {
//			return 2;
//		}
	
		boolean isAlternative = true;
		for(int i=0; i<size-1;i++) {
			if(inputArr[index+i] != inputArr[(index+i)%2]) {
				isAlternative=false;
			}
//			if(i==0) {
//				even = inputArr[index];
//			}else if(i==1) {
//				odd = inputArr[index+1];
//			} else {
//				if(i%2==0) {
//					if(even != inputArr[index+i]) {
//						isAlternative=false;
//						break;
//					}
//				} else {
//					if(odd != inputArr[index+i]) {
//						isAlternative=false;
//						break;
//					}
//				}
//			}
		}
		if(isAlternative) {
			return 4;
		}
		if(isDeungcha) {
			return 5;
		}
		return 10;
	}
}
