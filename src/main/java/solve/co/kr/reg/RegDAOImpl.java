package solve.co.kr.reg;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RegDAOImpl implements RegDAO {
	
	@Inject
	private SqlSession sql;
	
	private String namespace = "reg";

	@Override
	public List getBatchRegList() throws Exception {
		
		return sql.selectList(namespace+".getBatchRegList");
	}
	
	

}
