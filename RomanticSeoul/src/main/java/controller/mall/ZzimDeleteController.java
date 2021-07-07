package controller.mall;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Course;
import bean.Member;
import bean.Menu;
import bean.Myplan;
import bean.Store;
import controller.common.SuperClass;
import dao.MallDao;
import utility.MyplanList;

@Controller
public class ZzimDeleteController extends SuperClass {
	private final String command = "/zzimdelete.ma" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/meLoginForm.me" ;
	
	@Autowired
	@Qualifier("malldao")
	private MallDao mdao ; 	
	
	public ZzimDeleteController() {
		super("zzimList", "zzimList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value="storeseq", required = false) String storeseq,
			@RequestParam(value="mode", required = false) String mode,
			@RequestParam(value="coseq", required = false) Integer coseq,
			@RequestParam(value="stock", required = false) Integer stock,
			HttpSession session) {
		System.out.println("zzimdelete doget");
		Member loginfo = (Member)session.getAttribute("loginfo")  ;
		if(stock == null) { //수량 안정해져있으면
			stock = 1;
		}
		if (loginfo == null) { // 미로그인
			System.out.println("로그인이 필요합니다."); 
			String message = "로그인이 필요합니다." ;
			
			this.mav.addObject("errmsg", message) ;
			this.mav.setViewName(this.redirect); // go to login page			
			
		} else { // 로그인 함
			System.out.println("로그인함");
			MyplanList myplan = (MyplanList)session.getAttribute("myplan")  ;
			if(myplan == null) {
				myplan = new MyplanList();
				System.out.println("장바구니 새로만듬"+myplan.toString());
			}
			System.out.println("장바구니 현재 상태 :"+myplan.toString());
			List<Myplan> myplanlist = myplan.GetAllmyplanlist();
			if(!(mode == null || mode.isBlank())){ //mode 값이 넘어갔다면
				switch(mode) {
				case "eat":
					myplan.AddOrder(storeseq, stock,mode,loginfo.getId());
					break;
				case "drink":
					myplan.AddOrder(storeseq, stock,mode,loginfo.getId());
					break;
				case "look":
					myplan.AddOrder(storeseq, stock,mode,loginfo.getId());
					break;
				}
			}
			
			System.out.println("찜목록 추가 완료 /"+myplan.toString());
			session.setAttribute("myplan", myplan);
			mav.setViewName(super.getpage);
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
