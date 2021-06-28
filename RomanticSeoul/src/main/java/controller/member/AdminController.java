package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class AdminController extends SuperClass{
	private final String command = "/adminPage.me";
	private ModelAndView mav = null;
	private String redirect = "./adminPage.me";
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;

	public AdminController() {
		super("adminPage", "adminPage");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(){		
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
}
