package controller.mall;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.common.SuperClass;
import dao.ProductDao2;

@Controller
public class GuDetailController extends SuperClass {
	private final String command = "/guDetail.ma";
	private ModelAndView mav = null;
	private String redirect = "./main.co";

	@Autowired
	@Qualifier("ppdao")
	private ProductDao2 dao;

	public GuDetailController() {
		super("guDetail", null);
		this.mav = new ModelAndView();
	}

	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "storeseq", required = true) String storeseq,
			@RequestParam(value = "mode", required = true) String mode,
			HttpSession session){
		this.mav.addObject("storeseq",storeseq);
		this.mav.addObject("mode",mode);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}

	@PostMapping(command)
	public ModelAndView doPost() {
		this.mav.setViewName(super.postpage);
		return this.mav;
	}
}
