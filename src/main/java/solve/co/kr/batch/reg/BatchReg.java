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
 * ���� ����� �͵��� ���� ���� ���̺�� �ű�� ��ġ
 *
 */
public class BatchReg extends QuartzJobBean{
	
	//	��ġ �� �ߺ� ������ ����
	private static boolean isRunning = true;
	
	private final Logger logger = LoggerFactory.getLogger(BatchReg.class);
	
	//	���� ������ ���� getter setter ����
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
				//	�� �����͸� ��������
				List dataList = batchRegService.getBatchRegList();
				
				if(dataList.size() != 0) {
					batchRegService.insertBatchSol(dataList);
					
					logger.info("Batch Reg Insert Success: " + dataList.size());
					
				}else {
					logger.info("Batch Reg dataList size is 0");
					logger.info("����� ������ �����ϴ�");
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
