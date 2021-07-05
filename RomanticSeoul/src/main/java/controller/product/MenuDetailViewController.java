package controller.product;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.Store;
import bean.Type;
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
	
	@ModelAttribute("type")
	public Type mytype() {
		return new Type() ;
	}
	public MenuDetailViewController() {
		super("menuDetailView", "menuBoList");
		this.mav = new ModelAndView();
		this.dapi = new DrinkAPI();
		this.lapi = new LookAPI();
		this.eapi = new EatAPI();
	}
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "storeseq", required = true) String storeseq,
			@RequestParam(value = "pageNumber", required = false) String pageNumber, 
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpSession session){
		
		
		FlowParameters parameters 
			= new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		if(!(parameters.getMode().equals(null) || parameters.getMode().equals("null")|| parameters.getMode().equals(""))) {
			if(parameters.getMode().equals("eat")) {
				Store bean = this.eapi.geteatByPk(storeseq); // eat 선택했을 때 구별로 가져오는 메소드
				mav.addObject("bean",bean);
				System.out.println("a");
			}else if(parameters.getMode().equals("look")) {
				Store bean = this.lapi.getLookByPk(storeseq); // eat 선택했을 때 구별로 가져오는 메소드
				mav.addObject("bean",bean);
				System.out.println("b");
			}else if(parameters.getMode().equals("drink")) {
				Store bean = this.dapi.getDrinkByPk(storeseq); // eat 선택했을 때 구별로 가져오는 메소드
				mav.addObject("bean",bean);
				System.out.println("c");
			}
		}
		System.out.println(this.getClass() + " : " + parameters.toString());
		mav.setViewName(super.getpage);
		
		return this.mav ;
	}
}
