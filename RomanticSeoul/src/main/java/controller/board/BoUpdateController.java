package controller.board;

<<<<<<< HEAD
public class BoUpdateController {

}
=======
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bean.BoardBoard;
import controller.common.SuperClass;
import dao.BoardBoardDao;
import dao.BoardDao;

@Controller
public class BoUpdateController extends SuperClass{
	private final String command = "/boUpdate.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/main.co" ;
	
	@Autowired
	@Qualifier("bbdao")
	private BoardBoardDao dao ;
	
	public BoUpdateController() {
		super("boList", "boList");
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(){		
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(
			@ModelAttribute("boardBoard") @Valid BoardBoard xxx,
			BindingResult asdf,
			HttpServletRequest request){
		if (asdf.hasErrors()) {
			System.out.println("유효성 검사에 문제 있슴");
			System.out.println(asdf);
			this.mav.addObject("bean", xxx);	
			this.mav.setViewName(super.getpage);
			
		} else {
			System.out.println("유효성 검사에 문제 없슴");
			System.out.println("boupdate 컨트롤러"+xxx.toString());
			this.dao.UpdateData(xxx);
			this.mav.setViewName(super.postpage);
		}		
		return this.mav ;
	}
}
>>>>>>> branch 'master' of https://github.com/dlatldud11/romanticseoul.git
