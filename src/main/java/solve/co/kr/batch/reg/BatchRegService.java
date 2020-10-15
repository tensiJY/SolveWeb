package solve.co.kr.batch.reg;

import java.util.List;

public interface BatchRegService {

	public List getBatchRegList()throws Exception;

	public void insertBatchSol(List dataList) throws Exception;

	
}
