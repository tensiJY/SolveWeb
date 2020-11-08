package solve.co.kr.reg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface RegService{

	public int insertReg(HashMap<String, Object> dataMap) throws Exception;

	public int getExCnt() throws Exception;

	public List getExList(HashMap hashMap) throws Exception;

	public ArrayList getRegList() throws Exception;

	public List getDataAll() throws Exception;

	
}
