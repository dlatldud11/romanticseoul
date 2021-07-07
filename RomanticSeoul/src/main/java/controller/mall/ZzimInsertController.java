package controller.mall;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Course;
import bean.Member;
import bean.Menu;
import bean.Myplan;
import bean.Store;
import controller.common.SuperClass;
import dao.MallDao;

public class ZzimInsertController extends SuperClass {
	private final String command = "/zziminsert.ma" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/meLoginForm.me" ;
	
	@Autowired
	@Qualifier("malldao")
	private MallDao mdao ; 	
	
	public ZzimInsertController() {
		super("zzimList", "zzimList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@ModelAttribute("store") Store store,
			@ModelAttribute("menu") Menu menu,
			@ModelAttribute("course") Course course,
			HttpSession session) {
		System.out.println("zziminsert doget");
		Member loginfo = (Member)session.getAttribute("loginfo")  ;
		
		if (loginfo == null) { // 미로그인
			System.out.println("로그인이 필요합니다."); 
			String message = "로그인이 필요합니다." ;
			
			this.mav.addObject("errmsg", message) ;
			this.mav.setViewName(this.redirect); // go to login page			
			
		} else { // 로그인 함
			System.out.println("로그인함");
			Myplan myplan = (Myplan)session.getAttribute("myplan")  ;
			if(store != null) { // 가게 정보가 있으면
				if(myplan == null) {
					myplan = new Myplan();
				}
				
			}
		}
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			HttpSession session) {
		
		Member loginfo = (Member)session.getAttribute("loginfo")  ;
		Myplan myplan = (Myplan)session.getAttribute("myplan")  ;
		
		
		
		return this.mav ;
	}
}
