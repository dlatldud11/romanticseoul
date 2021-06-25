package controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
//import dao.BoardDao;

@Controller
public class CoBoListController extends SuperClass{
	private final String command = "/coBoList.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "./main.co" ;
	
//	@Autowired
//	@Qualifier("bdao")
//	private BoardDao dao ;
	
	public CoBoListController() {
		super("coBoList", "coBoList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(){		
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(){
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}