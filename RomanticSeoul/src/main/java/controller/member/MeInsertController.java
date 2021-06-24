package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
//import dao.MemberDao;

@Controller
public class MeInsertController extends SuperClass {
	private final String command = "/insert.me" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.me" ;
	
//	@Autowired
//	@Qualifier("mdao")
//	private MemberDao mdao  ; 
	
	public MeInsertController() {
		super("meinsert", "main");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost() {
		return this.mav ;
	}	
}


