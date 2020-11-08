package solve.co.kr.reg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import solve.co.kr.utils.PageUtil;

@RestController
@RequestMapping("/reg")
public class RegController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegController.class);
	
	@Inject
	private RegService regSer;
	
	/**
	 * 문제를 저장하는 함수
	 * @param dataMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insert")
	public ResponseEntity regInsert( @RequestParam HashMap<String,Object> dataMap ) throws Exception{
		int result_code = 0;
		HashMap returnMap = new HashMap();
		
		
		
		if(dataMap.isEmpty()) {
			throw new Exception("데이터가 없습니다.");
		}
		
		
		try {
			logger.info("===== Reg Insert Start =====");
			
			logger.info("data : " + dataMap.toString());
			
			int result = regSer.insertReg(dataMap);
			
			
			result_code = 1;
			logger.info("===== Reg Insert End =====");
			
		}catch(Exception e){
			
			result_code = 0;
			logger.info("===== Reg Insert error log s =====");
			logger.info(e.toString());
			logger.info("===== Reg Insert error log e =====");
		}finally {
			
			returnMap.put("result_code", result_code);
		}
		
		return new ResponseEntity(returnMap, HttpStatus.OK);
	}//
	
	
	/**
	 *	연습문제 데이터 가져오기 
	 */
	@RequestMapping(value = "/getExList" )
	public ResponseEntity getExList(@RequestBody HashMap dataMap )throws Exception{
		
		HashMap returnMap = new HashMap();
		
		int result_code = 0;
		
		if(dataMap.isEmpty()) {
			throw new Exception("param is not");
		}
		
		try {
			result_code = 1;
			
			int nowPage = Integer.parseInt(String.valueOf(dataMap.get("nowPage")));
						
			int totalCnt = regSer.getExCnt();
			PageUtil pageUtil = new PageUtil(nowPage, totalCnt, 4);
			
			int totalPage = pageUtil.getTotalPage();
			int start_num = pageUtil.getStartNum();
			int end_num = pageUtil.getEndNum();
			
			HashMap selectMap = new HashMap();
			selectMap.put("start_num", start_num);
			selectMap.put("end_num", end_num);
			
			//System.out.println(selectMap.toString());
			
			 
			
			returnMap.put("result_code", result_code);
			returnMap.put("total_page", totalPage);
			returnMap.put("now_page", nowPage);
			returnMap.put("data_list", regSer.getExList(selectMap));
			
		}catch(Exception e) {
			
			result_code = 0;
			
			logger.error(e.toString());
			
		}finally {
			
			returnMap.put("result_code", result_code);
		}
		
		
		return new ResponseEntity(returnMap, HttpStatus.OK);
	}
	
	/**
	 * 오늘의 문제 가져오기
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRegList")
	public ResponseEntity getRegList(@RequestBody HashMap paramMap)throws Exception{
		
		HashMap returnMap = new HashMap();
		
		int result_code = 0;
		
		if(paramMap.isEmpty()) {
			throw new Exception("param is not");
		}
		
		
		try {
			result_code = 1;
			ArrayList regList = regSer.getRegList();
			returnMap.put("data_list", regList);
			returnMap.put("result_code", result_code);
			
			
			
		}catch(Exception e) {
			result_code = 0;
			logger.error("get reg list error");
			logger.error(e.toString());
		}finally {
			
			returnMap.put("result_code", result_code);
		}
		
		return new ResponseEntity(returnMap, HttpStatus.OK);
	}
	
	/**
	 * 전체 데이터 가져오기
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDataAll")
	public ResponseEntity getDataAll(@RequestBody HashMap paramMap) throws Exception{
		
		HashMap returnMap = new HashMap();
		
		int result_code = 0;
		
		try {
			result_code = 1;
			String type = String.valueOf(paramMap.get("type"));
			List dataList = null;
			
			if("1".equals(type)) {
				dataList = regSer.getDataAll();
			}else if("2".equals(type)) {
				
			}
			
			returnMap.put("data_list", dataList);
			
		}catch(Exception e) {
			result_code = 0;
			logger.error("getDataAll error");
		}finally {
			
			returnMap.put("result_code", result_code);
		}
		
		
		return new ResponseEntity(returnMap, HttpStatus.OK);
	}	
	
}
