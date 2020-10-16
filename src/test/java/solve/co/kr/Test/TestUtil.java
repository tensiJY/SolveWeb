package solve.co.kr.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import solve.co.kr.utils.StringUtil;

public class TestUtil {

	@Test
	public void today() {
		SimpleDateFormat df = new SimpleDateFormat("YYYYMMdd");
		String date = df.format(new Date());
		System.out.println(date);
	}
	
	@Test
	public void random() {
		int totalCount = 18;
		System.out.println(totalCount);
		
		ArrayList ranList = new ArrayList();
		
		for(int i=0; ; i++) {
			int ran = StringUtil.getRandom(totalCount);
			if(i==0) {
				ranList.add(ran);
			}else {
				for(int j=0; j<ranList.size(); j++) {
					int temp = (int) ranList.get(j);
					
					if(temp==ran) {
						
						break;
					}else {
						ranList.add(ran);
						
						
					}
				}
			}
			
			System.out.println(ran);
			if(ranList.size()== 3) {
				break;
			}
		}
		
		
		
		
		
	}
}
