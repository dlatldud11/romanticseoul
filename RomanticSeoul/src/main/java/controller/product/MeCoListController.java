package controller.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.CheckBean;
import bean.Menu;
import bean.Store;
import controller.common.SuperClass;
import dao.MemberDao;
import dao.ProductDao;
import dao.TypeDao;
import utility.CombineAPI;
import utility.GetXYData;

@Controller
public class MeCoListController extends SuperClass {
	private final String command = "/meCoList.pr" ;
	private ModelAndView mav = null ;
	private final String redirect = "redirect:/수정02.me" ;
	
	@Autowired
	@Qualifier("mdao")
	private MemberDao mdao  ; 
	
	@Autowired
	@Qualifier("tdao")
	private TypeDao tdao;
	
	@Autowired
	@Qualifier("pdao")
	private ProductDao pdao;
	
	private GetXYData gapi;
	private CombineAPI capi; // api 합쳐서 보내기
	
	@ModelAttribute("gulists")
	public List<CheckBean> gulist(){
		List<CheckBean> gulists = this.tdao.GetList("menu", "gu") ;
		return gulists ;
	}
	
	public MeCoListController() {
		super("result", "result");
		this.mav = new ModelAndView();
		this.gapi = new GetXYData();
		this.tdao = new TypeDao();
		this.capi = new CombineAPI();
	}
	
	@GetMapping(command)
	public ModelAndView doGet() {
		return this.mav ;
	}
	
	@PostMapping(command)
	public ModelAndView doPost(
			@RequestParam(value = "address", required = true) String address,
			@RequestParam(value = "first", required = false) String first,
			@RequestParam(value = "second", required = false) String second,
			@RequestParam(value = "third", required = false) String third) {
		String gu = null;
		List<CheckBean> gulists = gulist();
		List<Store> finalfirst = new ArrayList<Store>();
		List<Store> finalsecond = new ArrayList<Store>();
		List<Store> finalthird = new ArrayList<Store>();
		
		for(CheckBean bean : gulists) {
			if(address.contains(bean.getMykey())) {
				gu = bean.getMykey();
			}
		}
		System.out.println("주소 : " + gu);
		System.out.println("first :" + first);
		System.out.println("second :" + second);
		System.out.println("third :" + third);
		
		if(!(first.isEmpty() || second.isEmpty() || third.isEmpty())) {
			List<Store> firstlists = this.capi.getMeCoLists(first, gu);
			List<Store> secondlists = this.capi.getMeCoLists(second, gu);
			List<Store> thirdlists = this.capi.getMeCoLists(third, gu);
			
			String[] firsts = first.split("/");
			String[] seconds = second.split("/");
			String[] thirds = third.split("/");
			
			List<Menu> firstapilist = this.pdao.SelectDataByGuCate(firsts[0], gu);
			List<Menu> secondapilist = this.pdao.SelectDataByGuCate(seconds[0], gu);
			List<Menu> thirdapilist = this.pdao.SelectDataByGuCate(thirds[0], gu);
			// 각 선택지별로 구, 카테고리가 같은 가게 리스트를 가져옴, api 에게는 구별과 eat,look,drink 별로 가져옴
			
			for(Store bean : firstlists) { // 첫번째 코스 api와 다오에서 가져온 값중에 교집합만 최종 리스트에 넣기
				for(Menu menu : firstapilist) {
					if(bean.getCategory().equals(menu.getDrinkid()) ||bean.getCategory().equals(menu.getEatid())
							|| bean.getCategory().equals(menu.getLookid())) {
						finalfirst.add(bean);
					System.out.println("첫번째 코스 교집합 부분 들어옴");
					}
				}
			}
			for(Store bean : secondlists) { // 두번째 코스 api와 다오에서 가져온 값중에 교집합만 최종 리스트에 넣기
				for(Menu menu : secondapilist) {
					if(bean.getCategory().equals(menu.getDrinkid()) ||bean.getCategory().equals(menu.getEatid())
							|| bean.getCategory().equals(menu.getLookid())) {
						finalsecond.add(bean);
					}
				}
			}
			for(Store bean : thirdlists) { // 세번째 코스 api와 다오에서 가져온 값중에 교집합만 최종 리스트에 넣기
				for(Menu menu : thirdapilist) {
					if(bean.getCategory().equals(menu.getDrinkid()) ||bean.getCategory().equals(menu.getEatid())
							|| bean.getCategory().equals(menu.getLookid())) {
						finalthird.add(bean);
					}
				}
			}
			
		}//if문 끝 
		// 좌표 가져오기..
		List<Object> firstaddrlist = new ArrayList<Object>(); //첫번째 코스 좌표
		List<Object> secondaddrlist = new ArrayList<Object>(); // 두번째 코스 좌표
		List<Object> thirdaddrlist = new ArrayList<Object>(); // 세번째 코스 좌표
		for(Store bean : finalfirst) {
			Map<String,Object> firstaddr = new HashMap<String,Object>();
			if(bean.getAddress1().isBlank()) {
				firstaddr = gapi.addToCoord(bean.getAddress2()); // 입력한 주소 좌표값 찾기 (look용)
			}else {
				firstaddr = gapi.addToCoord(bean.getAddress1()); // 입력한 주소 좌표값 찾기
			}
			firstaddr.put("name", bean.getName());
			firstaddr.put("storeseq", bean.getStoreseq());
			firstaddrlist.add(firstaddr);
			System.out.println("Map 이 List 안에 들어왔는지 확인"+ firstaddrlist.get(0).toString());
		}
		for(Store bean : finalsecond) {
			Map<String,Object> secondaddr = new HashMap<String,Object>();
			if(bean.getAddress1().isBlank()) {
				secondaddr = gapi.addToCoord(bean.getAddress2()); // 입력한 주소 좌표값 찾기 (look용)
			}else {
				secondaddr = gapi.addToCoord(bean.getAddress1()); // 입력한 주소 좌표값 찾기
			}
			secondaddr.put("name", bean.getName());
			secondaddr.put("storeseq", bean.getStoreseq());
			secondaddrlist.add(secondaddr);
		}
		for(Store bean : finalthird) {
			Map<String,Object> thirdaddr = new HashMap<String,Object>();
			if(bean.getAddress1().isBlank()) {
				thirdaddr = gapi.addToCoord(bean.getAddress2()); // 입력한 주소 좌표값 찾기 (look용)
			}else {
				thirdaddr = gapi.addToCoord(bean.getAddress1()); // 입력한 주소 좌표값 찾기
			}
			thirdaddr.put("name", bean.getName());
			thirdaddr.put("storeseq", bean.getStoreseq());
			thirdaddrlist.add(thirdaddr);
		}
		
		Map<String,Object> addr = gapi.addToCoord(address); // 입력한 주소 좌표값 찾기
		
		mav.addObject("x",addr.get("x"));
		mav.addObject("y",addr.get("y"));
		mav.addObject("gu",gu);
		mav.setViewName(super.postpage);
		return this.mav ;
	}
	
	/**
	 * Calculates the distance in km between two lat/long points
	 * using the haversine formula
	 */
	public double haversine(
	        double lat1, double lng1, double lat2, double lng2) { //첫번째는 기준, 두번째가 비교군
	    int r = 6371; // average radius of the earth in km
	    double dLat = Math.toRadians(lat2 - lat1);
	    double dLon = Math.toRadians(lng2 - lng1);
	    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	       Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
	      * Math.sin(dLon / 2) * Math.sin(dLon / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double d = r * c;
	    return d;
	}
}


