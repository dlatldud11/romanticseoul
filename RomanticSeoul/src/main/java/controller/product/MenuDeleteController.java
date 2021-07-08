package controller.product;

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

import bean.Menu;
import controller.common.SuperClass;
import dao.ProductDao;

@Controller
public class MenuDeleteController extends SuperClass{ 
	private final String command = "/menuDelete.pr" ; 
	private ModelAndView mav = null ;
	private String redirect = "./menuList.pr" ;
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao dao ;
	
	public MenuDeleteController() {
		super("menuList", "menuList");
		this.mav = new ModelAndView();
	}
	
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(
			HttpServletRequest request,
			@RequestParam(value = "menuseq", required = true) int menuseq ){
		dao.DeleteDataByMenuseq(menuseq);
		return this.mav;
	}
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("menu") @Valid Menu xxx,
			BindingResult asdf,
			HttpServletRequest request){
		System.out.println("BoReDelete 컨트롤러 두포스트 : "+xxx.toString());
		this.dao.DeleteDataByMenuseq(xxx.getMenuseq());
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}