package solve.co.kr.batch.sol;

import java.util.ArrayList;
import java.util.List;

public interface BatchSolDAO {

	public int getSolNotUseCount() throws Exception;

	public List getSolIdxList(ArrayList list) throws Exception;

	public void batchSolUpdate(List list) throws Exception;

	public int batchDelReg() throws Exception;

	public int isDelReg() throws Exception;

}
