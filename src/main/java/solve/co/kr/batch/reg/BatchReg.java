package solve.co.kr.batch.reg;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

import solve.co.kr.reg.RegService;
import solve.co.kr.reg.RegServiceImpl;

/**
 * 
 * 문제 등록한 것들을 문제 출제 테이블로 옮기는 배치
 *
 */
public class BatchReg extends QuartzJobBean{
	
	//	배치 중 중복 실행을 막음
	private static boolean isRunning = true;
	
	private final Logger logger = LoggerFactory.getLogger(BatchReg.class);
	
	//	강제 주입을 위해 getter setter 설정
	private BatchRegServiceImpl batchRegService;
	
	public BatchRegServiceImpl getBatchRegService() {
		return batchRegService;
	}
	
	@Inject
	public void setBatchRegService(BatchRegServiceImpl batchRegService) {
		this.batchRegService = batchRegService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
		if(isRunning) {
			logger.info("-----------------");
			logger.info("Batch Reg start");
			isRunning = false;
			
			try {
				//	총 데이터를 가져오기
				List dataList = batchRegService.getBatchRegList();
				
				if(dataList.size() != 0) {
					batchRegService.insertBatchSol(dataList);
					
					logger.info("Batch Reg Insert Success: " + dataList.size());
					
				}else {
					logger.info("Batch Reg dataList size is 0");
					logger.info("등록할 문제가 없습니다");
				}
				
				
			} catch (Exception e) {
				logger.info("Batch Reg Error");
				logger.info(e.toString());
			}
			
			logger.info("Batch Reg End");
			logger.info("-----------------");
			isRunning = true;
		}else {
			System.out.println(isRunning);
		}
		
		
	}


}
