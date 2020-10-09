package solve.co.kr.Test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 2번
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
	@Inject
	private DataSource ds;
	
	/**
	 * 
	 * @throws Exception
	 * root-context : 데이터소스만 있어야함.
	 */
	@Test
	public void testConnection() throws Exception{
		try(Connection conn = ds.getConnection()){
			
			System.out.println(conn);
		}catch(Exception e){
			System.out.println(1);
		}
	}
	
}
