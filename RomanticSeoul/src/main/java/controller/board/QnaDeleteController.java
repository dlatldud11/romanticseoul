package controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.BoardDao;

@Controller
public class QnaDeleteController extends SuperClass{
	private final String command = "/qnaBoDelete.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/qnaBoList.bo" ;
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao ;
	
	public QnaDeleteController() { 
		super("qnaBoList", "qnaBoList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "qnaseq", required = true) int qnaseq){
		int cnt = -999999 ;
		cnt = dao.DeleteData(qnaseq) ;
 		
		this.mav.setViewName(this.redirect);
		return this.mav ;
	}
}
