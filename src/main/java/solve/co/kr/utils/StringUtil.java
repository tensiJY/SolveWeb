package solve.co.kr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	/**
	 * ���ó�¥�� ����
	 * 20201015
	 * @return
	 */
	public static String getToday() {
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
		
		return df.format(new Date());
	}
}
