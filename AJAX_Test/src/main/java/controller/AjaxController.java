package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AjaxService;

@Controller
public class AjaxController {
	
	@Autowired
	private AjaxService service;
	
/*	@RequestMapping(value="/insertData", method=RequestMethod.GET)
	public String insertData(Model model) {
		model.addAttribute("result", service.insert());
		return "result";
	}*/
	
	@RequestMapping(value="/board1", method=RequestMethod.GET)
	public String board1() {
		return "board1";
	}
	
	@RequestMapping(value="/board2", method=RequestMethod.GET)
	public String board2(Model model) {
		// 처음 불러올 땐 LIMIT 0, 2 만 불러올거니까
		model.addAttribute("p", service.get_list(0)); 
		return "board2";
	}
}
