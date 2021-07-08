package controller.member;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;
import dao.TypeDao;


@Controller
public class MeUpdateController extends SuperClass{
	private final String command = "/update.me" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/meinfo.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao ;
	
	@Autowired
	@Qualifier("tdao")
	private TypeDao tdao  ;
	
	@ModelAttribute("member")
	public Member mymember() {
		return new Member() ;
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
	
	public MeUpdateController() {
		super("meupdate", "meInfo");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id){
		
		// 여기서 xxx는 현재 수정하고자 하는 이전에 기입했던 게시물 1건을 의미합니다.
		Member bean = mdao.SelectDataByPk(id);
		
		this.mav.addObject("bean", bean);
				
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("member") @Valid Member xxx,
			BindingResult asdf) {
		
		if (asdf.hasErrors()) { // failure
			System.out.println("유효성 검사에 문제가 있슴");
			System.out.println(xxx.toString());
			System.out.println(asdf.toString());
			this.mav.addObject("bean", xxx) ;
			this.mav.setViewName(super.getpage);
			
		} else { // success
			System.out.println("유효성 검사에 문제가 없슴");      
			int cnt = -99999 ;
			cnt = mdao.UpdateData(xxx) ;
			this.mav.setViewName(super.postpage); 
		}
		return this.mav ;
	}
}
