package controller.member;

import javax.servlet.http.HttpSession;

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
public class MeInfoController extends SuperClass {
	private final String command = "/meInfo.me";
	private ModelAndView mav = null;
	private String redirect = "redirect:/main.co";

	@Autowired
	@Qualifier("mdao")
	private MemberDao dao;

	public MeInfoController() {
		super("meInfo", "main");
		this.mav = new ModelAndView();
	}

	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id, 
			HttpSession session){
		
		Member bean = dao.SelectDataByPk(id) ;
	
		if (bean != null) { 
			
			// login : 현재 접속한 사람의 정보를 저장하고 있는 객체입니다.
			Member login =  (Member)session.getAttribute("loginfo") ;
			
//			if(bean.getId() == null || !bean.getId().equals(login.getId())) {
//				dao.UpdateReadhit(id) ;
//			}
			mav.addObject("bean", bean);
			//mav.addObject("parameters", parameters.toString());
			
			//상세 보기 페이지로 이동
			this.mav.setViewName(super.getpage);
		} else {
			// 포워딩을 이용하여 목록 페이지로 다시 돌아갑니다.
			// 다음과 같이 코딩하면 request와 response 객체가 그대로 다시 넘어 갑니다.
			this.mav.setViewName(this.redirect);
		}
		return this.mav ;
	}
}