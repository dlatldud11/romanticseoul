package controller.mall;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Combo1;
import bean.Combo2;
import bean.Member;
import bean.Store;
import controller.common.SuperClass;
import dao.MallDao;
import dao.ProductDao;
import utility.CombineAPI;

@Controller
public class BuyController extends SuperClass {
	private final String command = "/buy.ma" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/main.co" ;
	
//	@Autowired
//	@Qualifier("cdao")
//	private CompositeDao dao ; 	
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao pdao ; 	

	@Autowired
	@Qualifier("malldao")
	private MallDao mdao ; 	
	
	private CombineAPI capi;
	
	public BuyController() {
		super("buyList", null);
		this.mav = new ModelAndView();
		this.capi = new CombineAPI();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "firstmenu", required = false) String[] firstmenu,
			@RequestParam(value = "secondmenu", required = false) String[] secondmenu,
			HttpSession session) {
		this.mav.setViewName(super.getpage);
		System.out.println("값넘어왔는지 확인 buy: "+firstmenu.length+"/"+secondmenu.length); // 메뉴시퀀스,값,가게기본키,모드
		Store first = new Store();
		Store second = new Store();
		Combo1 firstMenu = new Combo1();
		Combo1 secondMenu = new Combo1();
		
		for(String bean : firstmenu) { // 첫번째 코스의 가게이름, 카테고리, 메뉴, 가격 가져오기
			if(!(bean.isBlank())){
				String[] beanlist = bean.split("/"); //메뉴시퀀스, 가게시퀀스, 모드
				first = this.capi.getByPk(beanlist[2], beanlist[1]);
				firstMenu = this.pdao.SelectDataByPk(Integer.parseInt(beanlist[0]));
				
			}
		}
		for(String bean : secondmenu) { // 첫번째 코스의 가게이름, 카테고리, 메뉴, 가격 가져오기
			if(!(bean.isBlank())){
				String[] beanlist = bean.split("/"); //메뉴시퀀스, 가게시퀀스, 모드
				second = this.capi.getByPk(beanlist[2], beanlist[1]);
				secondMenu = this.pdao.SelectDataByPk(Integer.parseInt(beanlist[0]));
				
			}
		}
		mav.addObject("first",first);// 가게
		mav.addObject("firstMenu",firstMenu);
		mav.addObject("second",second);
		mav.addObject("secondMenu",secondMenu);
		
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("combo2") @Valid Combo2 xxx,
			BindingResult asdf,
			HttpServletRequest request,
			HttpSession session) {
		Member loginfo = (Member)session.getAttribute("loginfo")  ;
		if (asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println(asdf);
//			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.getpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			System.out.println(xxx.toString());
			// 수량이 있는지 확인
			Combo1 first = this.pdao.SelectDataByPk(xxx.getFirst());
			System.out.println("first /"+first.toString());
			Combo1 second = this.pdao.SelectDataByPk(xxx.getSecond());
			System.out.println("second /"+second.toString());
			if( first.getQty() >= xxx.getQty() && second.getQty() >= xxx.getQty()) {
				System.out.println("수량이 있음");
				this.mdao.UpdateStock(xxx.getFirst(),xxx.getQty());
				this.mdao.UpdateStock(xxx.getSecond(),xxx.getQty()); // 수량 바꾸기
				this.mdao.InsertReservation(xxx); // 예약쓰기
				this.mav.setViewName(this.redirect);
			}else {
				System.out.println("재고가 없습니다.");
				this.mav.setViewName(super.getpage);
			}
		}	
		
		
		return this.mav ;
	}
}