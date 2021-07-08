package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Menu;
import controller.common.SuperClass;
import dao.ProductDao;
import dao.TypeDao;

@Controller
public class MenuDeleteController extends SuperClass{ 
	private final String command = "/menuDelete.pr" ; 
	private ModelAndView mav = null ;
	private String redirect = "./menuList.pr" ;
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao dao ;
	
	@Autowired
	@Qualifier("tdao")
	private TypeDao tdao  ;

	@ModelAttribute("gulists")
	public List<CheckBean> drink(){
		List<CheckBean> gulists = this.tdao.GetList("menu", "gu") ;
		return gulists ;
	}
	@ModelAttribute("eatlists")
	public List<CheckBean> drink1(){
		List<CheckBean> gulists = this.tdao.GetList("stores", "eat") ;
		return gulists ;
	}
	@ModelAttribute("drinklists")
	public List<CheckBean> drink2(){
		List<CheckBean> gulists = this.tdao.GetList("stores", "drink") ;
		return gulists ;
	}
	@ModelAttribute("looklists")
	public List<CheckBean> drink3(){
		List<CheckBean> gulists = this.tdao.GetList("stores", "look") ;
		return gulists ;
	}
	
	public MenuDeleteController() {
		super("menuList", "menuList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "menuseq", required = true) int menuseq ,
			HttpServletRequest request){
		dao.DeleteDataByMenuseq(menuseq);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("menu") @Valid Menu xxx,
			BindingResult asdf,
			HttpServletRequest request){
		System.out.println("MenuDelete 컨트롤러 두포스트 : "+xxx.toString());
		this.dao.DeleteDataByMenuseq(xxx.getMenuseq());
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}