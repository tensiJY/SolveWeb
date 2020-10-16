package solve.co.kr.reg;

import java.util.HashMap;
import java.util.List;

public interface RegDAO {

	public int insertReg(HashMap<String, Object> dataMap) throws Exception;

	public int getExCnt() throws Exception;

	public List getExList(HashMap hashMap) throws Exception;

	

	

}
