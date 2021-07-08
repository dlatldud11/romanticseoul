package controller.product;

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

import bean.Menu;
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
		Menu xxx = dao.SelectDataByPk(menuseq);
		
		this.mav.addObject("bean", xxx);
				
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("menu") @Valid Menu xxx,
			BindingResult asdf){
		
		if ( asdf.hasErrors() ) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println( asdf );
			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.getpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			System.out.println("업데이트 확인 문구");
			int cnt = -999999 ;
			cnt = dao.UpdateData(xxx) ;
			
			// request 객체의 내용을 보존하면서 목록 보기 페이지로 넘겨 줍니다.
			this.mav.setViewName(this.redirect);
		}	
		
		return this.mav ;
	}
}