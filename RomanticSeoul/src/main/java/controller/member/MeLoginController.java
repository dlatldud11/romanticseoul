package controller.member;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Member;
import bean.Myplan;
import controller.common.SuperClass;
import dao.MallDao;
//import dao.MallDao;
import dao.MemberDao;
//import shopping.MyCartList;
//import shopping.ShoppingInfo;
import utility.MyplanList;

@Controller
public class MeLoginController extends SuperClass{
	private final String command = "/meLoginForm.me" ; // 요청 커맨드
	private final String redirect = "redirect:/main.co" ;
	private ModelAndView mav = null ;
		
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao ;
	
	@Autowired
	@Qualifier("malldao")
	private MallDao mdao ;
	
	public MeLoginController() {
		super("meLoginForm", null) ;
		this.mav = new ModelAndView() ;
	}
	
	@GetMapping(command)
	public ModelAndView doGet(){
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "password", required = true) String password,
			HttpSession session){		
		
		boolean isCheck = true ; // false이면 유효성 검사에 문제가 있습니다.
		
		if (id.length() < 4 || id.length() > 10) {
			this.mav.addObject(super.PREFIX + "id", "아이디는 4자리 이상 10자리 이하이어야 합니다.") ;
			isCheck = false ;
		}
		if (password.length() < 4 || password.length() > 10) {
			this.mav.addObject(super.PREFIX + "password", "비밀 번호는 4자리 이상 10자리 이하이어야 합니다.") ;
			isCheck = false ;
		}
		
		if (isCheck == true) {
			Member bean = this.dao.SelectData(id, password);
			
			if (bean == null) { // failure
				String message = "아이디나 비번이 잘못 되었습니다." ;
				this.mav.addObject("errmsg", message) ;
				this.mav.setViewName(super.getpage); 
			} else { // success
				// 세션 영역에 로그인 정보를 바인딩합니다.
				session.setAttribute("loginfo", bean); 
				System.out.println("로그인 성공");
				// 장바구니 테이블에서 이전 나의 쇼핑 정보 가져 오기
				List<Myplan> lists = this.mdao.SelectMyplans(id); //찜목록 가져오기
				if (lists.size() > 0) { // 이전 wish list가 있는 경우
					MyplanList myplanlists = new MyplanList();
					
					// 반복문을 사용하여, 카트에 목록을 저장합니다.
					for(Myplan myplan : lists) {
						// 해당 상품 번호에 대한 구매 수량을 장바구니에 담아 둡니다.
						if(!(myplan.getEatid() == null || myplan.getEatid().isBlank())) {
							myplanlists.AddOrder(myplan.getEatid(), myplan.getQty(),"eat",id); 
						}
						if(!(myplan.getDrinkid() == null || myplan.getDrinkid().isBlank())) {
							myplanlists.AddOrder(myplan.getDrinkid(), myplan.getQty(),"drink",id); 
						}
						if(!(myplan.getLookid() == null || myplan.getLookid().isBlank())) {
							myplanlists.AddOrder(myplan.getLookid(), myplan.getQty(),"look",id); 
						}
					}
					session.setAttribute("myplan", myplanlists); 
				}
				
				this.mav.setViewName(redirect);
			}
			
		} else { // 문제가 있슴
			this.mav.addObject("id", id) ;
			this.mav.addObject("password", password) ;
			this.mav.setViewName(super.getpage);
		}
		
		return this.mav ;
	}
}


