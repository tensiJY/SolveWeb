package solve.co.kr.batch.sol;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BatchSolDAOImpl implements BatchSolDAO{
	
	@Inject
	private SqlSession sql;
	
	private String namespace = "BatchSol";

	@Override
	public int getSolNotUseCount() throws Exception {
		
		return sql.selectOne(namespace+".getSolNotUseCount");
	}
	
	@Override
	public List getSolIdxList(ArrayList list) throws Exception {
		
		return sql.selectList(namespace+".getSolIdxList", list);
	}
	
	@Override
	@Transactional
	public void batchSolUpdate(List list) throws Exception {
		sql.update(namespace+".batchSolUpdate", list);
	}

	@Override
	@Transactional
	public int batchDelReg() throws Exception {
		return sql.delete(namespace+".batchDelReg");
		
	}
	
	@Override
	public int isDelReg() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace+".isDelReg");
	}
	
}
