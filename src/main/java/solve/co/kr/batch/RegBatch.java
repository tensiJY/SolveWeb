package solve.co.kr.batch;

import java.util.List;

import javax.inject.Inject;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import solve.co.kr.reg.RegService;
import solve.co.kr.reg.RegServiceImpl;

/**
 * 
 * ���� ����� �͵��� ���� ���� ���̺�� �ű�� ��ġ
 *
 */
public class RegBatch extends QuartzJobBean{
	
	//	��ġ �� �ߺ� ������ ����
	private static boolean isRunning = true;
	
	private final Logger logger = LoggerFactory.getLogger(RegBatch.class);
	
	//	���� ������ ���� getter setter ����
	private RegServiceImpl rs;
	

	
	public RegServiceImpl getRs() {
		return rs;
	}

	@Inject
	public void setRs(RegServiceImpl rs) {
		this.rs = rs;
	}




	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		
		if(isRunning) {
			logger.info("-----------------");
			logger.info("RegBatch start");
			isRunning = false;
			
			try {
				List regList = rs.getBatchRegList();
				
				System.out.println(regList);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			logger.info("RegBatch end");
			logger.info("-----------------");
			isRunning = true;
		}else {
			System.out.println(isRunning);
		}
		
		
	}


}
