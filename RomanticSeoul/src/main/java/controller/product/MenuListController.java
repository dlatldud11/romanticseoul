package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Menu;
import bean.Store;
import controller.common.SuperClass;
import dao.ProductDao;
import dao.TypeDao;
import utility.DrinkAPI;
import utility.EatAPI;
import utility.FlowParameters;
import utility.LookAPI;
import utility.Paging;

@Controller
public class MenuListController extends SuperClass{
	private final String command = "/menuList.pr" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/menuList.pr" ;
	
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao dao ;

	@Autowired
	@Qualifier("tdao")
	private TypeDao tdao  ;

	
	private DrinkAPI dapi;
	private EatAPI eapi;
	private LookAPI lapi;
	
	
	@ModelAttribute("gulists")
	public List<CheckBean> drink(){
		List<CheckBean> gulists = this.tdao.GetList("menu", "gu") ;
		return gulists ;
	}
	@ModelAttribute("eatlists")
	public List<CheckBean> drink1(){
		List<CheckBean> gulists = this.tdao.GetList("stores", "eat") ;
		return gulists ;
	}
	@ModelAttribute("drinklists")
	public List<CheckBean> drink2(){
		List<CheckBean> gulists = this.tdao.GetList("stores", "drink") ;
		return gulists ;
	}
	@ModelAttribute("looklists")
	public List<CheckBean> drink3(){
		List<CheckBean> gulists = this.tdao.GetList("stores", "look") ;
		return gulists ;
	}
	public MenuListController() {
		super("menuList", null);
		this.mav = new ModelAndView();
		this.eapi = new EatAPI();
		this.lapi = new LookAPI();
		this.dapi = new DrinkAPI();
	}
	
	
	@GetMapping(command)
	public ModelAndView doGet(
			HttpServletRequest request,
			@RequestParam(value = "pageNumber", required = false) String pageNumber, 
			@RequestParam(value = "pageSize", required = false) String pageSize,
			@RequestParam(value = "mode", required = false) String mode, //eat,look,drink
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "gulists", required = false) String gulists){
		
		System.out.println(mode);
		// ???????????? ?????? ????????? ?????? ??????????????? ?????? ????????????.
		FlowParameters parameters 
			= new FlowParameters(pageNumber, pageSize, mode, keyword);
		
		// ???????????? ????????? ?????? ??????
		System.out.println(this.getClass() + " : " + parameters.toString());
		
		int totalCount 
		= dao.SelectTotalCount(
				parameters.getMode(), 
				parameters.getKeyword());
	
		System.out.println("totalCount : " + totalCount );
		
		String contextpath = request.getContextPath() + "/" ;
		String myurl = contextpath +  this.command ;
		
		Paging pageInfo 
			= new Paging(
					parameters.getPageNumber(), 
					parameters.getPageSize(), 
					totalCount, 
					myurl, 
					parameters.getMode(), 
					parameters.getKeyword());
		
		List<Menu> lists = dao.SelectDataList(
				pageInfo.getOffset(),
				pageInfo.getLimit(),
				parameters.getMode(), 
				parameters.getKeyword()) ;
				// "%" ???????????? like ????????? ????????? ???????????????.
		System.out.println("ddd");
		System.out.println("[" + parameters.getMode() + "]");	
		System.out.println(gulists);
		
		if(!(parameters.getMode().equals(null) || parameters.getMode().equals("null")|| parameters.getMode().equals(""))) {
			if(parameters.getMode().equals("eat")) {
				List<Store> eatlists = this.eapi.geteatGulist(gulists); // eat ???????????? ??? ????????? ???????????? ?????????
				mav.addObject("storelists",eatlists);
				System.out.println("a");
			}else if(parameters.getMode().equals("look")) {
				List<Store> looklists = this.lapi.getlookGulist(gulists); // eat ???????????? ??? ????????? ???????????? ?????????
				mav.addObject("storelists",looklists);
				System.out.println("b");
			}else if(parameters.getMode().equals("drink")) {
				List<Store> drinklists = this.dapi.getdrinkGulist(gulists); // eat ???????????? ??? ????????? ???????????? ?????????
				mav.addObject("storelists",drinklists);
				System.out.println("c");
			}
		}
		// ??????????????? ??? ?????????
		mav.addObject("lists", lists); // ????????? ??????
		
		// ????????? ?????? ?????????
		mav.addObject("pagingHtml", pageInfo.getPagingHtml());
		mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		// ?????? ????????? ?????? ??? ????????? ?????? ?????????  
		mav.addObject("mode", parameters.getMode());
		mav.addObject("keyword", parameters.getKeyword());
		
		// ?????? ??????, ??????, ??????, ?????? ?????? ????????? ????????? parameter list ?????????
		mav.addObject("parameters", parameters.toString());		
			
		this.mav.setViewName(super.postpage);
		return this.mav ;
	}	
	
}
