package solve.co.kr.reg;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegController.class);

	@RequestMapping("/insert")
	public ResponseEntity regInsert( @RequestParam HashMap<String,Object> dataMap ) throws Exception{
		int result_code = 0;
		HashMap returnMap = new HashMap();
		
		
		if(dataMap.isEmpty()) {
			throw new Exception("데이터가 없습니다.");
		}
		
		
		try {
			result_code = 1;
			
			System.out.println(dataMap.toString());
			
		}catch(Exception e){
			
			result_code = 0;
			logger.info(e.toString());
			
		}finally {
			
			returnMap.put("result_code", result_code);
		}
		
		return new ResponseEntity(returnMap, HttpStatus.OK);
	}//
	
}
