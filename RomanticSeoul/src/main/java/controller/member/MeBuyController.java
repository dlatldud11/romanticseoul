package controller.member;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.Combo1;
import bean.Combo2;
import bean.Member;
import bean.Menu;
import bean.Store;
import controller.common.SuperClass;
import dao.MallDao;
import dao.MemberDao;
import dao.ProductDao;
import utility.CombineAPI;

@Controller
public class MeBuyController extends SuperClass{
	private final String command = "/meBuy.me" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/meBuy.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ; 

	@Autowired
	@Qualifier("malldao")
	private MallDao malldao  ; 

	@Autowired
	@Qualifier("pdao")
	private ProductDao pdao  ; 
	
	private CombineAPI capi;
	
	public MeBuyController() {
		super("meBuy", "meBuy");
		this.mav = new ModelAndView();
		this.capi = new CombineAPI();
	}
	
	@ResponseBody
	@GetMapping(command)
	public  ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id, 
			@RequestParam(value = "month", required = false) String month, 
			HttpSession session){
		Member bean = mdao.SelectDataByPk(id) ;
		if (bean != null) { 
			Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
			if(month == null || month.isBlank()) {
				SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyy/MM"); 
				System.out.println(fourteen_format.format(date_now)); // 14자리 포멧으로 출력한다
				month = fourteen_format.format(date_now);
			}else {
				SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyy/"); 
				month = fourteen_format.format(date_now)+month;
			}
			
			
			
			// login : 현재 접속한 사람의 정보를 저장하고 있는 객체입니다.
			Member login =  (Member)session.getAttribute("loginfo") ;
			List<Combo2> lists = this.malldao.SelectResById(id);
			List<Menu> mlists =new ArrayList <Menu>();
			// menuseq 로 가게 기본키 찾기
			Store firststore = new Store();
			Store secondstore = new Store();
			for(Combo2 res: lists){
				Combo1 first = this.pdao.SelectDataByPk(res.getFirst());// 메뉴 하나 나옴
				String mode = " ";
				if(!(first.getEatid() == null || first.getEatid().isBlank())){// eatid이면
					mode = "eat";
					firststore = this.capi.getByPk(mode, first.getEatid());
				}else if(!(first.getDrinkid() == null || first.getDrinkid().isBlank())){
					mode = "drink";
					firststore = this.capi.getByPk(mode, first.getEatid());
				}else {
					mode = "look";
					firststore = this.capi.getByPk(mode, first.getEatid());
				}
				Combo1 second = this.pdao.SelectDataByPk(res.getSecond());// 메뉴 하나 나옴
				if(!(second.getEatid() == null || second.getEatid().isBlank())){// eatid이면
					mode = "eat";
					secondstore = this.capi.getByPk(mode, second.getEatid());
				}else if(!(second.getDrinkid() == null || second.getDrinkid().isBlank())){
					mode = "drink";
					secondstore = this.capi.getByPk(mode, second.getDrinkid());
				}else {
					mode = "look";
					secondstore = this.capi.getByPk(mode, second.getLookid());
				}
			}
			// 각 가게의 이름, 카테고리 등을 가져옴
			mav.addObject("firststore",firststore);
			mav.addObject("secondstore",secondstore);
			mav.addObject("bean", bean);
			mav.addObject("lists", lists);
			mav.addObject("month",month); //현재 날짜 바인딩, 혹은 검색하고 싶은 날 바인딩
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