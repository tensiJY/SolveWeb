package solve.co.kr.batch.sol;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List getSolIdxList(ArrayList list) throws Exception{
		
		return batchSolDao.getSolIdxList(list);
	}

	@Override
	public void batchSolUpdate(List list) throws Exception {
		// TODO Auto-generated method stub
		batchSolDao.batchSolUpdate(list);
	}

	@Override
	public int batchDelReg() throws Exception{
		// TODO Auto-generated method stub
		return batchSolDao.batchDelReg();
	}

	@Override
	public int isDelReg() throws Exception{
		// TODO Auto-generated method stub
		return batchSolDao.isDelReg();
	}

}
