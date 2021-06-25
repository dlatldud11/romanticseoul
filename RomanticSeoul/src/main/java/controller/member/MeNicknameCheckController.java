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
public class MeNicknameCheckController extends SuperClass {
	private final String command = "/nicknamecheck.me" ;
	private ModelAndView mav = null ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ; 
	
	public MeNicknameCheckController() {
		super("nicknameCheck", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "nickname", required = true) String nickname ) {
		
		Member bean = this.mdao.SelectDataByNickname(nickname) ;
		
		if (bean != null ) { // 존재하는 경우
				this.mav.addObject("message", nickname + "은(는) <font color='red'><b>사용중</b></font>인 닉네임입니다.") ;
				this.mav.addObject("isCheck", false) ;
		} else { // 존재 하지 않는 경우
			this.mav.addObject("message", nickname + "은(는) <font color='blue'><b>사용 가능</b></font>한 닉네임입니다.") ;
			this.mav.addObject("isCheck", true) ;
		}
				
		this.mav.setViewName(super.getpage); 
		return this.mav ;
	}
}
