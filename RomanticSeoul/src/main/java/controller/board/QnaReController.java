package controller.board ;

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

import bean.Board;
import bean.QnaBoard;
import bean.Reply;
import controller.common.SuperClass;
import dao.BoardDao;

@Controller
public class QnaReController extends SuperClass{
	private final String command = "/reply.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/qnaDetailView.bo" ;
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao ;
	
	@ModelAttribute("Reply")
	public Reply reply() {
		return new Reply();
	}
	
	public QnaReController() {
		super("reply", "qnaDetailView");
		this.mav = new ModelAndView();
	}
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(){		
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(
		@ModelAttribute("board")
		@RequestParam(value="qnaseq",required=false) int qnaseq,
		@Valid QnaBoard xxx,
		BindingResult asdf){		
		
		if ( asdf.hasErrors() ) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println( asdf );
			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.getpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			int cnt = -999999 ;

			System.out.println(xxx.toString());
			
			cnt = dao.ReplyInsertData(xxx) ;
			
			
			// request 객체의 내용을 보존하면서 목록 보기 페이지로 넘겨 줍니다.
			this.mav.setViewName(this.redirect);
		}	
		
		return this.mav ;
	}
}