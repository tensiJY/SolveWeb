package solve.co.kr.batch.reg;

import java.util.List;

public interface BatchRegDAO {

	public List getBatchRegList() throws Exception;

	public void insertBatchSol(List dataList) throws Exception;

	
}
