package controller.member;

import java.io.File;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Member;
import controller.common.SuperClass;
import dao.MemberDao;
import dao.TypeDao;

@Controller
public class MeInsertController extends SuperClass {
	private final String command = "/insert.me" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/main.co" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ; 
	
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
	
	public MeInsertController() {
		super("meinsert", "meLoginForm");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("member") @Valid Member xxx,
			BindingResult asdf,
			HttpServletRequest request) {
		
		if ( asdf.hasErrors() ) {
			System.out.println("????????? ????????? ?????? ??????");
			System.out.println( asdf );
			mav.setViewName(super.getpage) ;
			
		} else {
			System.out.println("????????? ????????? ?????? ??????");
		if (xxx.getImage().equals("") || xxx.getImage().equals(null) || xxx.getImage().equals("null"))  { // ?????? ????????? ????????? ???
			
			mav.setViewName(super.postpage) ;				
			this.mdao.InsertData(xxx);
		
		} else {

			MultipartFile multi = xxx.getFile() ;
			String uploadPath = "/WEB-INF/upload" ;
			
			//realPath :  
			String realPath = request.getRealPath(uploadPath) ;
			System.out.println("realPath"+realPath);
			System.out.println("??????"+multi.toString());
			try {
				// ????????? ????????? ????????? ??????????????????.
				File destination = utility.Utility.getUploadedFileInfo(multi, realPath)  ;
				
				multi.transferTo(destination);
				
				// response.sendRedirect("list.al")??? ????????? ??????
				mav.setViewName(super.postpage) ;				
				
				System.out.println(this.getClass() + " ?????? ???????????? command ?????? ??????");
				System.out.println(xxx.toString());				
				
				// ?????? ???????????? ????????? ?????? ??? ????????? ??????
				xxx.setImage(destination.getName());
				
				// dao??? ???????????? ????????? ???????????? ?????? ???????????????.
				this.mdao.InsertData(xxx);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
				mav.setViewName(super.getpage) ;
				
			} catch (Exception e) {				
				e.printStackTrace();
				mav.setViewName(super.getpage) ;
			}
		}// ?????? ????????? ?????? ??? ???
			
		}
		return this.mav;
	}

		
	
//	@PostMapping(command)
//	public ModelAndView doPost(
//			@ModelAttribute("member") @Valid Member xxx, BindingResult asdf) {
//		// ????????? ????????? ???????????? ????????? ????????? ???????????? ?????????.
//		if (asdf.hasErrors()) {
//			System.out.println("????????? ????????? ????????? ??????");
//			System.out.println(xxx.toString());
//			System.out.println(asdf.toString());
//			mav.addObject("bean", xxx) ;
//			mav.setViewName(super.getpage);
//			
//		} else {
//			System.out.println("????????? ????????? ????????? ??????");
//			int cnt = -99999 ;
//			cnt = mdao.InsertData(xxx) ;
//			
//			mav.setViewName(redirect);
//		}
//		return this.mav ;
//	}	
}


