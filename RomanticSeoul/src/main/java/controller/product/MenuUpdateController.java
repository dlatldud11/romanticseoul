package controller.product;

import java.io.File;

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

import bean.Combo1;
import bean.Menu;
import bean.Stock;
import controller.common.SuperClass;
import dao.ProductDao;


@Controller
public class MenuUpdateController extends SuperClass {
	private final String command = "/menuUpdate.pr";
	private ModelAndView mav = null;
	private String redirect = "redirect:/menuDetailView.pr";

	@Autowired
	@Qualifier("pdao")
	private ProductDao dao;

	public MenuUpdateController () {
		super("menuUpdate", "menuDetailView");
		this.mav = new ModelAndView();
	}

	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "menuseq", required = true) int menuseq){
		
		// 여기서 xxx는 현재 수정하고자 하는 이전에 기입했던 게시물 1건을 의미합니다.
		Combo1 xxx = dao.SelectDataByPk(menuseq);
		
		this.mav.addObject("bean", xxx);
				
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("menu") @Valid Menu xxx,
			@ModelAttribute("stock") @Valid Stock yyy,
			BindingResult asdf,
			HttpServletRequest request){
		
		if ( asdf.hasErrors() ) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println( asdf );
			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.postpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			System.out.println("업데이트 확인 문구");
			if (xxx.getImage().equals("") || xxx.getImage().equals(null) || xxx.getImage().equals("null"))  { // 파일 업로드 안했을 때
				System.out.println("파일 업로드 안함");
				int cnt = -999999 ;
				cnt = dao.UpdateData(xxx) ;
				cnt = dao.UpdateDataStock(yyy) ;
				// request 객체의 내용을 보존하면서 목록 보기 페이지로 넘겨 줍니다.
				this.mav.setViewName(super.postpage);
			}
			else
				{
					MultipartFile multi = xxx.getFile();
					String uploadPath = "/WEB-INF/upload";
					//realPath :  
					String realPath = request.getRealPath(uploadPath) ;
					System.out.println(realPath);			
					
					try {
						File destination = utility.Utility.getUploadedFileInfo(multi, realPath);
						
						multi.transferTo(destination);
						mav.setViewName(this.redirect);				
						
						xxx.setImage(destination.getName());
						int cnt = -999999 ;
						cnt = this.dao.UpdateData(xxx) ;
						cnt = this.dao.UpdateDataStock(yyy);
						this.mav.setViewName(super.getpage);
						
					}
					catch (IllegalStateException e)
					{				
						e.printStackTrace();
						mav.setViewName(this.redirect);
						
					}
					catch (Exception e)
					{				
						e.printStackTrace();
						mav.setViewName(this.redirect);
					}
			}
			}
		return this.mav ;
	}
}