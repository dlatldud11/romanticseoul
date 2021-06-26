package controller.board;

import java.io.File;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import bean.Member;
import bean.QnaBoard;
import controller.common.SuperClass;
import dao.BoardDao;

@Controller
public class QnaUpdateController extends SuperClass {
	private final String command = "/qnaBoUpdate.bo";
	private ModelAndView mav = null;
	private String redirect = "redirect:/qnaBoUpdate.bo";

	@Autowired
	@Qualifier("bdao")
	private BoardDao dao;

	public QnaUpdateController() {
		super("qnaBoUpdate", "qnaBoList");
		this.mav = new ModelAndView();
	}

	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "qnaseq", required = true) int qnaseq){
		
		// 여기서 xxx는 현재 수정하고자 하는 이전에 기입했던 게시물 1건을 의미합니다.
		QnaBoard xxx = dao.SelectDataByPk(qnaseq);
		
		this.mav.addObject("bean", xxx);
				
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("qnaBoard") @Valid QnaBoard xxx,
			BindingResult asdf,
			HttpServletRequest request){
		
		if (asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println(asdf);
			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.getpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			MultipartFile multi = xxx.getFile() ;
			String uploadPath = "/WEB-INF/upload" ;
			//realPath :  
			String realPath = request.getRealPath(uploadPath) ;
			System.out.println(realPath);			
			
			try {
				File destination = utility.Utility.getUploadedFileInfo(multi, realPath)  ;
				
				multi.transferTo(destination);
				mav.setViewName(this.redirect) ;				
				
				xxx.setImage(destination.getName());
				this.dao.InsertData(xxx);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
				mav.setViewName("") ;
				
			} catch (Exception e) {				
				e.printStackTrace();
				mav.setViewName(this.redirect) ;
			}
		}			
		return this.mav ;
	}
}
