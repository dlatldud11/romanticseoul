package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.BoardBoardDao;
import dao.BoardDao;


public class BoInsertController extends SuperClass{
	private final String command = "/boInsert.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/main.co" ;
	
	@Autowired
	@Qualifier("bbdao")
	private BoardBoardDao dao ;
	
	public BoInsertController() {
		super("blList", "boList");
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