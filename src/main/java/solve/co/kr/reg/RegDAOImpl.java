package solve.co.kr.reg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegDAOImpl implements RegDAO {
	
	@Inject
	private SqlSession sql;
	
	private String namespace = "Reg";
	
	@Override
	@Transactional
	public int insertReg(HashMap<String, Object> dataMap) throws Exception {
		
		return sql.insert(namespace+".insertReg", dataMap);
	}
	
	@Override
	public int getExCnt() throws Exception {
		
		return sql.selectOne(namespace+".getExCnt");
	}

	@Override
	public List getExList(HashMap hashMap) throws Exception {
		
		return sql.selectList(namespace+".getExList", hashMap);
	}

	@Override
	public ArrayList getRegList() throws Exception {
		
		return (ArrayList) sql.selectList(namespace+".getRegList");
	}
	
	@Override
	public List getDataAll() throws Exception {
		
		return sql.selectList(namespace+".getDataAll");
	}
	
}
