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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bean.Menu;
import bean.Stock;
import controller.common.SuperClass;
import dao.ProductDao;

@Controller
public class MenuInsertController extends SuperClass{
	private final String command = "/menuInsert.pr" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/menuList.pr" ;
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao dao ;
	
	public MenuInsertController() {
		super("menuInsert", "menuList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet()
	{		
		this.mav.setViewName(super.getpage);
		System.out.println("MenuinsertController");
		System.out.println("doGet 메소드");
		return this.mav;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("menu") @Valid Menu xxx,
			@ModelAttribute("stock") @Valid Stock yyy,
			BindingResult asdf,
			HttpServletRequest request){
		System.out.println("Menu 들어왔는지 확인 "+xxx.toString());
		System.out.println("Stock 들어왔는지 확인 "+yyy.toString());
		if(asdf.hasErrors())
		{
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println(asdf);
			this.mav.addObject("menu", xxx);	
			this.mav.setViewName(super.getpage);
			
		}
		else{
			System.out.println("유효성 검사에 문제 없슴");
			System.out.println("이미지 사진 : " + xxx.getImage());
			if (xxx.getImage().equals("") || xxx.getImage().equals(null) || xxx.getImage().equals("null"))  { // 파일 업로드 안했을 때
				
				mav.setViewName(super.getpage) ;				
				this.dao.InsertData(xxx); //메뉴 등록
				// 재고 등록
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
				this.dao.InsertData(xxx);
				
			}
			catch (IllegalStateException e)
			{				
				e.printStackTrace();
				mav.setViewName("");
				
			}
			catch (Exception e)
			{				
				e.printStackTrace();
				mav.setViewName(this.redirect);
			}
		}
		}
		return this.mav;
	}
}

