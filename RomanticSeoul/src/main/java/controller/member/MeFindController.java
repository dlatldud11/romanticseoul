package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;

@Controller
public class MeFindController extends SuperClass {
	private final String command = "/findId.me" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/findId.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ; 
	
	public MeFindController() {
		super("findId", "foundId");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@RequestParam(value="email", required = true) String email){
		
		Member bean = mdao.findEmail(email) ;
		System.out.println(bean);
		if (bean != null ) { // 존재하는 경우

				this.mav.addObject("message", email + "은(는) 가입 된 이메일입니다. 아이디는 "+ "<font color='hotpink'><b>'"+bean.getId()+"'</b></font>"+" 입니다.") ;
				this.mav.addObject("isCheck", false) ;
			
		} else { // 존재 하지 않는 경우
			this.mav.addObject("message", email + "은(는) <font color='blue'><b>가입되지 않은 </b></font>이메일입니다.") ;
			this.mav.addObject("isCheck", true) ;
		}
		
		this.mav.addObject("bean", bean);
		this.mav.setViewName(super.postpage); 
		
		return this.mav ;
	}
}


