package solve.co.kr.batch.sol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import solve.co.kr.utils.StringUtil;
/**
 * 
 * 매일 22시 마다 다음날 DAY 문제를 설정
 *
 */
public class BatchSol extends QuartzJobBean{
	
	//	배치 중 중복 실행을 막음
	private static boolean isRunning = true;
	
	private final Logger logger = LoggerFactory.getLogger(BatchSol.class);
	
	private BatchSolServiceImpl batchSolService;

	public BatchSolServiceImpl getBatchSolService() {
		return batchSolService;
	}

	@Inject
	public void setBatchSolService(BatchSolServiceImpl batchSolService) {
		this.batchSolService = batchSolService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
		if(isRunning) {
			logger.info("-----------------");
			logger.info("Batch Sol start");
			isRunning = false;
			
			try {
				
				//	오늘의 문제를 등록하기 위한 등록된 문제 전체 갯수를 구함
				int totalCount = batchSolService.getSolNotUseCount();
				
				if(totalCount != 0) {
					
					//	문제를 고름
					ArrayList ranList = getRanNumList(totalCount);
					
					//	문제를 고름(index 를 가져옴)
					List solIdxList = batchSolService.getSolIdxList(ranList);
					
					
					List updateList = new ArrayList();
					
					String nextDay = StringUtil.getNextDay();
					for(int i=0; i<solIdxList.size();i++) {
						HashMap idxMap = (HashMap) solIdxList.get(i);
						
						HashMap dataMap = new HashMap();
						
						dataMap.put("sol_use_date", nextDay);
						dataMap.put("sol_idx", idxMap.get("sol_idx"));
						
						updateList.add(dataMap);
					}
					
					//	오늘의 문제를 등록
					batchSolService.batchSolUpdate(updateList);
					
					//	app에서 등록한 임시문제 테이블 데이터를 삭제
					//	삭제할 데이터가 있는지 확인
					int isDelReg = batchSolService.isDelReg();
					if(isDelReg == 0) {
						logger.info("reg delete data : 0");
					}else {
						int result = batchSolService.batchDelReg();
						logger.info("Reg delete success : " + isDelReg);
					}
					
					
				}else {
					
					logger.info("Batch Sol totalCount is 0");
				}
				
								
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				logger.error(e.toString());
			}
			
			logger.info("Batch Sol end");
			logger.info("-----------------");
			isRunning = true;
		}
		
	}
	
	
	private ArrayList getRanNumList(int totalCount) {
		int todaySolveCount = 3;
		
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
			
			if(ranList.size()==todaySolveCount) {
				break;
			}
			
		}
		
		return ranList;
	}
	
	
}
