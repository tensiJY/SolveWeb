package solve.co.kr.Test;

import java.util.HashMap;
import java.util.List;

public interface TestDAO {

	public List getAll() throws Exception;

	public int setUser(HashMap<String, String> map) throws Exception;
	
	
}
