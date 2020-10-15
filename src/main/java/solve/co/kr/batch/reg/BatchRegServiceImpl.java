package solve.co.kr.batch.reg;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BatchRegServiceImpl implements BatchRegService{
	
	@Inject
	private BatchRegDAO batchRegDao;

	@Override
	public List getBatchRegList() throws Exception {
		
		return batchRegDao.getBatchRegList();
	}

	@Override
	public void insertBatchSol(List dataList) throws Exception{
		batchRegDao.insertBatchSol(dataList);
	}

	

}
