package solve.co.kr.Test;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import solve.co.kr.reg.RegService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Inject
	private TestService ts;

	
	@RequestMapping("/getAll")
	public ResponseEntity getAll()throws Exception{
		
		List list = ts.getAll();
		return  new ResponseEntity(list, HttpStatus.OK);	
	}

	@RequestMapping(value="/setUser", method=RequestMethod.GET)
	public ResponseEntity setUser(
			@RequestParam(value="t_id") String t_id,
			@RequestParam(value="t_name") String t_name
			)throws Exception{
		
		System.out.println("t_id : " + t_id);
		System.out.println("t_name : " + t_name);
		
		HashMap map = new HashMap();
		map.put("t_id", t_id);
		map.put("t_name", t_name);
		
		return  new ResponseEntity(map, HttpStatus.OK);	
	}
	
	@RequestMapping(value="/setUser2", method=RequestMethod.GET)
	public ResponseEntity setUser(
			@RequestParam HashMap<String, String> map
			)throws Exception{
		
		int result = ts.setUser(map);
		System.out.println(result);
		return  new ResponseEntity("", HttpStatus.OK);	
	}
	

}
