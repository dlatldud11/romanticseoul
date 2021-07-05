package controller.product;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.MemberDao;
import utility.GetXYData;

@Controller
public class MeCoListController extends SuperClass {
	private final String command = "/test.pr" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ; 
	
	private GetXYData gapi;
	
	public MeCoListController() {
		super("result", "result");
		this.mav = new ModelAndView();
		this.gapi = new GetXYData();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@RequestParam(value = "address", required = true) String address) {
		Map<String,Object> addr = gapi.addToCoord(address);
		mav.addObject("x",addr.get("x"));
		mav.addObject("y",addr.get("y"));
		mav.setViewName(super.postpage);
		return this.mav ;
	}	
}


