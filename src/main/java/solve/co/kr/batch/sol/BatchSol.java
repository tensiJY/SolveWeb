package solve.co.kr.batch.sol;

import javax.inject.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * 
 * ���� 00�� ���� �Ϸ� ������ ����
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
				System.out.println(1);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logger.info("Batch Sol end");
			logger.info("-----------------");
			isRunning = true;
		}
		
	}
}
