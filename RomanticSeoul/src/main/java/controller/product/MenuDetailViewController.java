package controller.product;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.Combo1;
import bean.Menu;
import controller.common.SuperClass;
import dao.ProductDao;
import utility.DrinkAPI;
import utility.EatAPI;
import utility.FlowParameters;
import utility.LookAPI;

@Controller
public class MenuDetailViewController extends SuperClass{
	private final String command = "/menuDetailView.pr" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/menuList.pr" ;
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao dao ;
	
	private DrinkAPI dapi;
	private LookAPI lapi;
	private EatAPI eapi;
	
	
	public MenuDetailViewController() {
		super("menuDetailView", "menuList");
		this.mav = new ModelAndView();
		this.dapi = new DrinkAPI();
		this.lapi = new LookAPI();
		this.eapi = new EatAPI();
	}
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "storeseq", required = false) String storeseq,
			@RequestParam(value = "pageNumber", required = false) String pageNumber, 
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpSession session,
			HttpServletRequest request){
		System.out.println("menuDetailViewController 들어옴");
		
		FlowParameters parameters 
			= new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		if(!(parameters.getMode().equals(null) || parameters.getMode().equals("null")|| parameters.getMode().equals(""))) {
				List<Combo1> lists = this.dao.SelectDataList2(mode, storeseq);
				System.out.println("storeseq 나왔는지 확인"+storeseq);
				mav.addObject("lists",lists);
				mav.addObject("mode",mode); // eat, look, drink 구별가능하게하기
				System.out.println("리스트 나왔는지 확인 :"+lists.size());
			mav.addObject("storeseq",storeseq); // 해당 가게의 기본키
		}
		System.out.println(this.getClass() + " : " + parameters.toString());
		mav.setViewName(super.getpage);
		
		return this.mav ;
	}
}
