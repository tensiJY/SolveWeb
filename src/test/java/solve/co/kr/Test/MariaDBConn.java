package solve.co.kr.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
/**
 * 1¹ø
 * @author wndud
 *
 */
public class MariaDBConn {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	
	private static final String URL = "jdbc:mariadb://localhost:3300/test";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "1234";
	
	@Test
	public void testConnecion() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection con =  DriverManager.getConnection(URL, USER, PASSWORD)){
		
			System.out.println(con);
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}


}
