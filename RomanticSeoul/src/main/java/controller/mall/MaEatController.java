package controller.mall;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.Eat;
import bean.Member;
import controller.common.SuperClass;
import dao.MallDao;
import utility.EatAPI;
import zzim.MyCartList;

@Controller
public class MaEatController extends SuperClass {
	private final String command = "/test.ma" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.mall" ;
	
	private EatAPI api;
//	@Autowired
//	@Qualifier("cdao")
//	private CompositeDao dao ; 
	
	@Autowired
	@Qualifier("malldao")
	private MallDao dao;
	
	public MaEatController() {
		super("mapexample", "eatlist");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		System.out.println("MaTest doGet 들어옴");
		List<Eat>checks = this.dao.selectEat();
		
		if(checks.isEmpty()) {
			ArrayList<String> eatlists = api.geteatlist();
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
	
	@PostMapping(command)
	public ModelAndView doPost(
			HttpSession session) {
		
		Member loginfo = (Member)session.getAttribute("loginfo")  ;
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart")  ;
		
		
		return this.mav ;
	}
}
