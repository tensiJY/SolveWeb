package solve.co.kr.batch.sol;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BatchSolServiceImpl implements BatchSolService {
	
	@Inject
	private BatchSolDAO batchSolDao;

	@Override
	public int getSolNotUseCount() throws Exception{
		// TODO Auto-generated method stub
		return batchSolDao.getSolNotUseCount();
	}

}
