package controller.mall;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.Drink;
import bean.Eat;
import bean.Look;
import bean.Member;
import bean.Store;
import controller.common.SuperClass;
import dao.MallDao;
import utility.DrinkAPI;
import utility.EatAPI;
import utility.LookAPI;
import zzim.MyCartList;

@Controller
public class MaTypeController extends SuperClass {
	private final String command = "/eatlist.ma" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.mall" ;
	
	private EatAPI eapi;
	
	private LookAPI lapi;
	
	private DrinkAPI dapi;
//	@Autowired
//	@Qualifier("cdao")
//	private CompositeDao dao ; 
	
	@Autowired
	@Qualifier("malldao")
	private MallDao dao;
	
	public MaTypeController() {
		super("mapexample", "eatlist");
		this.mav = new ModelAndView();
		this.eapi = new EatAPI();
		this.lapi = new LookAPI();
		this.dapi = new DrinkAPI();
		
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		System.out.println("MaTest doGet 들어옴");
		List<Eat>checks = this.dao.selectEat();
		
		if(checks.isEmpty()) {
			ArrayList<String> eatlists = eapi.geteatlist();
			System.out.println("eatlists "+eatlists.size());
			for(String eatlist : eatlists) {
				this.dao.InsertEat(eatlist);
			}
			checks = this.dao.selectEat();
		}
		System.out.println("checks 에 내용 들어있음"+checks.size());
		//System.out.println(checks.get(0).getEatid());
		for(Eat eat : checks) {
			System.out.println(eat);
		}
		mav.addObject("eatlists",checks);
		mav.setViewName(super.postpage);
		return this.mav ;
	}
	
	
	@GetMapping("/looklist.ma")
	public ModelAndView doGet2() {
		System.out.println("MaTest doGet2 들어옴");
		
		List<Look>checks = this.dao.selectLook();
		
		if(checks.isEmpty()) {
			System.out.println("checks에 값 안 들어있음");
			ArrayList<String> looklists = lapi.getLooklists();
			System.out.println("looklists "+looklists.size());
			for(String looklist : looklists) {
				this.dao.InsertLook(looklist);
			}
			checks = this.dao.selectLook();
		}
		System.out.println("checks 에 내용 들어있음"+checks.size());
		for(Look look : checks) {
			System.out.println(look);
		}
		mav.addObject("looklists",checks);
		mav.setViewName(super.postpage);
		return this.mav ;
	}
	
	@GetMapping("/drinklist.ma")
	public ModelAndView doGet3() {
		System.out.println("MaTest doGet3 들어옴");
		List<Drink>checks = this.dao.selectDrink();
		
		if(checks.isEmpty()) {
			List<String> drinklists = dapi.getDrinkLists();
			System.out.println("drinklists "+drinklists.size());
			for(String drinklist : drinklists) {
				this.dao.InsertDrink(drinklist);
			}
			checks = this.dao.selectDrink();
		}
		System.out.println("checks 에 내용 들어있음"+checks.size());
		for(Drink drink : checks) {
			System.out.println(drink);
		}
		mav.addObject("drinklists",checks);
		mav.setViewName(super.postpage);
		return this.mav ;
	}
	
	@ResponseBody
	@PostMapping("/eatgulist.ma")
	public ModelAndView doGet4(HttpServletRequest request,
			@RequestParam(value = "gu", required = true) String gu
			,HttpSession session) {
		System.out.println("MaTest doGet4 들어옴");
		ArrayList<Store> eatlists = eapi.geteatGulist(gu);
		System.out.println("eapi 가 리스트 다 가져옴");
//		mav.addObject("eatgulists",eatlists);
		session.setAttribute("eatgulists", eatlists); 
		mav.setViewName(super.postpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			HttpSession session) {
		
		Member loginfo = (Member)session.getAttribute("loginfo")  ;
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart")  ;
		
		
		return this.mav ;
	}
}
