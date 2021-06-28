package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class MeDeleteController extends SuperClass{
	private final String command = "/delete.me" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/meList.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ;
	
	public MeDeleteController() {
		super("meList", "meList");
		this.mav = new ModelAndView();
	}
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) Member id){
		int cnt = -999999 ;
		cnt = mdao.DeleteData(id) ;
 		
		this.mav.setViewName(this.redirect);
		return this.mav ;
	}
}
