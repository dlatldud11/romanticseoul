package controller.mall;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Menu;
import bean.Myplan;
import bean.Store;
import controller.common.SuperClass;
//import dao.BoardDao;
import dao.MallDao;
import dao.ProductDao;
import utility.DrinkAPI;
import utility.EatAPI;
import utility.LookAPI;

@Controller
public class ZzimListController extends SuperClass{
	private final String command = "/zzimList.ma" ; 
	private ModelAndView mav = null ;
	private String redirect = "./main.co" ;
	
	@Autowired
	@Qualifier("malldao")
	private MallDao mdao ;

	@Autowired
	@Qualifier("pdao")
	private ProductDao pdao ;
	
	private EatAPI eapi;
	private DrinkAPI dapi;
	private LookAPI lapi;
	
	public ZzimListController() {
		super("zzimList", "zzimList");
		this.mav = new ModelAndView();
		this.eapi = new EatAPI();
		this.dapi = new DrinkAPI();
		this.lapi = new LookAPI();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request){
		List<Myplan> myplanlists = this.mdao.SelectMyplans(id); //찜목록 가져오기
		List<Menu> menulists = new ArrayList<Menu>(); // 찜한 가게별 메뉴목록 가져오기
		List<Store> storelists = new ArrayList<Store>(); // 찜목록에 있는 가게 정보 가져오기
		
		for(Myplan bean : myplanlists) { 
			String mode = "";
			String keyword = "";
			
			// eat,drink,look 분기처리
			if( !(bean.getEatid() == null || bean.getEatid().isBlank())) {
				mode = "eat";
				keyword = bean.getEatid();
				Store store = new Store();
				store = this.eapi.geteatByPk(keyword);
				storelists.add(store);
			}
			if(!(bean.getDrinkid() == null || bean.getDrinkid().isBlank())) {
				mode = "drink";
				keyword = bean.getDrinkid();
				Store store = new Store();
				store = this.dapi.getDrinkByPk(keyword);
				storelists.add(store);
			}
			if(!(bean.getLookid() == null || !bean.getLookid().isBlank())) {
				mode = "look";
				keyword = bean.getLookid();
				Store store = new Store();
				store = this.lapi.getLookByPk(keyword);
				storelists.add(store);
			}
			List<Menu> lists = this.pdao.SelectDataList3(mode,keyword);
			menulists.addAll(lists); // 각 가게별로 메뉴 가져와서 합치기
		}
		
		this.mav.addObject("myplanlists",myplanlists);
		this.mav.addObject("menulists",menulists);
		this.mav.addObject("storelists",storelists);
		this.mav.setViewName(super.getpage);
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(){
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}
}