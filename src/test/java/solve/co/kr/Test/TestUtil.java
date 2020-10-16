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
		
		
		
		while(true) {
		
			
			int ran = StringUtil.getRandom(totalCount);
			
			if(ranList.size()==0) {
				//System.out.println("0 : " + ran);
				ranList.add(ran);
			}else {
				boolean check = false;
				
				for(int i=0; i<ranList.size(); i++) {
					int temp = (int) ranList.get(i);
					if(temp == ran) {
						
						System.out.println("equal : " + ran);
						break;
						
					}else {
						check = true;
						
					}
				}
				
				if(check) {
					ranList.add(ran);
				}
				
			}
			
			if(ranList.size()==3) {
				break;
			}
			
		}
		
		
		
		//System.out.println(ranList.size());
		
	}
}
