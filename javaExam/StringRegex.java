package javaExam;

import java.io.*;
import java.util.*;

class StringRegex {
	/** 
		@description
			알파벳으로 구성된 이름과 성을 입력받아 일정한 형식으로 합쳐 반환하는 함수

		@param first_name 알파벳으로 이루어진 이름 
		@param last_name  알파벳으로 이루어진 성
		@return           문제에 주어진 형식으로 합쳐진 문자열
 */
	public static String getFormattedName(String firstName, String lastName){
		String formattedName = firstName.substring(0, 1).toUpperCase()+firstName.substring(1).toLowerCase()+" "+lastName.substring(0, 1).toUpperCase()+lastName.substring(1).toLowerCase();
		
		return formattedName;
	}
	
	
	/* 
	** 메인 함수에는 테스트케이스와 입출력에 대한 기본적인 뼈대 코드가 작성되어 있습니다. 
	** 상단의 함수만 완성하여도 문제를 해결할 수 있으며, 
	** 메인 함수를 제거한 후 스스로 코드를 모두 작성하여도 무방합니다.
	** 단, 스스로 작성한 코드로 인해 발생한 에러 등은 모두 참가자에게 책임이 있습니다.
	*/
  public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//테스트케이스의 수를 입력받는다 
		int caseNum = scanner.nextInt();
		
		//테스트케이스 수 만큼 반복하며 데이터를 입력받고 정답을 출력한다
		for(int caseIndex = 1; caseIndex <= caseNum; caseIndex++)
		{
			//성과 이름을 차례로 입력받는다 
			String firstName = scanner.next();
			String lastName = scanner.next();
			
			//주어진 함수를 이용해 포메팅된 이름 문자열을 얻는다 
			String answer = getFormattedName(firstName, lastName);
			
			//정답을 형식에 맞게 출력한다
			System.out.printf("Case #%d\n", caseIndex);
			System.out.println(answer);
		}
  }
}
