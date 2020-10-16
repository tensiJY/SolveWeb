package solve.co.kr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
	
	/**
	 * ���� ���� ����
	 */
	public static int getRandom(int num) {
		//	0���� ����
		//	nextInt() �� �Լ� �ȿ� �ִ� ���ڴ� ���� ���� �ʴ´�.
		//	���� num�� 3�̸� 0~2������ �����̹Ƿ� 1�� ���Ѵ�.
		
		return new Random().nextInt(num)+1;
	}
	
}
