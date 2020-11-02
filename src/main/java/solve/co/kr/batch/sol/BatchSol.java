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
 * ���� 22�� ���� ������ DAY ������ ����
 *
 */
public class BatchSol extends QuartzJobBean{
	
	//	��ġ �� �ߺ� ������ ����
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
				
				//	������ ������ ����ϱ� ���� ��ϵ� ���� ��ü ������ ����
				int totalCount = batchSolService.getSolNotUseCount();
				
				if(totalCount != 0) {
					
					//	������ ��
					ArrayList ranList = getRanNumList(totalCount);
					
					//	������ ��(index �� ������)
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
					
					//	������ ������ ���
					batchSolService.batchSolUpdate(updateList);
					
					//	app���� ����� �ӽù��� ���̺� �����͸� ����
					//	������ �����Ͱ� �ִ��� Ȯ��
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
