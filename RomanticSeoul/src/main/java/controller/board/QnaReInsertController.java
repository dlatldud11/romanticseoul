package controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.QnaBoard;
import controller.common.SuperClass;
import dao.BoardDao;



@Controller
public class QnaReInsertController extends SuperClass{
	private final String command = "/qnaBoReply.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/qnaDetailView.bo" ;
	
//	private BoInsertController reply;
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao ;
	
	public QnaReInsertController() {
		super("qnaDetailView", "qnaDetailView");
		this.mav = new ModelAndView();
	}
//	@ResponseBody
//	@RequestMapping(value="idCheck.do", produces = "application/String; charset=utf-8")
//	//적어주기만 하면 무조건 session에 넘어간다 (의존성)
//	public String idCheck(String id, HttpSession session) {
//		String str = "오케이";
//		return str;	
//	}
	
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(){	
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("qnaBoard") @RequestParam(value="qnaseq",required=false) int qnaseq,
			@Valid QnaBoard xxx,
			BindingResult asdf,
			HttpServletRequest request){
		
		if (asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println(asdf);
			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.getpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			System.out.println(xxx.toString());
			this.dao.ReplyInsertData(xxx);
			this.mav.setViewName(super.postpage);
		}		
		return this.mav ;
	}
}