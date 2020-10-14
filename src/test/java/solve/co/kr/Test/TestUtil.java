package solve.co.kr.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestUtil {

	@Test
	public void today() {
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
		String date = df.format(new Date());
		System.out.println(date);
	}
}
