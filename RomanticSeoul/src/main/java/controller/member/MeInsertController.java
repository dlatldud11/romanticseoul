package controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Member;
import bean.Type;
import controller.common.SuperClass;
//import dao.MemberDao;
import dao.TypeDao;

@Controller
public class MeInsertController extends SuperClass {
	private final String command = "/insert.me" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.me" ;
	
//	@Autowired
//	@Qualifier("mdao")
//	private MemberDao mdao  ; 
	
	@Autowired
	@Qualifier("tdao")
	private TypeDao tdao  ;
	
	@ModelAttribute("member")
	public Member mymember() {
		return new Member() ;
	}
	
	@ModelAttribute("type")
	public Type mytype() {
		return new Type() ;
	}
	@ModelAttribute("drinklist")
	public List<CheckBean> drink(){
		List<CheckBean> lists = this.tdao.GetList("stores", "drink") ;
		return lists ;
	}
	@ModelAttribute("eatlist")
	public List<CheckBean> eat(){
		List<CheckBean> lists = this.tdao.GetList("stores", "eat") ;
		return lists ;
	}
	@ModelAttribute("playlist")
	public List<CheckBean> play(){
		List<CheckBean> lists = this.tdao.GetList("stores", "play") ;
		return lists ;
	}
	@ModelAttribute("walklist")
	public List<CheckBean> walk(){
		List<CheckBean> lists = this.tdao.GetList("stores", "walk") ;
		return lists ;
	}
	@ModelAttribute("looklist")
	public List<CheckBean> aaa(){
		List<CheckBean> lists = this.tdao.GetList("stores", "look") ;
		return lists ;
	}
	
	@ModelAttribute("genderlist")
	public List<CheckBean> bbb(){
		List<CheckBean> lists = this.tdao.GetList("members", "gender") ;
		return lists ;
	}
	@ModelAttribute("emaillist")
	public List<CheckBean> ccc(){
		List<CheckBean> lists = this.tdao.GetList("members", "email") ;
		return lists ;
	}
	
	public MeInsertController() {
		super("meinsert", "main");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost() {
		return this.mav ;
	}	
}


