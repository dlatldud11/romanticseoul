package controller.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import bean.Myplan;
import controller.common.SuperClass;
import dao.MallDao;
//import bean.Product;
import dao.MemberDao;
import utility.MyplanList;
//import dao.ProductDao;
//import shopping.myplanList;
//import shopping.ShoppingInfo;

@Controller
public class MeLogoutController extends SuperClass{
	private final String command = "/meLogout.me" ;
	private ModelAndView mav = null ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao ;

	@Autowired
	@Qualifier("malldao")
	private MallDao dao ;
//	
//	@Autowired
//	@Qualifier("pdao")
//	private ProductDao pdao ;
	
	public MeLogoutController() {
		super("meLoginForm", "meLoginForm") ;
		this.mav = new ModelAndView();		
	}
	
	@GetMapping(command)
	public ModelAndView doGet(HttpSession session){		
		// 세션 공간에 장바구니 정보가 있으면
		// 장바구니 임시 테이블에 저장합니다.
		MyplanList myplan = (MyplanList)session.getAttribute("myplan") ;
		
		if (myplan != null) {
			List<Myplan> myplanlists = myplan.GetAllmyplanlist() ;
			
			Member mem = (Member)session.getAttribute("loginfo") ;
			
			System.out.println("로그 아웃 중이시군요.");
			System.out.println("장바구니 품목 사이즈 : " + myplanlists.size());
			
			this.dao.InsertMyplans(myplanlists,mem);
		}
		
		// 세션 영역을 완전히 삭제하도록 합니다.
		session.invalidate(); // 세션 내용 다 지우기		
		
		// 로그인 페이지로 다시 이동합니다.
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}	
}
