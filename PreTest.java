import java.util.ArrayList;
import java.util.LinkedList;

public class PreTest {

	private static final char[] NUMBER_TO_KOREAN = { '\u0000', '일', '이', '삼', '사', '오', '육', '칠', '팔', '구' };
	private static final char[] UNIT_1 = { '\u0000', '십', '백', '천' };
	private static final char[] UNIT_2 = { '\u0000', '만', '억', '조', '경' };
	private static final int EXAMPLE_NUMBER = 1313;
	private static final int MIN = 1;
	private static final int MAX = 99999;
	private static final String EXAMPLE_MESSAGE = "입력 방법 예시 : java " + EXAMPLE_NUMBER + " ( 범위 : " + MIN + " ~ " + MAX
			+ ", 숫자만 입력해주세요.)";
	private static final String ALERT_ONE_INPUT_MESSAGE = "숫자 1개만 입력해주세요.";
	private static final String ALERT_RANGE_MESSAGE = "입력 범위를 확인해주세요.";

	public static class RangeOverflowException extends Exception {
		public RangeOverflowException() {
		}

		public RangeOverflowException(String msg) {
			super(msg);
		}
	}
	
	public static void main(String[] args) {
		int a = -15;
		int b= 8;
		int c =4;
		
		System.out.println(String.format("%0"+b+"d, %"+c+"d" , 13311, 4444));
		System.out.printf("%"+a+"s","ewfewfwefwefw");
		System.out.println();
		System.out.printf("%010d", 1000);
		System.out.println(String.format("%1$-10s%1$10s", "KOREA", "JAPAN"));
		String input = null;
		try {
			if (args.length != 1) {
				throw new IllegalArgumentException(ALERT_ONE_INPUT_MESSAGE);
			}
		} catch (IllegalArgumentException e) {
			printErrorMessageWithUsage(e);
			return;
		}
		input = args[0];

		try {
			System.out.println(convertNumberToKorean(input));
		} catch (NumberFormatException e) {
			printErrorMessageWithUsage(e);
			return;
		} catch (RangeOverflowException e) {
			printErrorMessageWithUsage(e);
			return;
		}

	}

	public static void printErrorMessageWithUsage(Exception e) {
		System.out.println(e.getMessage());
		System.out.println(EXAMPLE_MESSAGE);
	}

	public static String convertNumberToKorean(String toConvertNumberString)
			throws RangeOverflowException, NumberFormatException {
		byte[] money = toConvertNumberString.getBytes();
		int toConvertNumberInt = Integer.parseInt(toConvertNumberString);

		if (toConvertNumberInt < MIN || toConvertNumberInt > MAX) {
			throw new RangeOverflowException(ALERT_RANGE_MESSAGE);
		}

		StringBuilder result = new StringBuilder();

		for (int i = money.length - 1; i >= 0; i--) {
			int number = money[money.length - i - 1] - '0';
			// 숫자 붙히기
			if (number > 1 || i == 0) {
				result.append(NUMBER_TO_KOREAN[number]);
			}
			// 십,백,천 단위 붙히기
			if (number > 0)
				result.append(UNIT_1[i % 4]);
			// 만,억,조,경 단위 붙히기
			if (i % 4 == 0)
				result.append(UNIT_2[i / 4]);
		}
		
		return result.toString();
	}
}
