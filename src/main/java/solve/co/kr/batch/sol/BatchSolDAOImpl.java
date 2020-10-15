package solve.co.kr.batch.sol;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BatchSolDAOImpl implements BatchSolDAO{
	
	@Inject
	private SqlSession sql;
	
	private String namespace = "BatchSol";

}
