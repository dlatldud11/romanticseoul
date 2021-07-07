package controller.product;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	private final String redirect = "redirect:/main.co" ;
	
	
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
			@RequestParam(value = "third", required = false) String third,
			HttpSession session) {
		String gu = null;
		List<CheckBean> gulists = gulist();
		List<Store> finalfirst = new ArrayList<Store>(); // 최종적으로 담길 리스트들
		List<Store> finalsecond = new ArrayList<Store>();
		List<Store> finalthird = new ArrayList<Store>();
		// third 없이, eat,drink 만 구현 (주소, 위경도 값 문제 때문)
		for(CheckBean bean : gulists) {
			if(address.contains(bean.getMykey())) {
				gu = bean.getMykey();
			}
		}
		System.out.println("주소 : " + gu);
		System.out.println("first :" + first);
		System.out.println("second :" + second);
		
		String[] firsts = first.split("/"); //eat 과 카테고리 나눔
		String[] seconds = second.split("/");
		
		if(!(first.isEmpty() || second.isEmpty())) { // eat,drink,look / 구 / 카테고리 담음
			List<Store> firstlists = this.capi.getMeCoLists(first, gu);
			List<Store> secondlists = this.capi.getMeCoLists(second, gu);
			
			System.out.println("값나뉜지확인"+firsts[0]+"/"+firsts[1]);
			List<Menu> firstapilist = this.pdao.SelectDataByGuCate(firsts[0], gu);
			List<Menu> secondapilist = this.pdao.SelectDataByGuCate(seconds[0], gu);
			
//			mav.addObject("firstlists",firstlists);
//			mav.addObject("secondlists",secondlists);
//			mav.addObject("thirdlists",thirdlists); // 실험용으로 내보내
			
//			System.out.println("디비에서 값 나왔는지 확인"+firstapilist.get(0).getStoreseq());
			// 각 선택지별로 구, 카테고리가 같은 가게 리스트를 가져옴, dao 에게는 구별과 eat,look,drink 별로 가져옴
			
			for(Store bean : firstlists) { // 첫번째 코스 api와 다오에서 가져온 값중에 교집합만 최종 리스트에 넣기
				for(Menu menu : firstapilist) {
					if(bean.getStoreseq().equals(menu.getDrinkid()) ||bean.getStoreseq().equals(menu.getEatid())
							|| bean.getStoreseq().equals(menu.getLookid())) {
						finalfirst.add(bean);
					}
				}
			}
			for(Store bean : secondlists) { // 두번째 코스 api와 다오에서 가져온 값중에 교집합만 최종 리스트에 넣기
				for(Menu menu : secondapilist) {
					if(bean.getStoreseq().equals(menu.getDrinkid()) ||bean.getStoreseq().equals(menu.getEatid())
							|| bean.getStoreseq().equals(menu.getLookid())) {
						finalsecond.add(bean);
					}
				}
			}
			System.out.println("교집합 완성되었는지 확인"+finalfirst.size()+"/"+finalsecond.size());
		}//if문 끝 
		// 좌표 가져오기..
		List<Map<String,Object>> addrlist = new ArrayList<Map<String,Object>>(); // 코스 좌표 (첫번째,두번째,세번째 합침)
		for(Store bean : finalfirst) {
			Map<String,Object> firstaddr = new HashMap<String,Object>();
			if(bean.getAddress1() == null || bean.getAddress1().isBlank()) {
				firstaddr = gapi.addToCoord(bean.getAddress2()); // 입력한 주소 좌표값 찾기 (look용)
			}else {
				firstaddr = gapi.addToCoord(bean.getAddress1()); // 입력한 주소 좌표값 찾기
			}
			firstaddr.put("name", bean.getName());
			firstaddr.put("storeseq", bean.getStoreseq());
			firstaddr.put("first", firsts[0]);
			firstaddr.put("mode", "first"); //mode에 first라고 넣어두기
			firstaddr.put("storeseq", bean.getStoreseq()); //mode에 first라고 넣어두기
			
			addrlist.add(firstaddr);
		}
		for(Store bean : finalsecond) {
			Map<String,Object> secondaddr = new HashMap<String,Object>();
			if(bean.getAddress1() == null || bean.getAddress1().isBlank()) {
				secondaddr = gapi.addToCoord(bean.getAddress2()); // 입력한 주소 좌표값 찾기 (look용)
			}else {
				secondaddr = gapi.addToCoord(bean.getAddress1()); // 입력한 주소 좌표값 찾기
			}
			secondaddr.put("name", bean.getName());
			secondaddr.put("storeseq", bean.getStoreseq());
			secondaddr.put("second", seconds[0]);
			secondaddr.put("mode", "second"); //mode에 first라고 넣어두기
			secondaddr.put("storeseq", bean.getStoreseq()); //mode에 first라고 넣어두기
			addrlist.add(secondaddr);
		}
		Map<String,Object> addr = gapi.addToCoord(address); // 입력한 주소 좌표값 찾기
		
		ArrayList<Double> firstlength = new ArrayList();
		ArrayList<Double> secondlength = new ArrayList();
		
		for(Map<String,Object> bean : addrlist) { // 첫번째 두번째 세번째 좌표
			double length = haversine(Double.parseDouble((String)addr.get("y")),Double.parseDouble((String)addr.get("x")),
					Double.parseDouble((String)bean.get("y")),Double.parseDouble((String)bean.get("x")));
			System.out.println("길이 제대로 나오는지 확인 : "+length+"/"+bean.get("name")+"/"+bean.get("storeseq")+"/"+bean.get("mode"));
			bean.put("length", length); // 각 addr 마다 길이 담아놓음
			if(bean.get("mode").equals("first")) {
				firstlength.add(length);// first 들어있으면 거기에 담기
			}else if(bean.get("mode").equals("second")) {
				secondlength.add(length);
			}
		}
		System.out.println("각 순서마다 길이값 들어왔는지 확인 :"+firstlength.size()+"/"+secondlength.size());
		// 오름차순으로 거리 정렬하기
		Collections.sort(firstlength); //거리 값만 있음
		Collections.sort(secondlength);
		System.out.println("각 순서마다 오름차순 정렬되었는지 확인 :"+firstlength.size()+"/"+secondlength.size());
//		System.out.println("각 순서마다 오름차순 정렬되었는지 확인 :"+firstlength.get(0)+"/"+firstlength.get(1));
		// 5순위까지만 남기고 자르기
		List<Double> firstfive = firstlength;
		List<Double> secondfive = secondlength;
		if(firstlength.size() > 5) { // 리스트가 5순위보다 더 있으면 자르기 
			firstfive = firstlength.subList(0,5);
		}
		if(secondlength.size() > 5) {
			secondfive = secondlength.subList(0,5);
		}
		System.out.println("서브리스트 완료"+firstfive.size()+"/"+secondfive.size());
		System.out.println(firstfive.toString()+"/"+secondfive.toString());
		// 1~3 등까지만 남기고 나머지 다 지우기
		
		List<String> finalfirstseq = new ArrayList<String>(); // 순위권에 든 가게의 기본키를 받아오기
		List<String> finalsecondseq = new ArrayList<String>();
		for(Map<String,Object> bean : addrlist) {
//			System.out.println("for문 돌아가는지 확인"+bean.get("mode"));
			switch((String)bean.get("mode")) {
				case "first" : 
					for(int i=0; i<firstfive.size(); i++) { // 각 배열마다 길이가 달라서 따로 포문을 만듬
						if((double)bean.get("length") == firstfive.get(i)) { // first 이면서 순위권 안에 든 길이를 가지고 있으면
							System.out.println("첫번째 포문"+i+"/"+firstfive.get(i)+"/"+bean.get("name"));
							finalfirstseq.add((String)bean.get("storeseq")); //순위권대로 리스트에 기본키 담기
						}
					}
					break;
				case "second" :
					for(int i=0; i<secondfive.size(); i++) { // 각 배열마다 길이가 달라서 따로 포문을 만듬
						if((double)bean.get("length") == secondfive.get(i)) { // second 이면서 순위권 안에 든 길이를 가지고 있으면
							System.out.println("두번째 포문"+i+"/"+secondfive.get(i)+"/"+bean.get("name"));
							finalsecondseq.add((String)bean.get("storeseq")); //순위권대로 리스트에 기본키 담기
						}
					}
					break;
				}
			
		}//for문 끝
		System.out.println("순위권 시퀀스 담겼는지 확인 : "+finalfirstseq.size()+"/"+finalsecondseq.size());
		// 순위권 시퀀스를 마브에 담아서 준다. 메뉴와 api 교집합 된 리스트를 마브에 담는다. 1등시퀀스만 따로 mav에 담는다. jsp에 뿌린다.
		session.setAttribute("first",finalfirst); //교집합 된 부분
		session.setAttribute("second",finalsecond);
		
		session.setAttribute("firstrank",finalfirstseq); // 5위까지 담아놓은 것(시퀀스)
		session.setAttribute("secondrank",finalsecondseq); // 5위까지 담아놓은 것(시퀀스)
		
		session.setAttribute("firsttop",finalfirstseq.get(0)); // 1위(시퀀스)
		session.setAttribute("secondtop",finalsecondseq.get(0)); // 1위(시퀀스)
		mav.setViewName(redirect);
		return this.mav ;
	}
	
	/**
	 * Calculates the distance in km between two lat/long points
	 * using the haversine formula
	 */
	public double haversine(
	        double lat1, double lng1, double lat2, double lng2) { //첫번째는 기준, 두번째가 비교군 lat 위도 Y/ lng 경도 X
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