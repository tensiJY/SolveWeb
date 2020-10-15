package solve.co.kr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
