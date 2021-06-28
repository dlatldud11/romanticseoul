package controller.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.BoardBoardDao;
import dao.BoardDao;

@Controller
public class BoDeleteController extends SuperClass{
	private final String command = "/bodelete.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/boList.bo" ;
	
	@Autowired
	@Qualifier("bbdao")
	private BoardBoardDao dao ;
	
	public BoDeleteController() {
		super("boList", "boList");
		this.mav = new ModelAndView();
	}
	@ResponseBody
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "boseq", required = true) int boseq){
		int cnt = -999999 ;
		cnt = dao.DeleteData(boseq) ;
 		
		this.mav.setViewName(this.redirect);
		return this.mav ;
	}
	
	@ResponseBody
	@PostMapping(command)
	public ModelAndView doPost(@RequestParam Map <String, Object>param,
			HttpServletRequest request){
		this.dao.DeleteDataByBoseq(param);
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}
