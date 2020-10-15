package solve.co.kr.batch.reg;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BatchRegDAOImpl implements BatchRegDAO{
	
	@Inject
	private SqlSession sql;
	
	private String namespace = "BatchReg";

	@Override
	public List getBatchRegList() throws Exception {
		
		return sql.selectList(namespace+".getBatchRegList");
	}

	@Override
	@Transactional
	public void insertBatchSol(List dataList) throws Exception {
	
		sql.insert(namespace+".insertBatchSol", dataList);
		sql.update(namespace+".updateBatchReg", dataList);
	}

	
	
}
