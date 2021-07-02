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

import bean.Board;
import bean.BoardBoard;
import bean.Reply;
import controller.common.SuperClass;
import dao.BoardBoardDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class BoReInsertController extends SuperClass{ 
	private final String command = "/boReInsert.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "./main.co" ;
	
	@Autowired
	@Qualifier("bbdao")
	private BoardBoardDao dao ;
	
	public BoReInsertController() {
		super("boList", "boList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			HttpServletRequest request,
			@RequestParam(value = "pageNumber", required = false) String pageNumber, 
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "keyword", required = false) String keyword){
		return this.mav;
	}
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("reply") @Valid Reply xxx,
			BindingResult asdf,
			HttpServletRequest request){
		this.dao.InsertReply(xxx);
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}