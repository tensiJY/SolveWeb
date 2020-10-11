package solve.co.kr.Test;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO{
	
	private String namespace = "Test";
	
	
	@Inject
	private SqlSession sql;

	@Override
	public List getAll() throws Exception {
		//sql.selectList(namespace+".getJobList", map);
		
		return sql.selectList(namespace+".getAll");
	}

}
