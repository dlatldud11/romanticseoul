package controller.member;

<<<<<<< HEAD
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Member;
import bean.Type;
import controller.common.SuperClass;
import dao.MemberDao;
import dao.TypeDao;


@Controller
public class MeUpdateController extends SuperClass{
	private final String command = "/update.me" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/update.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao dao ;
	
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
	
	public MeUpdateController() {
		super("meupdate", "meupdate");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id){
		
		// 여기서 xxx는 현재 수정하고자 하는 이전에 기입했던 게시물 1건을 의미합니다.
		Member xxx = dao.SelectDataByPk(id);
		
		this.mav.addObject("bean", xxx);
				
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("member") @Valid Member xxx,
			BindingResult asdf,
			HttpServletRequest request) {
		
		if ( asdf.hasErrors() ) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println( asdf );
			mav.setViewName(super.getpage) ;
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
		if (xxx.getImage().equals("") || xxx.getImage().equals(null) || xxx.getImage().equals("null"))  { // 파일 업로드 안했을 때
			
			mav.setViewName(super.postpage) ;				
			this.dao.UpdateData(xxx);
		
		} else {

			MultipartFile multi = xxx.getFile() ;
			String uploadPath = "/WEB-INF/upload" ;
			
			//realPath :  
			String realPath = request.getRealPath(uploadPath) ;
			System.out.println("realPath"+realPath);
			System.out.println("멀티"+multi.toString());
			try {
				// 업로드 폴더에 파일을 업로드합니다.
				File destination = utility.Utility.getUploadedFileInfo(multi, realPath)  ;
				
				multi.transferTo(destination);
				
				// response.sendRedirect("list.al")와 등가의 개념
				mav.setViewName(super.postpage) ;				
				
				System.out.println(this.getClass() + " 회원 추가하기 command 객체 정보");
				System.out.println(xxx.toString());				
				
				// 원래 이미지에 날짜를 붙인 새 이미지 이름
				xxx.setImage(destination.getName());
				
				// dao를 이용하여 데이터 베이스에 행을 추가합니다.
				this.dao.UpdateData(xxx);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
				mav.setViewName(super.getpage) ;
				
			} catch (Exception e) {				
				e.printStackTrace();
				mav.setViewName(super.getpage) ;
			}
		}// 파일 업로드 했을 때 끝
			
		}
		return this.mav;
	}
}
=======
public class MeUpdateController {

}
>>>>>>> branch 'master' of https://github.com/dlatldud11/romanticseoul.git
