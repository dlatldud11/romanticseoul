package controller.board;

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

import bean.Reply;
import controller.common.SuperClass;
import dao.BoardBoardDao;

@Controller
public class BoReDeleteController extends SuperClass{ 
	private final String command = "/boRedelete.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "./main.co" ;
	
	@Autowired
	@Qualifier("bbdao")
	private BoardBoardDao dao ;
	
	public BoReDeleteController() {
		super("boList", "boList");
		this.mav = new ModelAndView();
	}
	
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(
			HttpServletRequest request,
			@RequestParam(value = "replyseq", required = true) int replyseq ){
		dao.DeleteDataByReplyseq(replyseq);
		return this.mav;
	}
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("reply") @Valid Reply xxx,
			BindingResult asdf,
			HttpServletRequest request){
		System.out.println("BoReInsert 컨트롤러 두포스트 : "+xxx.toString());
		this.dao.InsertReply(xxx);
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}