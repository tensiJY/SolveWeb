package solve.co.kr.batch.sol;

import java.util.ArrayList;

import javax.inject.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import solve.co.kr.utils.StringUtil;
/**
 * 
 * 매일 00시 마다 하루 문제를 설정
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
				int totalCount = batchSolService.getSolNotUseCount();
				System.out.println(totalCount);
				
				ArrayList ranList = new ArrayList();
				
				boolean bool = true;
				
				while(bool) {
					int ran = StringUtil.getRandom(totalCount);
					
					if(ranList.size()==0) {
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
					if(ranList.size()==3) {
						bool = false;
					}
				}
				
				
				for(int i=0; i<ranList.size();i++) {
					System.out.println(ranList.get(i));
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
	
	
}
