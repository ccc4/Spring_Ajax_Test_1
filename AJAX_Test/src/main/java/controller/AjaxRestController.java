package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import model.Board;
import model.Member;
import service.AjaxService;

@RestController
public class AjaxRestController {
	
	@Autowired
	private AjaxService service;
	
	@RequestMapping(value="/test1")
	public String test1() {
		Gson gson = new Gson();
		
		Member member = new Member();
		member.setId("memberId01");
		member.setPw("12345");
		member.setName("AAA");
		
		String jsonData = gson.toJson(member);
		return jsonData;
	}
	
	
	@RequestMapping(value="/test2")
	public String test2() {
		Gson gson = new Gson();
		
		String jsonData = "{\"id\":\"memberId01\",\"pw\":\"12345\",\"name\":\"AAA\"}";
		
//		String jsonData = gson.toJson(member);
		Member member = gson.fromJson(jsonData, Member.class);
		return member.getId() + ", " + member.getPw() + ", " + member.getName();
	}
	
	
	
	
	// 위에는 그냥 주소에 직접 입력해서 테스트한것들.
	
	
	
	
	
	
	// value 값 잘 전달되는지, 그완 별개로 적어놓은 json 형태의 값 잘 전잘되는지 테스트
	@RequestMapping(value="/ajaxTest1", method=RequestMethod.POST)
	public String ajaxTest1(@RequestParam String value) {
		System.out.println("전달받은값 : " + value);
		
		String jsonData = "{\"id\":\"memberId01\",\"pw\":\"12345\",\"name\":\"AAA\"}";
		return jsonData;
	}
	
	
	/*전달받은 idx 값으로 해당 게시글(1개 필드) 데이터 가져오기*/
	@RequestMapping(value="/board_ajax_1", method=RequestMethod.POST)
	public String board_ajax_1(@RequestParam int idx) {
		
		System.out.println("전달받은값 : " + idx);
		
		/*받아온 데이터가 들은 객체*/
		Board board = service.board_ajax_1(idx);
		
		/*gson 을 이용해서 json(String)화 시켜준 다음 보냈다.*/
		Gson gson = new Gson();
		String jsonData = gson.toJson(board);
		return jsonData;
	}
	
	
	@RequestMapping(value="/board_ajax_2", method=RequestMethod.POST, 
			produces="application/text; charset=utf8")	// 이 부분을 추가해줘야 한글 깨지는걸 방지★★★★★
	public String board_ajax_2(@RequestParam int mark) {
		System.out.println("전달받은값 : " + mark);
		return service.add_list(mark);
	}
	
	
}
