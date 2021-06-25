package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.Board;
import bean.Member;
import bean.QnaBoard;
import controller.common.SuperClass;
import dao.BoardDao;
import utility.FlowParameters;
import utility.Paging;

@Controller
public class QnaListController extends SuperClass {
//	@GetMapping("/qnaBoList.bo")
//	public ModelAndView doGet(){
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("qnaBoList");
//		return mav;
//	}
	private final String command = "/qnaBoList.bo" ; 
	private ModelAndView mav = null ;
	private String redirect = "redirect:/qnaBoList.bo" ;
	
	@Autowired
	@Qualifier("bdao")
	private BoardDao dao ;
	
	public QnaListController() {
		super("qnaBoList", null);
		this.mav = new ModelAndView();
	}
	
	@GetMapping(command)
	public ModelAndView doGet(
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "pageSize", required = false) String pageSize,
			HttpServletRequest request) {
		
//		int totalCount = this.dao.SelectTotalCount() ;
//		System.out.println(this.getClass() + " totalCount : " + totalCount); 
//		
//		String myrul = request.getContextPath() + "/qnaBoList.bo" ;
//		
//		// 회원 목록은 페이징 처리는 하되, 필드 검색 기능은 구현하지 않도록 합니다.		
//		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, myrul, null, null)  ;
//		
//		List<QnaBoard> lists = dao.SelectDataList(pageInfo.getOffset(), pageInfo.getLimit()) ;
		List<QnaBoard> lists = dao.SelectDataList2() ;
		System.out.println("members size : " + lists.size());		
		
		this.mav.addObject("lists", lists);
		
//		this.mav.addObject("pagingHtml", pageInfo.getPagingHtml()); 
//		this.mav.addObject("pagingStatus", pageInfo.getPagingStatus());
		
		this.mav.setViewName(super.getpage);
		
		return this.mav ;
	}
}
