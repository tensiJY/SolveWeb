package solve.co.kr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtil {
	/**
	 * 오늘날짜를 리턴
	 * 20201015
	 * @return
	 */
	public static String getToday() {
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
		
		return df.format(new Date());
	}
	
	/**
	 * 랜덤 수를 생성
	 */
	public static int getRandom(int num) {
		//	0부터 시작
		//	nextInt() 의 함수 안에 있는 숫자는 포함 되지 않는다.
		//	따라서 num이 3이면 0~2까지의 숫자이므로 1을 더한다.
		
		return new Random().nextInt(num)+1;
	}
	
}
