package solve.co.kr.reg;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class RegServiceImpl implements RegService{

	@Inject
	private RegDAO regDao;
	
	@Override
	public List getBatchRegList() throws Exception {
		
		return regDao.getBatchRegList();
	}

	
}
