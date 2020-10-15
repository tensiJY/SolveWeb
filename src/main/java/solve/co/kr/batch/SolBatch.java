package solve.co.kr.batch;

import javax.inject.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import solve.co.kr.reg.RegService;
/**
 * 
 * 매일 00시 마다 하루 문제를 설정
 *
 */
public class SolBatch extends QuartzJobBean{
	
	//	배치 중 중복 실행을 막음
	private static boolean isRunning = true;
	
	private final Logger logger = LoggerFactory.getLogger(SolBatch.class);
	
	//	강제 주입을 위해 getter setter 설정
	private RegService rs;
	

	
	public RegService getRs() {
		return rs;
	}

	@Inject
	public void setRs(RegService rs) {
		this.rs = rs;
	}




	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
		if(isRunning) {
			logger.info("-----------------");
			logger.info("SolBatch start");
			isRunning = false;
			
			try {
				System.out.println(1);
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logger.info("SolBatch end");
			logger.info("-----------------");
			isRunning = true;
		}else {
			logger.info("SolBatch isRunning");
		}
		
		
	}
}
