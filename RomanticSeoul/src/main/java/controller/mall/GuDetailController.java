package controller.mall;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Store;
import controller.common.SuperClass;
import dao.ProductDao2;
import utility.DrinkAPI;
import utility.EatAPI;
import utility.LookAPI;
import utility.MyplanList;

@Controller
public class GuDetailController extends SuperClass {
	private final String command = "/guDetail.ma";
	private ModelAndView mav = null;
	private String redirect = "./main.co";

	@Autowired
	@Qualifier("ppdao")
	private ProductDao2 dao;
	
	private EatAPI eapi;
	private DrinkAPI dapi;
	private LookAPI lapi;

	public GuDetailController() {
		super("guDetail", null);
		this.mav = new ModelAndView();
		this.eapi = new EatAPI();
		this.dapi = new DrinkAPI();
		this.lapi = new LookAPI();
	}

	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "storeseq", required = true) String storeseq,
			@RequestParam(value = "mode", required = true) String mode,
			HttpSession session){
		switch(mode) {
		case "eat":
			List<Store> eatgulists = (List<Store>)session.getAttribute("eatgulists");
			if(eatgulists == null || eatgulists.isEmpty()) {
				System.out.println("eatgulists 새로 만들기 들어옴 구디테일");
				MyplanList myplan = (MyplanList)session.getAttribute("myplan");
				Store store = new Store();
				eatgulists = new ArrayList<Store>();
				store = this.eapi.geteatByPk(storeseq);
				System.out.println("store : "+store.toString()+"/"+storeseq);
				eatgulists.add(store);
				this.mav.addObject("eatgulists",eatgulists);
			}
			break;
		case "drink":
			List<Store> drinkgulists = (List<Store>)session.getAttribute("drinkgulists");
			if(drinkgulists == null || drinkgulists.isEmpty()) {
				MyplanList myplan = (MyplanList)session.getAttribute("myplan");
				Store store = new Store();
				drinkgulists = new ArrayList<Store>();
				store = this.dapi.getDrinkByPk(storeseq);
				drinkgulists.add(store);
				this.mav.addObject("drinkgulists",drinkgulists);
			}
			break;
		case "look":
			List<Store> lookgulists = (List<Store>)session.getAttribute("lookgulists");
			if(lookgulists == null || lookgulists.isEmpty()) {
				MyplanList myplan = (MyplanList)session.getAttribute("myplan");
				Store store = new Store();
				lookgulists = new ArrayList<Store>();
				store = this.lapi.getLookByPk(storeseq);
				lookgulists.add(store);
				this.mav.addObject("lookgulists",lookgulists);
			}
			break;
		}
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
