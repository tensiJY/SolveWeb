package solve.co.kr.Test;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	
	@Inject
	private TestDAO tdao;
	
	@Override
	public List getAll() throws Exception {
		// 
		return tdao.getAll();
	}

}
