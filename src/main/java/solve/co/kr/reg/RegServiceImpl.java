package solve.co.kr.reg;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class RegServiceImpl implements RegService{

	@Inject
	private RegDAO regDao;
	
	@Override
	public int insertReg(HashMap<String, Object> dataMap) throws Exception{
		// TODO Auto-generated method stub
		return regDao.insertReg(dataMap);
	}

	@Override
	public int getExCnt() throws Exception {
		
		return regDao.getExCnt();
	}
	
	@Override
	public List getExList(HashMap hashMap) throws Exception {
		
		return regDao.getExList(hashMap);
	}
	
}
