package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import bean.Member;
import bean.QnaBoard;
import bean.Store;
import controller.common.SuperClass;
import dao.ProductDao2;
import utility.DrinkAPI;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class CoBoListController extends SuperClass {
	private final String command = "/coBoList.bo";
	private ModelAndView mav = null;
	private String redirect = "./main.co";

	@Autowired
	@Qualifier("ppdao")
	private ProductDao2 dao;

	public CoBoListController() {
		super("coBoList", null);
		this.mav = new ModelAndView();
	}

	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "storeseq", required = true) String storeseq,
			HttpSession session){
		this.mav.addObject("storeseq",storeseq);
		this.mav.setViewName(super.getpage);
		return this.mav;
	}

	@PostMapping(command)
	public ModelAndView doPost() {
		this.mav.setViewName(super.postpage);
		return this.mav;
	}
}