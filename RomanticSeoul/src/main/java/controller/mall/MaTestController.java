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
import utility.HelloOpenAPI;
import zzim.MyCartList;

@Controller
public class MaTestController extends SuperClass {
	private final String command = "/test.ma" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.mall" ;
	
	@Autowired
	@Qualifier("API")
	private HelloOpenAPI api;
//	@Autowired
//	@Qualifier("cdao")
//	private CompositeDao dao ; 
	
	@Autowired
	@Qualifier("malldao")
	private MallDao dao;
	
	public MaTestController() {
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
		}else {
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
